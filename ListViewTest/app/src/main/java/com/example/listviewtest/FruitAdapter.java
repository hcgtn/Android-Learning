package com.example.listviewtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private final int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    static class ViewHolder {
        TextView fruitName;
        ImageView fruitImage;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        assert fruit != null;

//        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        View view;
        ViewHolder viewHolder;
        String s;
        // convertView：将之前加载好的布局进行缓存
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitName = view.findViewById(R.id.fruit_name);
            viewHolder.fruitImage = view.findViewById(R.id.fruit_image);
            view.setTag(viewHolder); // 将 ViewHolder 储存在View中
            s = fruit.getName();
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取 ViewHoler
            s = "Item " + position + ": " + fruit.getName();
        }
//        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitName.setText(s);
        // 已经获取搭到 viewHolder 了
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(s);
        return view;
    }
}
