package pl.lizardproject.qe2015.patterns;

import android.widget.Button;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.ExtendedActivity;
import pl.lizardproject.qe2015.MainActivity;
import pl.lizardproject.qe2015.R;

public class NavigationPageObject {

	private final Solo solo;

	private final Button buttonFunctions;

	public NavigationPageObject(Solo solo) {
		this.solo = solo;

		buttonFunctions = (Button) solo.getView(R.id.functions);
	}

	public FunctionCalculatorPageObject goToFunctionsActivity() {
		solo.clickOnView(buttonFunctions);
		solo.waitForActivity(ExtendedActivity.class, 2000);

		return new FunctionCalculatorPageObject(solo);
	}

	public SimpleCalculatorPageObject goBackFromFunctionsActivity() {
		solo.goBack();
		solo.waitForActivity(MainActivity.class, 2000);

		return new SimpleCalculatorPageObject(solo);
	}

	public void finishOpenedActivities() {
		solo.finishOpenedActivities();
	}
}