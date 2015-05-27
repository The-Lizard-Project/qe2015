package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

import pl.lizardproject.qe2015.patterns.FunctionCalculatorPageObject;
import pl.lizardproject.qe2015.patterns.NavigationPageObject;

public class FunctionPrimeTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

	private FunctionCalculatorPageObject functionsPageObject;
	private NavigationPageObject transporter;

	public FunctionPrimeTestCasesWithPatterns() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		//Given
		transporter = new NavigationPageObject(new Solo(getInstrumentation(), getActivity()));
		transporter.goToFunctionsActivity();
		transporter.goBackFromFunctionsActivity();
		functionsPageObject = transporter.goToFunctionsActivity();
	}

	@Override
	protected void tearDown() throws Exception {
		transporter.finishOpenedActivities();
		super.tearDown();
	}

	public void testPrimeOfThree() {
		//Given
		String expected = "1";

		//When
		functionsPageObject.clickThree();
		functionsPageObject.clickPrime();
		functionsPageObject.clickEqual();

		//Than
		functionsPageObject.waitForResult(expected);
		Assert.assertEquals(expected, functionsPageObject.getDisplayedResult());
	}

	public void testPrimeOfFour() {
		//Given
		String expected = "0";

		//When
		functionsPageObject.clickFour();
		functionsPageObject.clickPrime();
		functionsPageObject.clickEqual();

		//Than
		functionsPageObject.waitForResult(expected);
		Assert.assertEquals(expected, functionsPageObject.getDisplayedResult());
	}
}