package pl.lizardproject.qe2015;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import java.text.DecimalFormat;

import pl.lizardproject.qe2015.patterns.page_object.SimpleCalculatorPageObject;
import pl.lizardproject.qe2015.patterns.assertion.QEAsserts;

public class DividingNumbersTestCasesWithPatterns extends ActivityInstrumentationTestCase2<MainActivity> {

    private SimpleCalculatorPageObject pageObject;
    private QEAsserts qeAsserts;

    public DividingNumbersTestCasesWithPatterns() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //Given
        final Solo solo = new Solo(getInstrumentation(), getActivity());
        pageObject = new SimpleCalculatorPageObject(solo);
        qeAsserts = new QEAsserts(solo);
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
        qeAsserts.assertThatViewEqualsText(pageObject.getViewDisplay(), expected);
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
        qeAsserts.assertThatViewEqualsText(pageObject.getViewDisplay(), expected);
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
        qeAsserts.assertThatViewEqualsText(pageObject.getViewDisplay(), expected);
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
        qeAsserts.assertThatViewEqualsText(pageObject.getViewDisplay(), expected);
    }
}