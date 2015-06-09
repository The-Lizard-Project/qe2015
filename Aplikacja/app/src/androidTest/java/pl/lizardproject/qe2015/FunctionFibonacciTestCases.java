package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class FunctionFibonacciTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;

	private EditText viewFirstNumber;
	private View buttonFunction;
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
		solo.waitForActivity(FibonacciActivity.class, 2000);

		viewFirstNumber = (EditText) solo.getView(R.id.firstNumber);
		buttonFunction = solo.getView(R.id.function);
		viewDisplay = (TextView) solo.getView(R.id.outcome);
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
		solo.typeText(viewFirstNumber, "7");
		solo.clickOnView(buttonFunction);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}

	public void testFibonacciOfNine() {
		//Given
		String expected = "34";

		//When
		solo.typeText(viewFirstNumber, "9");
		solo.clickOnView(buttonFunction);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}
}