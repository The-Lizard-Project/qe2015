package pl.lizardproject.qe2015.calc.equation;

import pl.lizardproject.qe2015.calc.operations.Operation;

public interface Equation {

    void addOperation(Operation operation);

    Double evaluate();

}
