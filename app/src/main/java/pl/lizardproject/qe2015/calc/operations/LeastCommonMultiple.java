package pl.lizardproject.qe2015.calc.operations;

public class LeastCommonMultiple implements Operation {


    public static Long greatestCommonDivisor(Long x, Long y) {
        while(x != y) {
            if(x > y)
                x -= y;
            else
                y -= x;
        }
        return x;
    }

    @Override
    public int getPriority() {
        return -1;
    }

    @Override
    public String toString() {
        return "LCM";
    }

    @Override
    public double execute(Double l, Double r) {
        if(l == 0 || r == 0 || l.equals(Double.NaN) || r.equals(Double.NaN)) {
            return Double.NaN;
        }
        return (l * r) / greatestCommonDivisor(l.longValue(), r.longValue());
    }

    @Override
    public boolean requiresBothArguments() {
        return true;
    }
}