package com.example.lab3duytruong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends BaseAdapter {
    private Context context;
    private List<Dish> dishList;
    private OnDishActionListener listener;

    public interface OnDishActionListener {
        void onEdit(int position);
        void onDelete(int position);
    }

    public DishAdapter(Context context, List<Dish> dishList, OnDishActionListener listener) {
        this.context = context;
        this.dishList = dishList;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return dishList.size();
    }

    @Override
    public Object getItem(int position) {
        return dishList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, parent, false);
            holder = new ViewHolder();
            holder.imgDish = convertView.findViewById(R.id.imgDish);
            holder.txtDishName = convertView.findViewById(R.id.txtDishName);
            holder.txtDishDescription = convertView.findViewById(R.id.txtDishDescription);
            holder.txtDishPrice = convertView.findViewById(R.id.txtDishPrice);
            holder.btnEdit = convertView.findViewById(R.id.btnEdit);
            holder.btnDelete = convertView.findViewById(R.id.btnDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Dish dish = dishList.get(position);
        holder.imgDish.setImageResource(dish.getImageResourceId());
        holder.txtDishName.setText(dish.getName());
        holder.txtDishDescription.setText(dish.getDescription());
        holder.txtDishPrice.setText(dish.getPrice());

        holder.btnEdit.setOnClickListener(v -> {
            if (listener != null) {
                listener.onEdit(position);
            }
        });

        holder.btnDelete.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDelete(position);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        ImageView imgDish;
        TextView txtDishName;
        TextView txtDishDescription;
        TextView txtDishPrice;
        ImageButton btnEdit;
        ImageButton btnDelete;
    }
}

