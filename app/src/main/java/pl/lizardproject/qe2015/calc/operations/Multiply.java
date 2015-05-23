package pl.lizardproject.qe2015.calc.operations;

public class Multiply implements Operation {

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public double execute(Double l, Double r) {
        return l * r;
    }

    @Override
    public String toString() {
        return "*";
    }


}
