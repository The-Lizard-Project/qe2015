package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

import pl.lizardproject.qe2015.patterns.SimpleCalculatorPageObject;
import pl.lizardproject.qe2015.patterns.contract.IFibonacciFunctionPageObject;

public class FunctionFibonacciTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

	private IFibonacciFunctionPageObject functionsPageObject;
	private Solo solo;

	public FunctionFibonacciTestCasesWithPatterns() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());

		//Given
		functionsPageObject = new SimpleCalculatorPageObject(solo).
				goToFibonacciFunctionsActivity();
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
		functionsPageObject.fillFirstNumber("7");
		functionsPageObject.clickFunction();

		//Than
		functionsPageObject.waitForResult(expected);
		Assert.assertEquals(expected, functionsPageObject.getDisplayedResult());
	}

	public void testFibonacciOfNine() {
		//Given
		String expected = "34";

		//When
		functionsPageObject.fillFirstNumber("9");
		functionsPageObject.clickFunction();

		//Than
		functionsPageObject.waitForResult(expected);
		Assert.assertEquals(expected, functionsPageObject.getDisplayedResult());
	}
}