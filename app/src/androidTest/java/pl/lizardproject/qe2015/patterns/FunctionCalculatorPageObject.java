package pl.lizardproject.qe2015.patterns;

import android.view.View;
import android.widget.TextView;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.R;
import pl.lizardproject.qe2015.Util.DisplayCondition;

public class FunctionCalculatorPageObject {

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

	private final View buttonFib;
	private final View buttonLcm;
	private final View buttonPri;
	private final View buttonGcd;
	private final View buttonEqual;
	private final TextView viewDisplay;

	public FunctionCalculatorPageObject(Solo solo) {
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
		buttonFib = solo.getView(R.id.buttonFib);
		buttonLcm = solo.getView(R.id.buttonLcm);
		buttonPri = solo.getView(R.id.buttonPri);
		buttonGcd = solo.getView(R.id.buttonGcd);
		buttonEqual = solo.getView(R.id.buttonEq);
		viewDisplay = (TextView) solo.getView(R.id.calculatorViewPort);
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

	public void clickFibonacci() {
		solo.clickOnView(buttonFib);
	}

	public void clickLcm() {
		solo.clickOnView(buttonLcm);
	}

	public void clickPrime() {
		solo.clickOnView(buttonPri);
	}

	public void clickGcd() {
		solo.clickOnView(buttonGcd);
	}

	public void clickEqual() {
		solo.clickOnView(buttonEqual);
	}

	public boolean waitForResult(String expected) {
		return solo.waitForCondition(new DisplayCondition(viewDisplay, expected), 2000);
	}

	public String getDisplayedResult() {
		return viewDisplay.getText().toString();
	}
}