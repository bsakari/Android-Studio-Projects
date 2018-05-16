package com.kingwanyama.complex_list;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kingwanyama on 12/18/17.
 */

class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Item>data;



    public CustomAdapter(Context context, ArrayList<Item> data) {
        this.mContext = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null)

        {
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvnames = convertView.findViewById(R.id.tvnames);
            viewHolder.tvemail = convertView.findViewById(R.id.tvemail);
            viewHolder.tvamount = convertView.findViewById(R.id.tvamount);
            viewHolder.imgPoster = convertView.findViewById(R.id.imgPoster);
            convertView.setTag(viewHolder);

        }
        else
            {
                viewHolder = (ViewHolder)convertView.getTag();
            }
        Item b = data.get(position);
        viewHolder.tvnames.setText(b.getNames());
        viewHolder.tvemail.setText(b.getEmail());
        viewHolder.tvamount.setText("Ksh" + b.getAmount());
        viewHolder.imgPoster.setImageResource(b.getPoster());
        return convertView;

    }

    static class ViewHolder {
        TextView tvnames;
        TextView tvemail;
        TextView tvamount;
        ImageView imgPoster;
    }
}
