package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class FunctionMaxTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    private TextView viewDisplay;
    private EditText numberList;
    private View buttonMax;

    public FunctionMaxTestCases() {
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
        buttonMax = solo.getView(R.id.max);
        viewDisplay = (TextView) solo.getView(R.id.outcome);
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testMaxOfThreeFourSixEight() {
        //Given
        String expected = "8";

        //When
        solo.typeText(numberList, "3,4,6,8");
        solo.clickOnView(buttonMax);

        //Than
        solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
        assertEquals(expected, viewDisplay.getText());
    }

    public void testMaxOfFourEightTenThirtyThreeFive() {
        //Given
        String expected = "33";

        //When
        solo.typeText(numberList, "3,8,10,33,5");
        solo.clickOnView(buttonMax);

        //Than
        solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
        assertEquals(expected, viewDisplay.getText());
    }
}