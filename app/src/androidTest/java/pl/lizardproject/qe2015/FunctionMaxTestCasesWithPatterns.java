package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.patterns.MinMaxCalculatorPageObject;
import pl.lizardproject.qe2015.patterns.NumberListGeanie;
import pl.lizardproject.qe2015.patterns.SimpleCalculatorPageObject;
import pl.lizardproject.qe2015.patterns.assertion.QEAsserts;
import pl.lizardproject.qe2015.patterns.model.NumberList;

public class FunctionMaxTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

    private MinMaxCalculatorPageObject minMaxFunctionsPageObject;
    private Solo solo;
    private QEAsserts qeAsserts;

    public FunctionMaxTestCasesWithPatterns() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        qeAsserts = new QEAsserts(solo);
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

    public void testMaxOfListWhereMaxIs() {
        //Given
        NumberList numberList = NumberListGeanie.giveMeNumberListA();
        String expected = numberList.max;

        //When
        minMaxFunctionsPageObject.fillNumberList(numberList.list);
        minMaxFunctionsPageObject.clickMax();

        //Than
        qeAsserts.assertThatViewEqualsText(minMaxFunctionsPageObject.getViewDisplay(), expected);
    }

    public void testMaxOfListB() {
        //Given
        NumberList numberList = NumberListGeanie.giveMeNumberListB();
        String expected = numberList.max;

        //When
        minMaxFunctionsPageObject.fillNumberList(numberList.list);
        minMaxFunctionsPageObject.clickMax();

        //Than
        qeAsserts.assertThatViewEqualsText(minMaxFunctionsPageObject.getViewDisplay(), expected);
    }
}