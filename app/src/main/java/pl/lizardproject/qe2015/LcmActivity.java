package pl.lizardproject.qe2015;

import android.content.Intent;
import android.os.Bundle;

import pl.lizardproject.qe2015.calc.operations.LeastCommonMultiple;
import pl.lizardproject.qe2015.calc.structure.TreePrinter;

public class LcmActivity extends FunctionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        functionButton.setText("Least common multiple");
    }

    @Override
    protected void functionButtonClicked() {
        try {
            equation.addNumber(getFirstNumber());
            equation.addOperation(new LeastCommonMultiple());
            equation.addNumber(getSecondNumber());
            final Double evaluate = equation.evaluate();
            outcome.setText(TreePrinter.df.format(evaluate));
        } catch(NumberFormatException ignored) {
            equation.clear();
        }
    }

    @Override
    protected void prevFunctionButtonClicked() {
        onBackPressed();
    }

    @Override
    protected void nextFunctionButtonClicked() {
        startActivity(new Intent(this, PrimeActivity.class));
    }

}
