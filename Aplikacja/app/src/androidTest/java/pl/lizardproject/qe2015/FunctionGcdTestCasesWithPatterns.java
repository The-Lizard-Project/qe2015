package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.patterns.assertion.QEAsserts;
import pl.lizardproject.qe2015.patterns.page_object.GCDPageObject;
import pl.lizardproject.qe2015.patterns.page_object.SimpleCalculatorPageObject;

public class FunctionGcdTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

    private GCDPageObject gcdPageObject;
    private Solo solo;
    private QEAsserts qeAsserts;

    public FunctionGcdTestCasesWithPatterns() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        qeAsserts = new QEAsserts(solo);
        //Given
        gcdPageObject = new SimpleCalculatorPageObject(solo).goToFibonacci().goToGCD();
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testGCDof6and28() {
        //Given
        String expected = "2";

        //When
        gcdPageObject.typeFirstNumber("6");
        gcdPageObject.typeSecondNumber("28");
        gcdPageObject.calculateGCD();

        //Then
        qeAsserts.assertThatViewEqualsText(gcdPageObject.getOutcomeView(), expected);
    }

    public void testGCDof78and156() {
        //Given
        String expected = "13";

        //When
        gcdPageObject.typeFirstNumber("78");
        gcdPageObject.typeSecondNumber("156");
        gcdPageObject.calculateGCD();

        //Then
        qeAsserts.assertThatViewEqualsText(gcdPageObject.getOutcomeView(), expected);
    }

}
