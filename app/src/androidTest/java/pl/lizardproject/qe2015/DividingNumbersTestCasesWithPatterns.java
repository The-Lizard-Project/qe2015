package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

import pl.lizardproject.qe2015.patterns.PageObject;

public class DividingNumbersTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

	private PageObject pageObject;

	public DividingNumbersTestCasesWithPatterns() {
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

	public void testDivideTwoByTwo() {
		//Given
		String expected = "2 / 2  = 1";

		//When
		pageObject.clickTwo();
		pageObject.clickDivide();
		pageObject.clickTwo();
		pageObject.clickEqual();

		//Than
		pageObject.waitForResult(expected);
		Assert.assertEquals(expected, pageObject.getDisplayedResult());
	}

	public void testDivideThirtyFiveByFive() {
		//Given
		String expected = "35 / 5  = 7";

		//When
		pageObject.clickThree();
		pageObject.clickFive();
		pageObject.clickDivide();
		pageObject.clickFive();
		pageObject.clickEqual();

		//Than
		pageObject.waitForResult(expected);
		Assert.assertEquals(expected, pageObject.getDisplayedResult());
	}

	public void testDivideTwentyByTwoAndByFive() {
		//Given
		String expected = "20 / 2 / 5  = 2";

		//When
		pageObject.clickTwo();
		pageObject.clickZero();
		pageObject.clickDivide();
		pageObject.clickTwo();
		pageObject.clickEqual();
		pageObject.clickDivide();
		pageObject.clickFive();
		pageObject.clickEqual();

		//Than
		pageObject.waitForResult(expected);
		Assert.assertEquals(expected, pageObject.getDisplayedResult());
	}

	public void testDivideSevenByZero() {
		//Given
		String expected = "20 / 0  = inf";

		//When
		pageObject.clickSeven();
		pageObject.clickDivide();
		pageObject.clickZero();
		pageObject.clickEqual();

		//Than
		pageObject.waitForResult(expected);
		Assert.assertEquals(expected, pageObject.getDisplayedResult());
	}
}