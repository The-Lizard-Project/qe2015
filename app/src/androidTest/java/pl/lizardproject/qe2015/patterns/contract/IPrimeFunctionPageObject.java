package pl.lizardproject.qe2015.patterns.contract;

public interface IPrimeFunctionPageObject {

	void fillFirstNumber(String text);

	void clickFunction();

	boolean waitForResult(String expected);

	String getDisplayedResult();

	ILcmFunctionPageObject goBackToLcmFunctionsActivity();

	ILcmFunctionPageObject goBackByBackButtonToLcmFunctionsActivity();
}