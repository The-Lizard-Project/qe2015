package pl.lizardproject.qe2015.calc.equation;

import pl.lizardproject.qe2015.calc.operations.Operation;
import pl.lizardproject.qe2015.calc.structure.PrintListener;
import pl.lizardproject.qe2015.calc.structure.Tree;
import pl.lizardproject.qe2015.calc.structure.TreePrinter;

public class EquationImpl implements Equation {

    private Tree tree;
    private Double lValue;
    private Double rValue;
    private Operation operation;
    private PrintListener listener;

    public EquationImpl() {
        tree = new Tree();
        cleanupState();
    }

    @Override
    public void addNumber(Double value) {
        if(operation == null && lValue == null) {
            lValue = value;
        } else {
            rValue = value;
        }
        if(correctOperation()) {
            pushToTree();
        }
        printEquation();
    }

    private void printEquation() {
        tree.resetVisits();
        listener.printed(TreePrinter.printThatTree(tree));
    }

    private boolean correctOperation() {
        return (lValue != null && rValue != null && operation != null) || (rValue != null && operation != null);
    }

    @Override
    public void setListener(PrintListener listener) {
        this.listener = listener;
    }

    @Override
    public void addOperation(Operation operation) {
        this.operation = operation;
    }

    private void pushToTree() {
        if(lValue != null) {
            tree.addOperation(operation, lValue, rValue);
        } else {
            tree.addOperation(operation, rValue);
        }
        cleanupState();
    }

    private void cleanupState() {
        lValue = null;
        rValue = null;
        operation = null;
    }

    @Override
    public Double evaluate() {
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
