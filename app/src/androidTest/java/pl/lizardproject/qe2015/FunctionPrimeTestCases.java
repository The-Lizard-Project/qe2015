package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class FunctionPrimeTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private View buttonThree;
	private View buttonFour;
	private View buttonPri;
	private View buttonEqual;
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
		solo.waitForActivity(ExtendedActivity.class, 2000);
		solo.goBack();
		solo.waitForActivity(MainActivity.class, 2000);
		buttonFunctions = solo.getView(R.id.functions);
		solo.clickOnView(buttonFunctions);
		solo.waitForActivity(ExtendedActivity.class, 2000);

		buttonThree = solo.getView(R.id.button3);
		buttonFour = solo.getView(R.id.button4);
		buttonPri = solo.getView(R.id.buttonPri);
		buttonEqual = solo.getView(R.id.buttonEq);
		viewDisplay = (TextView) solo.getView(R.id.calculatorViewPort);
	}

	@Override
	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

	public void testPrimeOfThree() {
		//Given
		String expected = "1";

		//When
		solo.clickOnView(buttonThree);
		solo.clickOnView(buttonPri);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}

	public void testPrimeOfFour() {
		//Given
		String expected = "0";

		//When
		solo.clickOnView(buttonFour);
		solo.clickOnView(buttonPri);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}
}