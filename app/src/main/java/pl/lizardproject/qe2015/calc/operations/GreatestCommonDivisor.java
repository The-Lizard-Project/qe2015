package pl.lizardproject.qe2015.calc.operations;

public class GreatestCommonDivisor implements Operation {
    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public double execute(Double l, Double r) {
        Long x = l.longValue();
        Long y = r.longValue();
        if(l == 0 || r == 0) {
            return 0;
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
    public boolean requiresBothArguments() {
        return true;
    }

    @Override
    public String toString() {
        return "GCD";
    }
}
