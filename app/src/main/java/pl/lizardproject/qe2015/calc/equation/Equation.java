package pl.lizardproject.qe2015.calc.equation;

import pl.lizardproject.qe2015.calc.operations.Operation;
import pl.lizardproject.qe2015.calc.structure.PrintListener;

public interface Equation {

    void setListener(PrintListener listener);

    void addOperation(Operation operation);

    void addNumber(Double value);

    Double evaluate();

    String print();

    void clear();

}
