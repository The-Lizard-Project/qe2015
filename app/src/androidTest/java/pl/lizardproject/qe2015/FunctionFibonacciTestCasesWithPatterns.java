package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.patterns.assertion.QEAsserts;
import pl.lizardproject.qe2015.patterns.page_object.FibonacciPageObject;
import pl.lizardproject.qe2015.patterns.page_object.SimpleCalculatorPageObject;

public class FunctionFibonacciTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

    private FibonacciPageObject functionsPageObject;
    private Solo solo;
    private QEAsserts qeAsserts;

    public FunctionFibonacciTestCasesWithPatterns() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        qeAsserts = new QEAsserts(solo);
        //Given
        functionsPageObject = new SimpleCalculatorPageObject(solo).goToFibonacci();
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
        functionsPageObject.typeInNumber("7");
        functionsPageObject.calculateFibonacci();

        //Then
        qeAsserts.assertThatViewEqualsText(functionsPageObject.getOutcomeView(), expected);
    }

    public void testFibonacciOfNine() {
        //Given
        String expected = "34";

        //When
        functionsPageObject.typeInNumber("9");
        functionsPageObject.calculateFibonacci();

        //Then
        qeAsserts.assertThatViewEqualsText(functionsPageObject.getOutcomeView(), expected);
    }
}