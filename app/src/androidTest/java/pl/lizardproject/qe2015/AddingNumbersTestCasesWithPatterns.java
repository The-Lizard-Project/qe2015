package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

import pl.lizardproject.qe2015.patterns.PageObject;

public class AddingNumbersTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

	private PageObject pageObject;

	public AddingNumbersTestCasesWithPatterns() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		//Given
		pageObject = new PageObject(new Solo(getInstrumentation(), getActivity()));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddTwoAndTwo() {
		//Given
		String expected = "2 + 2  = 4";

		//When
		pageObject.clickTwo();
		pageObject.clickAdd();
		pageObject.clickTwo();
		pageObject.clickEqual();

		//Than
		pageObject.waitForResult(expected);
		Assert.assertEquals(expected, pageObject.getDisplayedResult());
	}

	public void testAddThirtySevenAndFive() {
		//Given
		String expected = "37 + 5  = 42";

		//When
		pageObject.clickThree();
		pageObject.clickSeven();
		pageObject.clickAdd();
		pageObject.clickFive();
		pageObject.clickEqual();

		//Than
		pageObject.waitForResult(expected);
		Assert.assertEquals(expected, pageObject.getDisplayedResult());
	}

	public void testAddSeventeenAndFourAndNine() {
		//Given
		String expected = "17 + 4 + 9  = 30";

		//When
		pageObject.clickOne();
		pageObject.clickSeven();
		pageObject.clickAdd();
		pageObject.clickFour();
		pageObject.clickEqual();
		pageObject.clickAdd();
		pageObject.clickNine();
		pageObject.clickEqual();

		//Than
		pageObject.waitForResult(expected);
		Assert.assertEquals(expected, pageObject.getDisplayedResult());
	}
}