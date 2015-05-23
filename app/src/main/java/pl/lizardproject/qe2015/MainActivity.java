package pl.lizardproject.qe2015;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import pl.lizardproject.qe2015.calc.equation.Equation;
import pl.lizardproject.qe2015.calc.equation.EquationImpl;


public class MainActivity extends Activity {
    @InjectView(R.id.calclatorViewPort)
    protected TextView viewPort;

    Equation equation = new EquationImpl();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    @OnClick(R.id.button0)
    protected void button0Clicked() {
    }

    @OnClick(R.id.button1)
    protected void button1Clicked() {

    }

    @OnClick(R.id.button2)
    protected void button2Clicked() {

    }

    @OnClick(R.id.button3)
    protected void button3Clicked() {

    }

    @OnClick(R.id.button4)
    protected void button4Clicked() {

    }

    @OnClick(R.id.button5)
    protected void button5Clicked() {

    }

    @OnClick(R.id.button6)
    protected void button6Clicked() {

    }

    @OnClick(R.id.button7)
    protected void button7Clicked() {

    }

    @OnClick(R.id.button8)
    protected void button8Clicked() {

    }

    @OnClick(R.id.button9)
    protected void button9Clicked() {

    }

    @OnClick(R.id.buttonEq)
    protected void buttonEqClicked() {

    }

    @OnClick(R.id.buttonDiv)
    protected void buttonDivClicked() {

    }

    @OnClick(R.id.buttonSub)
    protected void buttonSubClicked() {

    }

    @OnClick(R.id.buttonAdd)
    protected void buttonAddClicked() {

    }

    @OnClick(R.id.buttonFib)
    protected void buttonFibClicked() {

    }
}
