package com.example.lab3duytruong;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText edtValue;
    private Spinner spinnerUnit;
    private LinearLayout layoutResults;
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValue = findViewById(R.id.edtValue);
        spinnerUnit = findViewById(R.id.spinnerUnit);
        layoutResults = findViewById(R.id.layoutResults);

        decimalFormat = new DecimalFormat("#,###.####");
        decimalFormat = new DecimalFormat("#,###.####");

        String[] units = LengthConverter.getAllUnits();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnit.setAdapter(adapter);

        edtValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                convertAndDisplay();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        spinnerUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertAndDisplay();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void convertAndDisplay() {
        String valueStr = edtValue.getText().toString();
        if (valueStr.isEmpty()) {
            layoutResults.removeAllViews();
            return;
        }

        try {
            double value = Double.parseDouble(valueStr);
            String fromUnit = spinnerUnit.getSelectedItem().toString();

            Map<String, Double> results = LengthConverter.convertToAll(value, fromUnit);

            layoutResults.removeAllViews();

            int index = 0;
            for (Map.Entry<String, Double> entry : results.entrySet()) {
                LinearLayout resultRow = new LinearLayout(this);
                resultRow.setOrientation(LinearLayout.HORIZONTAL);
                resultRow.setPadding(16, 12, 16, 12);

                if (index % 2 == 0) {
                    resultRow.setBackgroundColor(Color.parseColor("#E3F2FD"));
                } else {
                    resultRow.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }

                TextView tvValue = new TextView(this);
                tvValue.setText(decimalFormat.format(entry.getValue()));
                tvValue.setTextSize(16);
                tvValue.setTextColor(Color.parseColor("#212121"));
                tvValue.setLayoutParams(new LinearLayout.LayoutParams(
                        0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
                tvValue.setPadding(8, 0, 8, 0);

                TextView tvUnit = new TextView(this);
                tvUnit.setText(entry.getKey());
                tvUnit.setTextSize(16);
                tvUnit.setTextColor(Color.parseColor("#0097A7"));
                tvUnit.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                tvUnit.setGravity(Gravity.END);
                tvUnit.setPadding(8, 0, 8, 0);

                resultRow.addView(tvValue);
                resultRow.addView(tvUnit);
                layoutResults.addView(resultRow);

                index++;
            }

        } catch (NumberFormatException e) {
            layoutResults.removeAllViews();
        }
    }
}