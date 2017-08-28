package com.sgabhart.tipcalculatorv4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import android.text.Editable;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity {

    private TipCalculator tc;
    public NumberFormat money = NumberFormat.getCurrencyInstance();
    private EditText billEdit;
    private EditText tipEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tc = new TipCalculator(0.17f, 100.0f);
        setContentView(R.layout.activity_main);

        billEdit = (EditText)(findViewById(R.id.amount_bill));
        tipEdit = (EditText)(findViewById(R.id.amount_tip_percent));

        TextChangeHandler tch = new TextChangeHandler();
        billEdit.addTextChangedListener(tch);
        tipEdit.addTextChangedListener(tch);
    }

    public void calculate() {
        String billStr = billEdit.getText().toString();
        String tipStr = tipEdit.getText().toString();

        TextView tipText = (TextView)(findViewById(R.id.amount_tip));
        TextView totalText = (TextView)(findViewById(R.id.amount_total));

        try{
            float billAmount = Float.parseFloat(billStr);
            int tipPercent = Integer.parseInt(tipStr);

            tc.setBill(billAmount);
            tc.setTip(tipPercent);

            float tip = tc.tipAmount();
            float total = tc.totalAmount();

            tipText.setText(money.format(tip));
            totalText.setText(money.format(total));
        } catch (NumberFormatException e) {

        }
    }

    private class TextChangeHandler implements TextWatcher {
        public void afterTextChanged(Editable e){
            calculate();
        }

        public void beforeTextChanged(CharSequence cs, int start, int count, int after){

        }

        public void onTextChanged(CharSequence cs, int start, int before, int after){

        }
    }
}
