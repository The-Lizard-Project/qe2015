package pl.lizardproject.qe2015.calc.equation;

public class NumberBuilder {

    private Double currentNumber = 0d;

    public void addDigit(Double digit) {
        if(currentNumber == null) {
            currentNumber = 0d;
        }
        currentNumber = currentNumber * 10 + digit;
    }

    public Double getDigit() {
        return currentNumber;
    }

    public void reset() {
        currentNumber = null;
    }

    public boolean isValid() {
        return currentNumber != null;
    }
}
