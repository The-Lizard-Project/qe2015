package pl.lizardproject.qe2015.calc.operations;

public class Fibonacci implements Operation {

    @Override
    public int getPriority() {
        return -100;
    }

    @Override
    public double execute(Double l, Double r) {
        return fibonacci(l.intValue());
    }

    @Override
    public String toString() {
        return "FIB";
    }

    private int fibonacci(int n) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
