package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class FunctionPrimeTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private EditText viewFirstNumber;
	private View buttonFunction;
	private TextView viewDisplay;

	public FunctionPrimeTestCases() {
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

		viewFirstNumber = (EditText) solo.getView(R.id.firstNumber);
		buttonFunction = solo.getView(R.id.function);
		viewDisplay = (TextView) solo.getView(R.id.outcome);
	}

	@Override
	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

	public void testPrimeOfThree() {
		//Given
		String expected = "Prime";

		//When
		solo.typeText(viewFirstNumber, "3");
		solo.clickOnView(buttonFunction);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}

	public void testPrimeOfFour() {
		//Given
		String expected = "Not prime";

		//When
		solo.typeText(viewFirstNumber, "4");
		solo.clickOnView(buttonFunction);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}
}