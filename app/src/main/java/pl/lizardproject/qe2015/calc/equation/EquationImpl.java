package pl.lizardproject.qe2015.calc.equation;

import java.util.ArrayList;
import java.util.List;

import pl.lizardproject.qe2015.calc.operations.Operation;

/**
 * ONP style calculator
 */
public class EquationImpl implements Equation {

    private List<Operation> operations = new ArrayList<>();

    @Override
    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    @Override
    public Double evaluate() {
        return null;
    }
}
