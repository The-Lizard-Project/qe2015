package pl.lizardproject.qe2015.calc.operations;

public class GreatestCommonDivisor implements Operation {

    @Override
    public int getPriority() {
        return -1;
    }

    @Override
    public double execute(Double l, Double r) {
        if(l == 0 || r == 0 || l.equals(Double.NaN) || r.equals(Double.NaN)) {
            return Double.NaN;
        }
        Long x = l.longValue();
        Long y = r.longValue();
        while(x != y) {
            if(x > y)
                x -= y;
            else
                y -= x;
        }
        return x;
    }

    @Override
    public boolean requiresBothArguments() {
        return true;
    }

    @Override
    public String toString() {
        return "GCD";
    }
}
