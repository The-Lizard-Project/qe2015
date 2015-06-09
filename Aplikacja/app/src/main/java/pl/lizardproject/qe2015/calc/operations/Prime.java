package pl.lizardproject.qe2015.calc.operations;

public class Prime implements Operation {
    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public double execute(Double l, Double r) {
        if(l == 2 || l == 3) {
            return 1;
        }
        if(l % 2 == 0) {
            return 0;
        }
        Long sqrt = (long) (Math.sqrt(l) + 1);
        for(int i = 3; i < sqrt; i += 2) {
            if(l % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Prime";
    }

    @Override
    public boolean requiresBothArguments() {
        return false;
    }
}
