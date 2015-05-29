package pl.lizardproject.qe2015;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import pl.lizardproject.qe2015.calc.structure.TreePrinter;
import pl.lizardproject.qe2015.calc.util.NumberListParser;

public class MinMaxActivity extends Activity {

    @InjectView(R.id.numberList)
    protected EditText numberList;
    @InjectView(R.id.outcome)
    protected TextView outcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minmax);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.min)
    protected void minClicked() {
        final String numberListString = numberList.getText().toString();
        final List<Double> integers;
        if (!numberListString.isEmpty()) {
            integers = NumberListParser.parseList(numberListString, ",");
            if (integers.size() > 0) {
                final Double min = Collections.min(integers);
                outcome.setText(TreePrinter.df.format(min));
            } else {
                Toast.makeText(this, "Incorrect format of number list", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick(R.id.max)
    protected void maxClicked() {
        final String numberListString = numberList.getText().toString();
        final List<Double> integers;
        if (!numberListString.isEmpty()) {
            integers = NumberListParser.parseList(numberListString, ",");
            if (integers.size() > 0) {
                final Double max = Collections.max(integers);
                outcome.setText(TreePrinter.df.format(max));
            } else {
                Toast.makeText(this, "Incorrect format of number list", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick(R.id.previousFunction)
    protected void previousButtonClicked() {
        onBackPressed();
    }
}