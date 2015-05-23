package pl.lizardproject.qe2015.calc.operations;

public class Substract implements Operation {

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public double execute(Double l, Double r) {
        return l - r;
    }

    @Override
    public String toString() {
        return "-";
    }

}
