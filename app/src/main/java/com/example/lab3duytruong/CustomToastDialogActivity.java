package com.example.lab3duytruong;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomToastDialogActivity extends AppCompatActivity {

    private Button btnShowToast;
    private Button btnShowDialog;
    private LinearLayout layoutSelectors;
    private LinearLayout layoutShapes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast_dialog);

        btnShowToast = findViewById(R.id.btnShowToast);
        btnShowDialog = findViewById(R.id.btnShowDialog);
        layoutSelectors = findViewById(R.id.layoutSelectors);
        layoutShapes = findViewById(R.id.layoutShapes);

        btnShowToast.setOnClickListener(v -> showCustomToast());
        btnShowDialog.setOnClickListener(v -> showCustomDialog());

        createSelectorButtons();
        createShapeButtons();
    }

    private void createSelectorButtons() {
        int buttonWidth = (int) (160 * getResources().getDisplayMetrics().density);
        int buttonHeight = (int) (55 * getResources().getDisplayMetrics().density);

        Button btn1 = new Button(this);
        btn1.setText("ROUNDED RECTANGLE");
        btn1.setBackgroundResource(R.drawable.button_selector_cyan);
        btn1.setTextColor(Color.WHITE);
        btn1.setTextSize(10);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                buttonWidth,
                buttonHeight
        );
        params1.setMargins(12, 12, 12, 12);
        btn1.setLayoutParams(params1);
        btn1.setPadding(16, 16, 16, 16);
        layoutSelectors.addView(btn1);

        Button btn2 = new Button(this);
        btn2.setText("RECTANGLE");
        btn2.setBackgroundResource(R.drawable.button_selector_yellow);
        btn2.setTextColor(Color.BLACK);
        btn2.setTextSize(12);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                buttonWidth,
                buttonHeight
        );
        params2.setMargins(12, 12, 12, 12);
        btn2.setLayoutParams(params2);
        btn2.setPadding(16, 16, 16, 16);
        layoutSelectors.addView(btn2);

        Button btn3 = new Button(this);
        btn3.setText("⭐");
        btn3.setTextSize(32);
        btn3.setBackgroundResource(R.drawable.button_selector_circle);
        int circleSize = (int) (100 * getResources().getDisplayMetrics().density);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(
                circleSize, circleSize
        );
        params3.setMargins(12, 20, 12, 12);
        btn3.setLayoutParams(params3);
        layoutSelectors.addView(btn3);
    }

    private void createShapeButtons() {
        int buttonWidth = (int) (150 * getResources().getDisplayMetrics().density);
        int buttonHeight = (int) (55 * getResources().getDisplayMetrics().density);

        Button btnShape1 = new Button(this);
        btnShape1.setText("ROUNDED SHAPE");
        btnShape1.setBackgroundResource(R.drawable.button_shape_rounded_border);
        btnShape1.setTextColor(Color.BLACK);
        btnShape1.setTextSize(9);
        btnShape1.setAllCaps(true);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                buttonWidth, buttonHeight
        );
        params1.setMargins(8, 12, 8, 12);
        btnShape1.setLayoutParams(params1);
        layoutShapes.addView(btnShape1);

        Button btnShape2 = new Button(this);
        btnShape2.setText("GRADIENT ROUNDED");
        btnShape2.setBackgroundResource(R.drawable.button_shape_gradient);
        btnShape2.setTextColor(Color.WHITE);
        btnShape2.setTextSize(9);
        btnShape2.setAllCaps(true);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                buttonWidth, buttonHeight
        );
        params2.setMargins(8, 12, 8, 12);
        btnShape2.setLayoutParams(params2);
        layoutShapes.addView(btnShape2);

        Button btnShape3 = new Button(this);
        btnShape3.setText("😊");
        btnShape3.setTextSize(32);
        btnShape3.setBackgroundResource(R.drawable.button_shape_square);
        int squareSize = (int) (90 * getResources().getDisplayMetrics().density);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(
                squareSize, squareSize
        );
        params3.setMargins(8, 12, 8, 12);
        btnShape3.setLayoutParams(params3);
        layoutShapes.addView(btnShape3);
    }

    private void showCustomToast() {
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);

        View toastView = getLayoutInflater().inflate(R.layout.custom_toast_layout, null);

        toast.setView(toastView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    private void showCustomDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        Button btnOption1 = dialog.findViewById(R.id.btnDialogOption1);
        Button btnOption2 = dialog.findViewById(R.id.btnDialogOption2);
        btnOption1.setOnClickListener(v -> {
            Toast.makeText(this, "Đã đồng ý đăng nhập", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        btnOption2.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }
}

