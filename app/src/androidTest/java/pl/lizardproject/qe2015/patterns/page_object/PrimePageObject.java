package pl.lizardproject.qe2015.patterns.page_object;

import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.LcmActivity;
import pl.lizardproject.qe2015.MinMaxActivity;
import pl.lizardproject.qe2015.patterns.page_object.base.BaseFunctionPageObject;

public class PrimePageObject extends BaseFunctionPageObject {
    public PrimePageObject(Solo solo) {
        super(solo);
    }

    public void typeInNumber(String number) {
        super.typeIntoFirstNumber(number);
    }

    public void calculatePrime() {
        clickButtonFunction();
    }

    public String getOutcome() {
        return super.getOutcome();
    }

    public TextView getOutcomeView() {
        return viewDisplay;
    }

    public LCMPageObject goBackToLcm() {
        clickButtonPreviousFunction();
        solo.waitForActivity(LcmActivity.class, 2000);

        return new LCMPageObject(solo);
    }

    public MinMaxPageObject goToMinMax() {
        clickButtonNextFunction();
        solo.waitForActivity(MinMaxActivity.class, 2000);
        return new MinMaxPageObject(solo);
    }
}
