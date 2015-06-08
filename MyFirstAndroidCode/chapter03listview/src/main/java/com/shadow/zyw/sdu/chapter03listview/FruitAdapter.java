package com.shadow.zyw.sdu.chapter03listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shadow on 2015/6/8.
 */
public class FruitAdapter extends ArrayAdapter<Fruit>{
    private int resId;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit =  getItem(position);
        View view;
        ViewHolder viewHolder = new ViewHolder();
        if (convertView ==null) {
            view = LayoutInflater.from(getContext()).inflate(resId, null);
            viewHolder.id = (TextView) view.findViewById(R.id.fruit_id);
            viewHolder.name = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.name.setText(fruit.getName());
        viewHolder.id.setText(String.valueOf(fruit.getId()));
        return view;


    }

    class ViewHolder {
        TextView id;
        TextView name;
    }
    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resId = resource;
    }
}
