package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class FunctionFibonacciTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private View buttonSeven;
	private View buttonNine;
	private View buttonFib;
	private View buttonEqual;
	private TextView viewDisplay;

	public FunctionFibonacciTestCases() {
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

		buttonSeven = solo.getView(R.id.button7);
		buttonNine = solo.getView(R.id.button9);
		buttonFib = solo.getView(R.id.buttonFib);
		buttonEqual = solo.getView(R.id.buttonEq);
		viewDisplay = (TextView) solo.getView(R.id.calculatorViewPort);
	}

	@Override
	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

	public void testFibonacciOfSeven() {
		//Given
		String expected = "13";

		//When
		solo.clickOnView(buttonSeven);
		solo.clickOnView(buttonFib);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}

	public void testFibonacciOfNine() {
		//Given
		String expected = "34";

		//When
		solo.clickOnView(buttonNine);
		solo.clickOnView(buttonFib);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}
}