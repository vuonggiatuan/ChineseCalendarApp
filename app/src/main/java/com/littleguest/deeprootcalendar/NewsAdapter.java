package com.littleguest.deeprootcalendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Garfield on 2018/5/15.
 */

public class NewsAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater mInflater;
    ArrayList<News> mDataSource;

    public NewsAdapter(Context context, ArrayList<News> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_news, parent, false);
        TextView courseid=(TextView) rowView.findViewById(R.id.newsid);
        TextView titleTextView = (TextView) rowView.findViewById(R.id.titleTxt);
        TextView descTextView = (TextView) rowView.findViewById(R.id.descTxt);
        ImageView thumbnailImageView = (ImageView) rowView.findViewById(R.id.newsIcon);


        News listitem = (News) getItem(position);
        courseid.setText(listitem.id);
        titleTextView.setText(listitem.title);
        descTextView.setText(listitem.description);
        Picasso.with(mContext).load(listitem.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        return rowView;
    }
}
