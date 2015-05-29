package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class FunctionGcdTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    private EditText viewFirstNumber;
    private EditText viewSecondNumber;
    private View buttonFunction;
    private TextView viewDisplay;

    public FunctionGcdTestCases() {
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
        solo.clickOnView(solo.getView(R.id.nextFunction));
        solo.waitForActivity(GcdActivity.class, 2000);
        viewFirstNumber = (EditText) solo.getView(R.id.firstNumber);
        viewSecondNumber = (EditText) solo.getView(R.id.secondNumber);
        buttonFunction = solo.getView(R.id.function);
        viewDisplay = (TextView) solo.getView(R.id.outcome);
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testGcdOf37and86() {
        //Given
        String expected = "1";

        //When
        solo.typeText(viewFirstNumber, "37");
        solo.typeText(viewSecondNumber, "86");
        solo.clickOnView(buttonFunction);

        //Than
        solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
        assertEquals(expected, viewDisplay.getText());
    }

    public void testGcdOf90and15() {
        //Given
        String expected = "5";

        //When
        solo.typeText(viewFirstNumber, "90");
        solo.typeText(viewSecondNumber, "25");
        solo.clickOnView(buttonFunction);

        //Than
        solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
        assertEquals(expected, viewDisplay.getText());
    }
}
