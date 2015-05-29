package pl.lizardproject.qe2015.patterns;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.FibonacciActivity;
import pl.lizardproject.qe2015.GcdActivity;
import pl.lizardproject.qe2015.LcmActivity;
import pl.lizardproject.qe2015.MainActivity;
import pl.lizardproject.qe2015.MinMaxActivity;
import pl.lizardproject.qe2015.PrimeActivity;
import pl.lizardproject.qe2015.R;
import pl.lizardproject.qe2015.Util.DisplayCondition;
import pl.lizardproject.qe2015.patterns.contract.IFibonacciFunctionPageObject;
import pl.lizardproject.qe2015.patterns.contract.IGcdFunctionPageObject;
import pl.lizardproject.qe2015.patterns.contract.ILcmFunctionPageObject;
import pl.lizardproject.qe2015.patterns.contract.IPrimeFunctionPageObject;

public class FunctionCalculatorPageObject implements IFibonacciFunctionPageObject, IGcdFunctionPageObject, ILcmFunctionPageObject, IPrimeFunctionPageObject {

    private final Solo solo;

    private final EditText viewFirstNumber;
    private final EditText viewSecondNumber;
    private final View buttonFunction;
    private final TextView viewDisplay;
    private final View buttonNextFunction;
    private final View buttonPreviousFunction;

    public FunctionCalculatorPageObject(Solo solo) {
        this.solo = solo;

        viewFirstNumber = (EditText) solo.getView(R.id.firstNumber);
        viewSecondNumber = (EditText) solo.getView(R.id.secondNumber);
        buttonFunction = solo.getView(R.id.function);
        viewDisplay = (TextView) solo.getView(R.id.outcome);
        buttonNextFunction = solo.getView(R.id.nextFunction);
        buttonPreviousFunction = solo.getView(R.id.previousFunction);
    }

    public TextView getViewDisplay() {
        return viewDisplay;
    }

    public void fillFirstNumber(String text) {
        solo.typeText(viewFirstNumber, text);
    }

    public void fillSecondNumber(String text) {
        solo.typeText(viewSecondNumber, text);
    }

    public void clickFunction() {
        solo.clickOnView(buttonFunction);
    }

    public boolean waitForResult(String expected) {
        return solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
    }

    public String getDisplayedResult() {
        return viewDisplay.getText().toString();
    }

    public IGcdFunctionPageObject goToGcdFunctionsActivity() {
        goTo(GcdActivity.class, buttonNextFunction);

        return new FunctionCalculatorPageObject(solo);
    }

    public ILcmFunctionPageObject goToLcmFunctionsActivity() {
        goTo(LcmActivity.class, buttonNextFunction);

        return new FunctionCalculatorPageObject(solo);
    }

    public IPrimeFunctionPageObject goToPrimeFunctionsActivity() {
        goTo(PrimeActivity.class, buttonNextFunction);

        return new FunctionCalculatorPageObject(solo);
    }

    public MinMaxCalculatorPageObject goToMinMaxFunctionsActivity() {
        goTo(MinMaxActivity.class, buttonNextFunction);

        return new MinMaxCalculatorPageObject(solo);
    }

    public SimpleCalculatorPageObject goBackToSimpleCalculatorActivity() {
        goTo(FibonacciActivity.class, buttonPreviousFunction);

        return new SimpleCalculatorPageObject(solo);
    }

    public IFibonacciFunctionPageObject goBackToFibonacciFunctionsActivity() {
        goTo(FibonacciActivity.class, buttonPreviousFunction);

        return new FunctionCalculatorPageObject(solo);
    }

    public IGcdFunctionPageObject goBackToGcdFunctionsActivity() {
        goTo(GcdActivity.class, buttonPreviousFunction);

        return new FunctionCalculatorPageObject(solo);
    }

    public ILcmFunctionPageObject goBackToLcmFunctionsActivity() {
        goTo(LcmActivity.class, buttonPreviousFunction);

        return new FunctionCalculatorPageObject(solo);
    }

    public SimpleCalculatorPageObject goBackByBackButtonToSimpleCalculatorActivity() {
        goBackByBackButton(MainActivity.class);

        return new SimpleCalculatorPageObject(solo);
    }

    public IFibonacciFunctionPageObject goBackByBackButtonToFibonacciFunctionsActivity() {
        goBackByBackButton(FibonacciActivity.class);

        return new FunctionCalculatorPageObject(solo);
    }

    public IGcdFunctionPageObject goBackByBackButtonToGcdFunctionsActivity() {
        goBackByBackButton(GcdActivity.class);

        return new FunctionCalculatorPageObject(solo);
    }

    public ILcmFunctionPageObject goBackByBackButtonToLcmFunctionsActivity() {
        goBackByBackButton(LcmActivity.class);

        return new FunctionCalculatorPageObject(solo);
    }

    private void goTo(Class<? extends Activity> activityClass, View button) {
        solo.clickOnView(button);
        solo.waitForActivity(activityClass, 2000);
    }

    private void goBackByBackButton(Class<? extends Activity> activityClass) {
        solo.goBack();
        solo.waitForActivity(activityClass, 2000);
    }
}