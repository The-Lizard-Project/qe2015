package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.patterns.NumberListGeanie;
import pl.lizardproject.qe2015.patterns.assertion.QEAsserts;
import pl.lizardproject.qe2015.patterns.model.NumberList;
import pl.lizardproject.qe2015.patterns.page_object.MinMaxPageObject;
import pl.lizardproject.qe2015.patterns.page_object.SimpleCalculatorPageObject;

public class FunctionMinTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

    private MinMaxPageObject minMaxFunctionsPageObject;
    private Solo solo;
    private QEAsserts qeAsserts;

    public FunctionMinTestCasesWithPatterns() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        qeAsserts = new QEAsserts(solo);
        //Given
        minMaxFunctionsPageObject = new SimpleCalculatorPageObject(solo).
                goToFibonacci().
                goToGCD().
                goToLCM().
                goToPrime().
                goToMinMax();
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testMinOfThreeFourSixEight() {
        //Given
        NumberList numberList = NumberListGeanie.giveMeNumberListA();
        String expected = numberList.min;

        //When
        minMaxFunctionsPageObject.typeListOfNumbers(numberList.list);
        minMaxFunctionsPageObject.calculateMin();

        //Than
        qeAsserts.assertThatViewEqualsText(minMaxFunctionsPageObject.getOutcomeView(), expected);
    }

    public void testMinOfFourEightTenThirtyThreeFive() {
        //Given
        NumberList numberList = NumberListGeanie.giveMeNumberListB();
        String expected = numberList.min;

        //When
        minMaxFunctionsPageObject.typeListOfNumbers(numberList.list);
        minMaxFunctionsPageObject.calculateMin();

        //Than
        qeAsserts.assertThatViewEqualsText(minMaxFunctionsPageObject.getOutcomeView(), expected);
    }
}