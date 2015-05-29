package pl.lizardproject.qe2015.patterns.contract;

import pl.lizardproject.qe2015.patterns.MinMaxCalculatorPageObject;

public interface IPrimeFunctionPageObject {

    void fillFirstNumber(String text);

    void clickFunction();

    boolean waitForResult(String expected);

    String getDisplayedResult();

    MinMaxCalculatorPageObject goToMinMaxFunctionsActivity();

    ILcmFunctionPageObject goBackToLcmFunctionsActivity();

    ILcmFunctionPageObject goBackByBackButtonToLcmFunctionsActivity();
}