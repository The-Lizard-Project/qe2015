package pl.lizardproject.qe2015.patterns.page_object;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.PrimeActivity;
import pl.lizardproject.qe2015.R;

public class MinMaxPageObject {

    protected final Solo solo;
    protected final View previousButton;
    protected final EditText numbersList;
    protected final View minButton;
    protected final View maxButton;
    private TextView viewDisplay;

    public MinMaxPageObject(Solo solo) {
        this.solo = solo;
        previousButton = solo.getView(R.id.previousFunction);
        viewDisplay = (TextView) solo.getView(R.id.outcome);
        numbersList = (EditText) solo.getView(R.id.numberList);
        minButton = solo.getView(R.id.min);
        maxButton = solo.getView(R.id.max);
    }

    public PrimePageObject goBackToPrime() {
        solo.clickOnView(previousButton);
        solo.waitForActivity(PrimeActivity.class, 2000);
        return new PrimePageObject(solo);
    }

    public void typeListOfNumbers(String numbers) {
        solo.typeText(numbersList, numbers);
    }

    public void calculateMin() {
        solo.clickOnView(minButton);
    }

    public void calculateMax() {
        solo.clickOnView(maxButton);
    }

    public TextView getOutcomeView() {
        return viewDisplay;
    }

    public String getOutcome() {
        return viewDisplay.getText().toString();
    }

}
