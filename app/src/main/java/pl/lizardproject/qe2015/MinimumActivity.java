package pl.lizardproject.qe2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MinimumActivity extends Activity {

    @InjectView(R.id.numberList)
    protected EditText numberList;
    @InjectView(R.id.outcome)
    protected TextView outcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimum);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.function)
    protected void functionClicked() {
        final String numberListString = numberList.getText().toString();
        final List<Integer> integers;
        if(!numberListString.isEmpty()) {
            integers = NumberListParser.parseList(numberListString, ",");
            final Integer min = Collections.min(integers);
            outcome.setText(min.toString());
        }
    }

    @OnClick(R.id.previousFunction)
    protected void previousButtonClicked() {
        onBackPressed();
    }

    @OnClick(R.id.nextFunction)
    protected void nextButtonClicked() {
        startActivity(new Intent(this, MaximumActivity.class));
    }

}
