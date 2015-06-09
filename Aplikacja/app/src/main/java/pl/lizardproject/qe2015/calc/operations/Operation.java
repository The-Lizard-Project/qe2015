package pl.lizardproject.qe2015.calc.operations;

public interface Operation {

    int getPriority();

    double execute(Double l, Double r);

    boolean requiresBothArguments();

    String toString();

}
