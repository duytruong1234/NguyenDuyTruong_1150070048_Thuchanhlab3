package com.example.lab3duytruong;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
public class ColorChooserActivity extends AppCompatActivity {
    private SeekBar seekBarR, seekBarG, seekBarB;
    private SeekBar seekBarC, seekBarM, seekBarY;
    private TextView tvRValue, tvGValue, tvBValue;
    private TextView tvCValue, tvMValue, tvYValue;
    private View viewRGB, viewCMY;
    private int red = 0, green = 100, blue = 16;
    private int cyan = 0, magenta = 0, yellow = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_chooser);
        seekBarR = findViewById(R.id.seekBarR);
        seekBarG = findViewById(R.id.seekBarG);
        seekBarB = findViewById(R.id.seekBarB);
        tvRValue = findViewById(R.id.tvRValue);
        tvGValue = findViewById(R.id.tvGValue);
        tvBValue = findViewById(R.id.tvBValue);
        viewRGB = findViewById(R.id.viewRGB);
        seekBarC = findViewById(R.id.seekBarC);
        seekBarM = findViewById(R.id.seekBarM);
        seekBarY = findViewById(R.id.seekBarY);
        tvCValue = findViewById(R.id.tvCValue);
        tvMValue = findViewById(R.id.tvMValue);
        tvYValue = findViewById(R.id.tvYValue);
        viewCMY = findViewById(R.id.viewCMY);
        setupRGBSeekBars();
        setupCMYSeekBars();
        updateRGBColor();
        updateCMYColor();
    }
    private void setupRGBSeekBars() {
        seekBarR.setMax(255);
        seekBarG.setMax(255);
        seekBarB.setMax(255);

        seekBarR.setProgress(red);
        seekBarG.setProgress(green);
        seekBarB.setProgress(blue);

        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                updateRGBColor();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                updateRGBColor();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                updateRGBColor();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
    private void setupCMYSeekBars() {
        seekBarC.setMax(255);
        seekBarM.setMax(255);
        seekBarY.setMax(255);

        seekBarC.setProgress(cyan);
        seekBarM.setProgress(magenta);
        seekBarY.setProgress(yellow);

        seekBarC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cyan = progress;
                updateCMYColor();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                magenta = progress;
                updateCMYColor();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                yellow = progress;
                updateCMYColor();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
    private void updateRGBColor() {
        tvRValue.setText("R = " + red);
        tvGValue.setText("G = " + green);
        tvBValue.setText("B = " + blue);
        viewRGB.setBackgroundColor(Color.rgb(red, green, blue));
    }
    private void updateCMYColor() {
        tvCValue.setText("C = " + cyan);
        tvMValue.setText("M = " + magenta);
        tvYValue.setText("Y = " + yellow);
        int r = 255 - cyan;
        int g = 255 - magenta;
        int b = 255 - yellow;
        viewCMY.setBackgroundColor(Color.rgb(r, g, b));
    }
}

