package pl.lizardproject.qe2015.patterns;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.FibonacciActivity;
import pl.lizardproject.qe2015.R;
import pl.lizardproject.qe2015.Util.DisplayCondition;
import pl.lizardproject.qe2015.patterns.contract.IFibonacciFunctionPageObject;

public class MinMaxCalculatorPageObject {

    private final Solo solo;

    private final EditText numberList;
    private final View buttonMin;
    private final View buttonMax;
    private final TextView viewDisplay;
    private final View buttonPreviousFunction;

    public MinMaxCalculatorPageObject(Solo solo) {
        this.solo = solo;

        numberList = (EditText) solo.getView(R.id.numberList);
        buttonMin = solo.getView(R.id.min);
        buttonMax = solo.getView(R.id.max);
        viewDisplay = (TextView) solo.getView(R.id.outcome);
        buttonPreviousFunction = solo.getView(R.id.previousFunction);
    }

    public void fillNumberList(String text) {
        solo.typeText(numberList, text);
    }

    public void clickMax() {
        solo.clickOnView(buttonMax);
    }

    public void clickMin() {
        solo.clickOnView(buttonMin);
    }

    public IFibonacciFunctionPageObject goBackToPrimeFunctionsActivity() {
        solo.clickOnView(buttonPreviousFunction);
        solo.waitForActivity(FibonacciActivity.class, 2000);

        return new FunctionCalculatorPageObject(solo);
    }

    public IFibonacciFunctionPageObject goBackByBackButtonToPrimeFunctionsActivity() {
        solo.goBack();
        solo.waitForActivity(FibonacciActivity.class, 2000);

        return new FunctionCalculatorPageObject(solo);
    }

    public boolean waitForResult(String expected) {
        return solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
    }

    public String getDisplayedResult() {
        return viewDisplay.getText().toString();
    }
}