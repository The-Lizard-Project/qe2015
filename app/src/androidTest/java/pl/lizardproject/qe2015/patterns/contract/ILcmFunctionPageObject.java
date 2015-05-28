package pl.lizardproject.qe2015.patterns.contract;

public interface ILcmFunctionPageObject {

	void fillFirstNumber(String text);

	void fillSecondNumber(String text);

	void clickFunction();

	boolean waitForResult(String expected);

	String getDisplayedResult();

	IPrimeFunctionPageObject goToPrimeFunctionsActivity();

	IGcdFunctionPageObject goBackToGcdFunctionsActivity();

	IGcdFunctionPageObject goBackByBackButtonToGcdFunctionsActivity();
}