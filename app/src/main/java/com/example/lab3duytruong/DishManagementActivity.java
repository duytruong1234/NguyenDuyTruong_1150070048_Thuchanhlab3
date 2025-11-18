package com.example.lab3duytruong;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DishManagementActivity extends AppCompatActivity implements DishAdapter.OnDishActionListener {
    
    private ListView listView;
    private DishAdapter adapter;
    private List<Dish> dishList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_management);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Đồ ăn nhanh Minh Nhật");
        }

        listView = findViewById(R.id.listViewDishes);
        initializeDishList();
        
        adapter = new DishAdapter(this, dishList, this);
        listView.setAdapter(adapter);
    }

    private void initializeDishList() {
        dishList = new ArrayList<>();
        
        dishList.add(new Dish("Hamburger", "Bánh mỳ kẹp thịt bò", "Giá 12.000đ", R.drawable.banhmi));
        dishList.add(new Dish("Bánh mì", "Bánh mì Sài Gòn", "Giá 10.000đ", R.drawable.banhmi));
        dishList.add(new Dish("Bánh bao", "Bánh bao nhân thịt xông", "Giá 12.000đ", R.drawable.banhmi));
        dishList.add(new Dish("Bánh ú", "Bánh ú đậu xanh cho lễ, tế", "Giá 12.000đ", R.drawable.banhmi));
        dishList.add(new Dish("Bánh gối chay", "Bánh gối chay bằng nộm lá tía", "Giá 12.000đ", R.drawable.banhmi));
        dishList.add(new Dish("Bánh gối nhân thịt", "Bánh gối nhân thịt nạc nấm rơm", "Giá 8.000đ", R.drawable.banhmi));
    }

    @Override
    public void onEdit(int position) {
        Dish dish = dishList.get(position);
        showEditDialog(dish, position);
    }

    @Override
    public void onDelete(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Xóa món ăn")
                .setMessage("Bạn có chắc chắn muốn xóa món ăn này?")
                .setPositiveButton("Xóa", (dialog, which) -> {
                    dishList.remove(position);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Đã xóa món ăn", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Hủy", null)
                .show();
    }

    private void showEditDialog(Dish dish, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chỉnh sửa món ăn");

        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_dish, null);
        EditText edtName = dialogView.findViewById(R.id.edtDishName);
        EditText edtDescription = dialogView.findViewById(R.id.edtDishDescription);
        EditText edtPrice = dialogView.findViewById(R.id.edtDishPrice);

        edtName.setText(dish.getName());
        edtDescription.setText(dish.getDescription());
        edtPrice.setText(dish.getPrice());

        builder.setView(dialogView);
        builder.setPositiveButton("Lưu", (dialog, which) -> {
            dish.setName(edtName.getText().toString());
            dish.setDescription(edtDescription.getText().toString());
            dish.setPrice(edtPrice.getText().toString());
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Đã cập nhật món ăn", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Hủy", null);

        builder.show();
    }
}

