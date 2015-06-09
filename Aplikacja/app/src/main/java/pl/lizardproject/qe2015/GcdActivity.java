package pl.lizardproject.qe2015;

import android.content.Intent;
import android.os.Bundle;

import pl.lizardproject.qe2015.calc.operations.GreatestCommonDivisor;
import pl.lizardproject.qe2015.calc.structure.TreePrinter;

public class GcdActivity extends FunctionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        functionButton.setText("Greatest common denominator");
        previousFunctionButton.setText("Fibonacci");
        nextFunctionButton.setText("Lcm");
    }

    @Override
    protected void functionButtonClicked() {
        try {
            equation.addNumber(getFirstNumber());
            equation.addOperation(new GreatestCommonDivisor());
            equation.addNumber(getSecondNumber());
            final Double evaluate = equation.evaluate();
            outcome.setText(TreePrinter.df.format(evaluate));
        } catch (NumberFormatException ignored) {
            equation.clear();
        }
    }

    @Override
    protected void prevFunctionButtonClicked() {
        onBackPressed();
    }

    @Override
    protected void nextFunctionButtonClicked() {
        startActivity(new Intent(this, LcmActivity.class));
    }
}