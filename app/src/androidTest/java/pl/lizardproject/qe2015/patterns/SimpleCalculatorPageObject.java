package pl.lizardproject.qe2015.patterns;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.FibonacciActivity;
import pl.lizardproject.qe2015.R;
import pl.lizardproject.qe2015.Util.DisplayCondition;
import pl.lizardproject.qe2015.patterns.contract.IFibonacciFunctionPageObject;

public class SimpleCalculatorPageObject {

	private final Solo solo;

	private final View buttonZero;
	private final View buttonOne;
	private final View buttonTwo;
	private final View buttonThree;
	private final View buttonFour;
	private final View buttonFive;
	private final View buttonSix;
	private final View buttonSeven;
	private final View buttonEight;
	private final View buttonNine;

	private final View buttonAdd;
	private final View buttonSub;
	private final View buttonMul;
	private final View buttonDiv;
	private final View buttonEqual;
	private final Button buttonFunctions;
	private final TextView viewDisplay;

	public SimpleCalculatorPageObject(Solo solo) {
		this.solo = solo;

		buttonZero = solo.getView(R.id.button0);
		buttonOne = solo.getView(R.id.button1);
		buttonTwo = solo.getView(R.id.button2);
		buttonThree = solo.getView(R.id.button3);
		buttonFour = solo.getView(R.id.button4);
		buttonFive = solo.getView(R.id.button5);
		buttonSix = solo.getView(R.id.button6);
		buttonSeven = solo.getView(R.id.button7);
		buttonEight = solo.getView(R.id.button8);
		buttonNine = solo.getView(R.id.button9);
		buttonAdd = solo.getView(R.id.buttonAdd);
		buttonSub = solo.getView(R.id.buttonSub);
		buttonMul = solo.getView(R.id.buttonMul);
		buttonDiv = solo.getView(R.id.buttonDiv);
		buttonEqual = solo.getView(R.id.buttonEq);
		viewDisplay = (TextView) solo.getView(R.id.calculatorViewPort);
		buttonFunctions = (Button) solo.getView(R.id.functions);
	}

	public void clickZero() {
		solo.clickOnView(buttonZero);
	}

	public void clickOne() {
		solo.clickOnView(buttonOne);
	}

	public void clickTwo() {
		solo.clickOnView(buttonTwo);
	}

	public void clickThree() {
		solo.clickOnView(buttonThree);
	}

	public void clickFour() {
		solo.clickOnView(buttonFour);
	}

	public void clickFive() {
		solo.clickOnView(buttonFive);
	}

	public void clickSix() {
		solo.clickOnView(buttonSix);
	}

	public void clickSeven() {
		solo.clickOnView(buttonSeven);
	}

	public void clickEight() {
		solo.clickOnView(buttonEight);
	}

	public void clickNine() {
		solo.clickOnView(buttonNine);
	}

	public void clickAdd() {
		solo.clickOnView(buttonAdd);
	}

	public void clickSubtract() {
		solo.clickOnView(buttonSub);
	}

	public void clickMultiply() {
		solo.clickOnView(buttonMul);
	}

	public void clickDivide() {
		solo.clickOnView(buttonDiv);
	}

	public void clickEqual() {
		solo.clickOnView(buttonEqual);
	}

	public IFibonacciFunctionPageObject goToFibonacciFunctionsActivity() {
		solo.clickOnView(buttonFunctions);
		solo.waitForActivity(FibonacciActivity.class, 2000);

		return new FunctionCalculatorPageObject(solo);
	}

	public boolean waitForResult(String expected) {
		return solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
	}

	public String getDisplayedResult() {
		return viewDisplay.getText().toString();
	}
}