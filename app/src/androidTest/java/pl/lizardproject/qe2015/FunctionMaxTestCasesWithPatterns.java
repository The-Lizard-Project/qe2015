package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

import pl.lizardproject.qe2015.patterns.MinMaxCalculatorPageObject;
import pl.lizardproject.qe2015.patterns.NumberListGeanie;
import pl.lizardproject.qe2015.patterns.SimpleCalculatorPageObject;
import pl.lizardproject.qe2015.patterns.model.NumberList;

public class FunctionMaxTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

    private MinMaxCalculatorPageObject minMaxFunctionsPageObject;
    private Solo solo;

    public FunctionMaxTestCasesWithPatterns() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());

        //Given
        minMaxFunctionsPageObject = new SimpleCalculatorPageObject(solo).
                goToFibonacciFunctionsActivity().
                goToGcdFunctionsActivity().
                goToLcmFunctionsActivity().
                goToPrimeFunctionsActivity().
                goToMinMaxFunctionsActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testMaxOfThreeFourSixEight() {
        //Given
        NumberList numberList = NumberListGeanie.giveMeNumberListA();
        String expected = numberList.max;

        //When
        minMaxFunctionsPageObject.fillNumberList(numberList.list);
        minMaxFunctionsPageObject.clickMax();

        //Than
        minMaxFunctionsPageObject.waitForResult(expected);
        Assert.assertEquals(expected, minMaxFunctionsPageObject.getDisplayedResult());
    }

    public void testMaxOfFourEightTenThirtyThreeFive() {
        //Given
        NumberList numberList = NumberListGeanie.giveMeNumberListB();
        String expected = numberList.max;

        //When
        minMaxFunctionsPageObject.fillNumberList(numberList.list);
        minMaxFunctionsPageObject.clickMax();

        //Than
        minMaxFunctionsPageObject.waitForResult(expected);
        Assert.assertEquals(expected, minMaxFunctionsPageObject.getDisplayedResult());
    }
}