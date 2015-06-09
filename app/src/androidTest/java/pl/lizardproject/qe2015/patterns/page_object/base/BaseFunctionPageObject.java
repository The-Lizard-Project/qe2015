package pl.lizardproject.qe2015.patterns.page_object.base;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.R;

public class BaseFunctionPageObject {
    protected final Solo solo;
    protected final EditText viewFirstNumber;
    protected final View buttonFunction;
    protected final TextView viewDisplay;
    protected final View buttonNextFunction;
    protected final View buttonPreviousFunction;

    protected BaseFunctionPageObject(Solo solo) {
        this.solo = solo;
        viewFirstNumber = (EditText) solo.getView(R.id.firstNumber);
        buttonFunction = solo.getView(R.id.function);
        viewDisplay = (TextView) solo.getView(R.id.outcome);
        buttonNextFunction = solo.getView(R.id.nextFunction);
        buttonPreviousFunction = solo.getView(R.id.previousFunction);
    }

    protected String getOutcome() {
        return viewDisplay.getText().toString();
    }

    protected void clickButtonFunction() {
        solo.clickOnView(buttonFunction);
    }

    protected void clickButtonNextFunction() {
        solo.clickOnView(buttonNextFunction);
    }

    protected void clickButtonPreviousFunction() {
        solo.clickOnView(buttonPreviousFunction);
    }

    protected void typeIntoFirstNumber(String number) {
        solo.typeText(viewFirstNumber, number);
    }
}
