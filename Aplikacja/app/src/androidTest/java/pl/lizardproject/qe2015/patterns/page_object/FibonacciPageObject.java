package pl.lizardproject.qe2015.patterns.page_object;

import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.GcdActivity;
import pl.lizardproject.qe2015.MainActivity;
import pl.lizardproject.qe2015.patterns.page_object.base.BaseFunctionPageObject;

public class FibonacciPageObject extends BaseFunctionPageObject {
    public FibonacciPageObject(Solo solo) {
        super(solo);
    }

    public void typeInNumber(String number) {
        typeIntoFirstNumber(number);
    }

    public void calculateFibonacci() {
        clickButtonFunction();
    }

    public GCDPageObject goToGCD() {
        clickButtonNextFunction();
        solo.waitForActivity(GcdActivity.class, 2000);
        return new GCDPageObject(solo);
    }

    public SimpleCalculatorPageObject goBackToSimpleCalculator() {
        clickButtonPreviousFunction();
        solo.waitForActivity(MainActivity.class, 2000);
        return new SimpleCalculatorPageObject(solo);
    }

    public TextView getOutcomeView() {
        return viewDisplay;
    }

    public String getOutcome() {
        return super.getOutcome();
    }

}
