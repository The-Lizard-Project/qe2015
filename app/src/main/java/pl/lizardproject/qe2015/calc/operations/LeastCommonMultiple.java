package pl.lizardproject.qe2015.calc.operations;

public class LeastCommonMultiple implements Operation {

    public static Long greatestCommonDivisor(Long x, Long y) {
        if(x == 0 || y == 0) {
            return 0l;
        }
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
        return 5;
    }

    @Override
    public String toString() {
        return "LCM";
    }

    @Override
    public double execute(Double l, Double r) {
        return (l * r) / greatestCommonDivisor(l.longValue(), r.longValue());
    }

    @Override
    public boolean requiresBothArguments() {
        return true;
    }
}