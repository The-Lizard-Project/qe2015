package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

import java.text.DecimalFormat;

import pl.lizardproject.qe2015.patterns.SimpleCalculatorPageObject;

public class DividingNumbersTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

	private SimpleCalculatorPageObject pageObject;

	public DividingNumbersTestCasesWithPatterns() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		//Given
		pageObject = new SimpleCalculatorPageObject(new Solo(getInstrumentation(), getActivity()));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDivideTwoByTwo() {
		//Given
		String expected = "1";

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
		String expected = "7";

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
		String expected = "2";

		//When
		pageObject.clickTwo();
		pageObject.clickZero();
		pageObject.clickDivide();
		pageObject.clickTwo();
		pageObject.clickDivide();
		pageObject.clickFive();
		pageObject.clickEqual();

		//Than
		pageObject.waitForResult(expected);
		Assert.assertEquals(expected, pageObject.getDisplayedResult());
	}

	public void testDivideSevenByZero() {
		//Given
		String expected = DecimalFormat.getNumberInstance().format(Double.POSITIVE_INFINITY);

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