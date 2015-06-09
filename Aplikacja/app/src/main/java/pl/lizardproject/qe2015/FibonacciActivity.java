package pl.lizardproject.qe2015;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pl.lizardproject.qe2015.calc.operations.Fibonacci;
import pl.lizardproject.qe2015.calc.structure.TreePrinter;


public class FibonacciActivity extends FunctionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondNumber.setVisibility(View.GONE);
        functionButton.setText("Fibonacci");
        previousFunctionButton.setText("Regular calculator");
        nextFunctionButton.setText("Gcd");
    }

    @Override
    protected void functionButtonClicked() {
        try {
            equation.addNumber(getFirstNumber());
            equation.addOperation(new Fibonacci());
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
        startActivity(new Intent(this, GcdActivity.class));
    }
}
