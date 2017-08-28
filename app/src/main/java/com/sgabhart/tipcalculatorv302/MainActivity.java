package com.sgabhart.tipcalculatorv302;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TipCalculator tc;
    public NumberFormat money = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tc = new TipCalculator(0.17f, 100.0f);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        Log.w("MainActivity", "view = " + view);
        EditText billEdit = (EditText)(findViewById(R.id.amount_bill));
        EditText tipEdit = (EditText)(findViewById(R.id.amount_tip_percent));
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
}
