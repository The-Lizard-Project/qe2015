package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class AddingNumbersTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private View buttonOne;
	private View buttonTwo;
	private View buttonThree;
	private View buttonFour;
	private View buttonFive;
	private View buttonSeven;
	private View buttonNine;
	private View buttonAdd;
	private View buttonEqual;
	private TextView viewDisplay;

	public AddingNumbersTestCases() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());

		//Given
		buttonOne = solo.getView(R.id.button1);
		buttonTwo = solo.getView(R.id.button2);
		buttonThree = solo.getView(R.id.button3);
		buttonFour = solo.getView(R.id.button4);
		buttonFive = solo.getView(R.id.button5);
		buttonSeven = solo.getView(R.id.button7);
		buttonNine = solo.getView(R.id.button9);
		buttonAdd = solo.getView(R.id.buttonAdd);
		buttonEqual = solo.getView(R.id.buttonEq);
		viewDisplay = (TextView) solo.getView(R.id.calclatorViewPort);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddTwoAndTwo() {
		//Given
		String expected = "2 + 2  = 4";

		//When
		solo.clickOnView(buttonTwo);
		solo.clickOnView(buttonAdd);
		solo.clickOnView(buttonTwo);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}

	public void testAddThirtySevenAndFive() {
		//Given
		String expected = "37 + 5  = 42";

		//When
		solo.clickOnView(buttonThree);
		solo.clickOnView(buttonSeven);
		solo.clickOnView(buttonAdd);
		solo.clickOnView(buttonFive);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}

	public void testAddSeventeenAndFourAndNine() {
		//Given
		String expected = "17 + 4 + 9  = 30";

		//When
		solo.clickOnView(buttonOne);
		solo.clickOnView(buttonSeven);
		solo.clickOnView(buttonAdd);
		solo.clickOnView(buttonFour);
		solo.clickOnView(buttonEqual);
		solo.clickOnView(buttonAdd);
		solo.clickOnView(buttonNine);
		solo.clickOnView(buttonEqual);

		//Than
		solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
		assertEquals(expected, viewDisplay.getText());
	}
}