package pl.lizardproject.qe2015.patterns.assertion;

import android.widget.TextView;

import com.robotium.solo.Solo;

import junit.framework.Assert;

import pl.lizardproject.qe2015.Util.DisplayCondition;

public class QEAsserts {

    private final Solo solo;

    public QEAsserts(Solo solo) {
        this.solo = solo;
    }

    public void assertThatViewEqualsText(TextView view, String expected) {
        solo.waitForCondition(new DisplayCondition(view, expected), 2000);
        Assert.assertEquals(expected, view.getText().toString());
    }
}
