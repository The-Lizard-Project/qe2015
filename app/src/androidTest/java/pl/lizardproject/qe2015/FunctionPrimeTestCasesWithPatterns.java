package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.patterns.assertion.QEAsserts;
import pl.lizardproject.qe2015.patterns.page_object.PrimePageObject;
import pl.lizardproject.qe2015.patterns.page_object.SimpleCalculatorPageObject;

public class FunctionPrimeTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

    private PrimePageObject functionsPageObject;
    private Solo solo;
    private QEAsserts qeAsserts;

    public FunctionPrimeTestCasesWithPatterns() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        qeAsserts = new QEAsserts(solo);
        //Given
        functionsPageObject = new SimpleCalculatorPageObject(solo).
                goToFibonacci().
                goToGCD().
                goToLCM().
                goToPrime();
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
        functionsPageObject.typeInNumber("3");
        functionsPageObject.calculatePrime();

        //Than
        qeAsserts.assertThatViewEqualsText(functionsPageObject.getOutcomeView(), expected);
    }

    public void testPrimeOfFour() {
        //Given
        String expected = "Not prime";

        //When
        functionsPageObject.typeInNumber("4");
        functionsPageObject.calculatePrime();

        //Than
        qeAsserts.assertThatViewEqualsText(functionsPageObject.getOutcomeView(), expected);
    }
}