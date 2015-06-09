package pl.lizardproject.qe2015;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import pl.lizardproject.qe2015.calc.equation.Equation;
import pl.lizardproject.qe2015.calc.equation.EquationImpl;
import pl.lizardproject.qe2015.calc.structure.PrintListener;


public class FunctionActivity extends Activity implements PrintListener {

    @InjectView(R.id.firstNumber)
    protected EditText firstNumber;
    @InjectView(R.id.secondNumber)
    protected EditText secondNumber;
    @InjectView(R.id.outcome)
    protected TextView outcome;
    @InjectView(R.id.function)
    protected Button functionButton;
    @InjectView(R.id.nextFunction)
    protected Button nextFunctionButton;
    @InjectView(R.id.previousFunction)
    protected Button previousFunctionButton;


    protected Equation equation = new EquationImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        ButterKnife.inject(this);
        equation.setListener(this);
    }

    protected double getFirstNumber() {
        return Double.parseDouble(firstNumber.getText().toString());
    }

    protected double getSecondNumber() {
        return Double.parseDouble(secondNumber.getText().toString());
    }

    @OnClick(R.id.function)
    protected void functionButtonClicked() {

    }

    @OnClick(R.id.previousFunction)
    protected void prevFunctionButtonClicked() {

    }

    @OnClick(R.id.nextFunction)
    protected void nextFunctionButtonClicked() {

    }

    @Override
    public void printed(String equation) {
        outcome.setText(equation);
    }
}
