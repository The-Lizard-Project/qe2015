package pl.lizardproject.qe2015.calc.operations;

public class Divide implements Operation {

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public double execute(Double l, Double r) {
        return l / r;
    }

    @Override
    public boolean requiresBothArguments() {
        return true;
    }

    @Override
    public String toString() {
        return "/";
    }


}
