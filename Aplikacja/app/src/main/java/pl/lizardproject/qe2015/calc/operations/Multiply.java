package pl.lizardproject.qe2015.calc.operations;

public class Multiply implements Operation {

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public double execute(Double l, Double r) {
        return l * r;
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public boolean requiresBothArguments() {
        return true;
    }
}
