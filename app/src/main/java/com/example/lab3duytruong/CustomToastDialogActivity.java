package com.example.lab3duytruong;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomToastDialogActivity extends AppCompatActivity {

    private Button btnShowToast;
    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast_dialog);

        btnShowToast = findViewById(R.id.btnShowToast);
        btnShowDialog = findViewById(R.id.btnShowDialog);

        btnShowToast.setOnClickListener(v -> showCustomToast());
        btnShowDialog.setOnClickListener(v -> showCustomDialog());
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
        Button btnCancel = dialog.findViewById(R.id.btnDialogCancel);

        btnOption1.setOnClickListener(v -> {
            Toast.makeText(this, "Chọn Option 1", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        btnOption2.setOnClickListener(v -> {
            Toast.makeText(this, "Chọn Option 2", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        btnCancel.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}

