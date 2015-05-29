package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class FunctionMinTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    private TextView viewDisplay;
    private EditText numberList;
    private View buttonMin;

    public FunctionMinTestCases() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());

        //Given
        View buttonFunctions = solo.getView(R.id.functions);
        solo.clickOnView(buttonFunctions);
        solo.waitForActivity(FibonacciActivity.class, 2000);
        View buttonNextFunction = solo.getView(R.id.nextFunction);
        solo.clickOnView(buttonNextFunction);
        solo.waitForActivity(GcdActivity.class, 2000);
        buttonNextFunction = solo.getView(R.id.nextFunction);
        solo.clickOnView(buttonNextFunction);
        solo.waitForActivity(LcmActivity.class, 2000);
        buttonNextFunction = solo.getView(R.id.nextFunction);
        solo.clickOnView(buttonNextFunction);
        solo.waitForActivity(PrimeActivity.class, 2000);
        buttonNextFunction = solo.getView(R.id.nextFunction);
        solo.clickOnView(buttonNextFunction);
        solo.waitForActivity(MinMaxActivity.class, 2000);

        numberList = (EditText) solo.getView(R.id.numberList);
        buttonMin = solo.getView(R.id.min);
        viewDisplay = (TextView) solo.getView(R.id.outcome);
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testMinOfThreeFourSixEight() {
        //Given
        String expected = "3";

        //When
        solo.typeText(numberList, "3,4,6,8");
        solo.clickOnView(buttonMin);

        //Than
        solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
        assertEquals(expected, viewDisplay.getText());
    }

    public void testMinOfFourEightTenThirtyThreeFive() {
        //Given
        String expected = "2";

        //When
        solo.typeText(numberList, "5,2,10,33,7");
        solo.clickOnView(buttonMin);

        //Than
        solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
        assertEquals(expected, viewDisplay.getText());
    }
}