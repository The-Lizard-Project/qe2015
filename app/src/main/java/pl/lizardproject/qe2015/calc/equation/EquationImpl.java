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
        this.operation = operation;
    }

    private boolean correctOperation() {
        return (lBuilder.isValid() && rBuilder.isValid() && operation != null) || (rBuilder.isValid() && operation != null);
    }

    @Override
    public void setListener(PrintListener listener) {
        this.listener = listener;
    }


    private void pushToTree() {
        if(!correctOperation()) {
            return;
        }
        if(lBuilder.isValid()) {
            tree.addOperation(operation, lBuilder.getDigit(), rBuilder.getDigit());
        } else {
            tree.addOperation(operation, rBuilder.getDigit());
        }
        cleanupState();
    }

    private void printEquation() {
        tree.resetVisits();
        listener.printed(TreePrinter.printThatTree(tree));
    }


    private void cleanupState() {
        lBuilder.reset();
        rBuilder.reset();
        operation = null;
    }

    @Override
    public Double evaluate() {
        pushToTree();
        return tree.root.calculate();
    }

    @Override
    public String print() {
        tree.resetVisits();
        final String equation = TreePrinter.printThatTree(tree) + " = " + evaluate();
        listener.printed(equation);
        return equation;
    }

    @Override
    public void clear() {
        cleanupState();
        tree.root = null;
        printEquation();
    }
}
