package pl.lizardproject.qe2015;

import android.widget.TextView;

import butterknife.InjectView;
import butterknife.OnClick;
import pl.lizardproject.qe2015.calc.operations.Fibonacci;
import pl.lizardproject.qe2015.calc.operations.GreatestCommonDivisor;
import pl.lizardproject.qe2015.calc.operations.LeastCommonMultiple;
import pl.lizardproject.qe2015.calc.operations.Prime;

public class ExtendedActivity extends MainActivity {

    @InjectView(R.id.calculatorViewPort)
    protected TextView viewPort;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_extended;
    }

    @OnClick(R.id.buttonFib)
    protected void buttonFibClicked() {
        equation.addOperation(new Fibonacci());
    }

    @OnClick(R.id.buttonLcm)
    protected void buttonLcmClicked() {
        equation.addOperation(new LeastCommonMultiple());
    }

    @OnClick(R.id.buttonGcd)
    protected void buttonGcdClicked() {
        equation.addOperation(new GreatestCommonDivisor());
    }

    @OnClick(R.id.buttonPri)
    protected void buttonPriClicked() {
        equation.addOperation(new Prime());
    }

    @Override
    public void printed(String equation) {
        viewPort.setText(equation);
    }
}
