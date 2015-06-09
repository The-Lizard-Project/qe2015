package pl.lizardproject.qe2015.calc.equation;

import pl.lizardproject.qe2015.calc.operations.Operation;
import pl.lizardproject.qe2015.calc.structure.PrintListener;
import pl.lizardproject.qe2015.calc.structure.Tree;
import pl.lizardproject.qe2015.calc.structure.TreePrinter;

public class EquationImpl implements Equation {

    private final Tree tree;
    private Operation operation;
    private NumberBuilder lBuilder;
    private NumberBuilder rBuilder;
    private PrintListener listener;

    public EquationImpl() {
        tree = new Tree();
        lBuilder = new NumberBuilder();
        rBuilder = new NumberBuilder();
        cleanupState();
    }

    @Override
    public void addNumber(Double value) {
        if(operation == null) {
            lBuilder.addDigit(value);
        } else {
            rBuilder.addDigit(value);
        }
        printEquation();
    }

    @Override
    public void addOperation(Operation operation) {
        if(correctOperation()) {
            pushToTree();
            cleanupState();
        }
        if(tree.isEmpty() && !lBuilder.isValid()) {
            addNumber(0d);
        }
        this.operation = operation;
        printEquation();
    }

    private boolean correctOperation() {
        return (lBuilder.isValid() && rBuilder.isValid() && operation != null) || !tree.isEmpty() && (rBuilder.isValid() && operation != null) || (operation != null && !operation.requiresBothArguments());
    }

    @Override
    public void setListener(PrintListener listener) {
        this.listener = listener;
    }

    private void pushToTree() {
        if(!operation.requiresBothArguments()) {
            if(lBuilder.isValid()) {
                tree.addOperation(operation, lBuilder.getDigit(), -69);
            } else {
                tree.addOperation(operation);
            }
        } else {
            if(lBuilder.isValid()) {
                tree.addOperation(operation, lBuilder.getDigit(), rBuilder.getDigit());
            } else if(rBuilder.isValid()) {
                tree.addOperation(operation, rBuilder.getDigit());
            }
        }
        cleanupState();
    }

    private void printEquation() {
        tree.resetVisits();
        String equation = TreePrinter.printThatTree(tree);
        equation += lBuilder.isValid() ? TreePrinter.df.format(lBuilder.getDigit()) + " " : "";
        equation += operation == null ? "" : operation.toString() + " ";
        equation += rBuilder.isValid() ? TreePrinter.df.format(rBuilder.getDigit()) : "";
        listener.printed(equation);
    }

    private void cleanupState() {
        lBuilder.reset();
        rBuilder.reset();
        operation = null;
    }

    @Override
    public Double evaluate() {
        if(!correctOperation()) {
            cleanupState();
        } else {
            pushToTree();
        }
        if(tree.isEmpty()) {
            return 0d;
        }
        double calculated = tree.root.calculate();
        cleanupState();
        tree.root = null;
        return calculated;
    }


    @Override
    public void clear() {
        cleanupState();
        tree.root = null;
        printEquation();
    }
}
