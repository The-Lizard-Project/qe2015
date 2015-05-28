package pl.lizardproject.qe2015.patterns.contract;

import pl.lizardproject.qe2015.patterns.SimpleCalculatorPageObject;

public interface IFibonacciFunctionPageObject {

	void fillFirstNumber(String text);

	void clickFunction();

	boolean waitForResult(String expected);

	String getDisplayedResult();

	IGcdFunctionPageObject goToGcdFunctionsActivity();

	SimpleCalculatorPageObject goBackToSimpleCalculatorActivity();

	SimpleCalculatorPageObject goBackByBackButtonToSimpleCalculatorActivity();
}