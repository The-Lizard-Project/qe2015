package pl.lizardproject.qe2015.Util;

import android.widget.TextView;

import com.robotium.solo.Condition;

public class DisplayCondition implements Condition {

	private TextView displayer;
	private String expected;

	public DisplayCondition(TextView displayer, String expected) {
		this.displayer = displayer;
		this.expected = expected;
	}

	@Override
	public boolean isSatisfied() {
		return displayer.getText().equals(expected);
	}
}