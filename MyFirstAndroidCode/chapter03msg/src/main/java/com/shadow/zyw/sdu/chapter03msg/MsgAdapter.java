package com.shadow.zyw.sdu.chapter03msg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shadow.zyw.sdu.chapter03msg.R;

import java.util.List;

/**
 * Created by shadow on 2015/6/8.
 */
public class MsgAdapter extends ArrayAdapter<Msg>{
    private int resId;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = getItem(position);
        View view = null;
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resId, null);
            viewHolder.left_layout = (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.right_layout = (LinearLayout) view.findViewById(R.id.right_layout);
            viewHolder.left_msg = (TextView) view.findViewById(R.id.left_tv);
            viewHolder.right_msg = (TextView) view.findViewById(R.id.right_tv);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (msg.getType() == msg.RECEIVE) {
            viewHolder.right_layout.setVisibility(View.GONE);
            viewHolder.left_layout.setVisibility(View.VISIBLE);
            viewHolder.left_msg.setText(msg.getMsg());
        }
        else {
            viewHolder.left_layout.setVisibility(View.GONE);
            viewHolder.right_layout.setVisibility(View.VISIBLE);
            viewHolder.right_msg.setText(msg.getMsg());
        }


        return view;
    }
    class ViewHolder{
        LinearLayout left_layout;
        LinearLayout right_layout;
        TextView left_msg;
        TextView right_msg;

    }

    public MsgAdapter(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
        resId = resource;
    }
}
