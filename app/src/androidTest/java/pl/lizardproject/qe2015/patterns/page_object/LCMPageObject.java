package pl.lizardproject.qe2015.patterns.page_object;

import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.GcdActivity;
import pl.lizardproject.qe2015.PrimeActivity;
import pl.lizardproject.qe2015.patterns.page_object.base.ExtendedFunctionPageObject;

public class LCMPageObject extends ExtendedFunctionPageObject {
    public LCMPageObject(Solo solo) {
        super(solo);
    }

    public void typeFirstNumber(String number) {
        typeIntoFirstNumber(number);
    }

    public void typeSecondNumber(String number) {
        typeIntoSecondNumber(number);
    }

    public void calculateLCM() {
        clickButtonFunction();
    }

    public String getOutcome() {
        return super.getOutcome();
    }

    public TextView getOutcomeView() {
        return viewDisplay;
    }

    public GCDPageObject goBackToGCD() {
        clickButtonPreviousFunction();
        solo.waitForActivity(GcdActivity.class, 2000);
        return new GCDPageObject(solo);
    }

    public PrimePageObject goToPrime() {
        clickButtonNextFunction();
        solo.waitForActivity(PrimeActivity.class, 2000);
        return new PrimePageObject(solo);
    }
}
