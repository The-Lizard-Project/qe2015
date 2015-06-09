package pl.lizardproject.qe2015.patterns.page_object.base;

import android.widget.EditText;

import com.robotium.solo.Solo;

import pl.lizardproject.qe2015.R;

public class ExtendedFunctionPageObject extends BaseFunctionPageObject {

    protected final EditText viewSecondNumber;

    protected ExtendedFunctionPageObject(Solo solo) {
        super(solo);
        viewSecondNumber = (EditText) solo.getView(R.id.secondNumber);
    }

    protected void typeIntoSecondNumber(String number) {
        solo.typeText(viewSecondNumber, number);
    }
}
