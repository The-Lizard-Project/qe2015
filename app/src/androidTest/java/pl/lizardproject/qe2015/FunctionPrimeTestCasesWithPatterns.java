package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

import pl.lizardproject.qe2015.patterns.contract.IPrimeFunctionPageObject;
import pl.lizardproject.qe2015.patterns.SimpleCalculatorPageObject;

public class FunctionPrimeTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

	private IPrimeFunctionPageObject functionsPageObject;
	private Solo solo;

	public FunctionPrimeTestCasesWithPatterns() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());

		//Given
		functionsPageObject = new SimpleCalculatorPageObject(solo).
				goToFibonacciFunctionsActivity().
				goToGcdFunctionsActivity().
				goToLcmFunctionsActivity().
				goToPrimeFunctionsActivity();
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
		functionsPageObject.fillFirstNumber("3");
		functionsPageObject.clickFunction();

		//Than
		functionsPageObject.waitForResult(expected);
		Assert.assertEquals(expected, functionsPageObject.getDisplayedResult());
	}

	public void testPrimeOfFour() {
		//Given
		String expected = "Not prime";

		//When
		functionsPageObject.fillFirstNumber("4");
		functionsPageObject.clickFunction();

		//Than
		functionsPageObject.waitForResult(expected);
		Assert.assertEquals(expected, functionsPageObject.getDisplayedResult());
	}
}