package pl.lizardproject.qe2015;

import android.os.Bundle;
import android.view.View;

import pl.lizardproject.qe2015.calc.operations.Prime;

public class PrimeActivity extends FunctionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondNumber.setVisibility(View.GONE);
        nextFunctionButton.setVisibility(View.GONE);
        functionButton.setText("Prime");
    }

    @Override
    protected void functionButtonClicked() {
        try {
            equation.addNumber(getFirstNumber());
            equation.addOperation(new Prime());
            final Double evaluate = equation.evaluate();
            outcome.setText((evaluate.longValue() == 0) ? "Not prime" : "Prime");
        } catch(NumberFormatException ignored) {
            equation.clear();
        }
    }

    @Override
    protected void prevFunctionButtonClicked() {
        onBackPressed();
    }

}
