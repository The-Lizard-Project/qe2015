package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

import com.robotium.solo.Solo;

import java.text.DecimalFormat;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class DividingNumbersTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private View buttonZero;
	private View buttonTwo;
	private View buttonThree;
	private View buttonFive;
	private View buttonSeven;
	private View buttonDiv;
	private View buttonEqual;
	private TextView viewDisplay;

	public DividingNumbersTestCases() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());

		//Given
		buttonZero = solo.getView(R.id.button0);
		buttonTwo = solo.getView(R.id.button2);
		buttonThree = solo.getView(R.id.button3);
		buttonFive = solo.getView(R.id.button5);
		buttonSeven = solo.getView(R.id.button7);
		buttonDiv = solo.getView(R.id.buttonDiv);
		buttonEqual = solo.getView(R.id.buttonEq);
		viewDisplay = (TextView) solo.getView(R.id.calculatorViewPort);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDivideTwoByTwo() {
		//Given
		String expected = "1";

		//When
		solo.clickOnView(buttonTwo);
		solo.clickOnView(buttonDiv);
		solo.clickOnView(buttonTwo);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}

	public void testDivideThirtyFiveByFive() {
		//Given
		String expected = "7";

		//When
		solo.clickOnView(buttonThree);
		solo.clickOnView(buttonFive);
		solo.clickOnView(buttonDiv);
		solo.clickOnView(buttonFive);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}

	public void testDivideTwentyByTwoAndByFive() {
		//Given
		String expected = "2";

		//When
		solo.clickOnView(buttonTwo);
		solo.clickOnView(buttonZero);
		solo.clickOnView(buttonDiv);
		solo.clickOnView(buttonTwo);
		solo.clickOnView(buttonDiv);
		solo.clickOnView(buttonFive);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}

	public void testDivideSevenByZero() {
		//Given
		String expected = DecimalFormat.getNumberInstance().format(Double.POSITIVE_INFINITY);

		//When
		solo.clickOnView(buttonSeven);
		solo.clickOnView(buttonDiv);
		solo.clickOnView(buttonZero);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}
}