package com.kingwanyama.customlist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter2 extends BaseAdapter {
    Context mContext;
    ArrayList<Item> data;//modify here
    public CustomAdapter2(Context context, ArrayList<Item> data) //modify here
    {
        this.mContext = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual movie
    }
    @Override
    public long getItemId(int id) {
        return id;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_layout2, parent,false);//modify here
            viewHolder = new ViewHolder();
            //modify this block of code
            viewHolder.tvnames = (TextView) convertView.findViewById(R.id.tvnames);
            viewHolder.tvemail = (TextView) convertView.findViewById(R.id.tvemail);
            viewHolder.tvamount = (TextView) convertView.findViewById(R.id.tvamount);
            viewHolder.imgPoster=(ImageView) convertView.findViewById(R.id.imgPoster);
            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        Item b = data.get(position);//modify here
        viewHolder.tvnames.setText(b.getNames());//modify here
        viewHolder.tvemail.setText(b.getEmail());//modify here
        viewHolder.tvamount.setText("Ksh"+b.getAmount());//modify here
        viewHolder.imgPoster.setImageResource(b.getPoster());
        return convertView;

    }
    static class ViewHolder
    {
        TextView tvnames;
        TextView tvemail;
        TextView tvamount;//These don't have to be same names as the Id's
        ImageView imgPoster;
        //MODIFY THIS BLOCK OF CODE
        //TextView textViewTitle;
        //ImageView imageViewDish;
    }

}