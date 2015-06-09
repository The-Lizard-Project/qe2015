package pl.lizardproject.qe2015.patterns.page_object;

import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.FibonacciActivity;
import pl.lizardproject.qe2015.LcmActivity;
import pl.lizardproject.qe2015.patterns.page_object.base.ExtendedFunctionPageObject;

public class GCDPageObject extends ExtendedFunctionPageObject {
    public GCDPageObject(Solo solo) {
        super(solo);
    }

    public void typeFirstNumber(String number) {
        typeIntoFirstNumber(number);
    }

    public void typeSecondNumber(String number) {
        typeIntoSecondNumber(number);
    }

    public void calculateGCD() {
        clickButtonFunction();
    }

    public String getOutcome() {
        return super.getOutcome();
    }

    public TextView getOutcomeView() {
        return viewDisplay;
    }

    public FibonacciPageObject goBackToFibonacci() {
        clickButtonPreviousFunction();
        solo.waitForActivity(FibonacciActivity.class, 2000);
        return new FibonacciPageObject(solo);
    }

    public LCMPageObject goToLCM() {
        clickButtonNextFunction();
        solo.waitForActivity(LcmActivity.class, 2000);
        return new LCMPageObject(solo);
    }
}
