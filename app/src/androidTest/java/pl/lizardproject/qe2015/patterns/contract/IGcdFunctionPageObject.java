package pl.lizardproject.qe2015.patterns.contract;

public interface IGcdFunctionPageObject {

	void fillFirstNumber(String text);

	void fillSecondNumber(String text);

	void clickFunction();

	boolean waitForResult(String expected);

	String getDisplayedResult();

	ILcmFunctionPageObject goToLcmFunctionsActivity();

	IFibonacciFunctionPageObject goBackToFibonacciFunctionsActivity();

	IFibonacciFunctionPageObject goBackByBackButtonToFibonacciFunctionsActivity();
}