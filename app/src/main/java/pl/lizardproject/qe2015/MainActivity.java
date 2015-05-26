package pl.lizardproject.qe2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Optional;
import pl.lizardproject.qe2015.calc.equation.Equation;
import pl.lizardproject.qe2015.calc.equation.EquationImpl;
import pl.lizardproject.qe2015.calc.operations.Add;
import pl.lizardproject.qe2015.calc.operations.Divide;
import pl.lizardproject.qe2015.calc.operations.Multiply;
import pl.lizardproject.qe2015.calc.operations.Substract;
import pl.lizardproject.qe2015.calc.structure.PrintListener;
import pl.lizardproject.qe2015.calc.structure.TreePrinter;

public class MainActivity extends Activity implements PrintListener {

    @InjectView(R.id.calculatorViewPort)
    protected TextView viewPort;

    protected Equation equation = new EquationImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.inject(this);
        equation.setListener(this);
    }

    protected
    @LayoutRes
    int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.button0)
    protected void button0Clicked() {
        equation.addNumber(0d);
    }

    @OnClick(R.id.button1)
    protected void button1Clicked() {
        equation.addNumber(1d);
    }

    @OnClick(R.id.button2)
    protected void button2Clicked() {
        equation.addNumber(2d);
    }

    @OnClick(R.id.button3)
    protected void button3Clicked() {
        equation.addNumber(3d);
    }

    @OnClick(R.id.button4)
    protected void button4Clicked() {
        equation.addNumber(4d);
    }

    @OnClick(R.id.button5)
    protected void button5Clicked() {
        equation.addNumber(5d);
    }

    @OnClick(R.id.button6)
    protected void button6Clicked() {
        equation.addNumber(6d);
    }

    @OnClick(R.id.button7)
    protected void button7Clicked() {
        equation.addNumber(7d);
    }

    @OnClick(R.id.button8)
    protected void button8Clicked() {
        equation.addNumber(8d);
    }

    @OnClick(R.id.button9)
    protected void button9Clicked() {
        equation.addNumber(9d);
    }

    @OnClick(R.id.buttonEq)
    protected void buttonEqClicked() {
        viewPort.setText(TreePrinter.df.format(equation.evaluate()));
    }

    @OnClick(R.id.buttonDiv)
    protected void buttonDivClicked() {
        equation.addOperation(new Divide());
    }

    @OnClick(R.id.buttonMul)
    protected void buttonMulClicked() {
        equation.addOperation(new Multiply());
    }

    @OnClick(R.id.buttonSub)
    protected void buttonSubClicked() {
        equation.addOperation(new Substract());
    }

    @OnClick(R.id.buttonAdd)
    protected void buttonAddClicked() {
        equation.addOperation(new Add());
    }

    @OnClick(R.id.buttonClr)
    protected void buttonClrClicked() {
        equation.clear();
    }

    @Optional
    @OnClick(R.id.functions)
    protected void buttonFunctionsClicked() {
        startActivity(new Intent(this, ExtendedActivity.class));
    }

    @Override
    public void printed(String equation) {
        viewPort.setText(equation);
    }
}
