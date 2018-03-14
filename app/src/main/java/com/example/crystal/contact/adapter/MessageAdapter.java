package com.example.crystal.contact.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.crystal.contact.R;
import com.example.crystal.contact.model.MessageL;
import java.util.LinkedList;

/**
 * Created by Claudia on 2018/2/2.
 */

public class MessageAdapter extends BaseAdapter {

    private LinkedList<MessageL> mData;
    private Context mContext;

    public MessageAdapter(LinkedList<MessageL> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.message_item,parent,false);
        ImageView img_icon = (ImageView) convertView.findViewById(R.id.imgtou);
        TextView txt_aName = (TextView) convertView.findViewById(R.id.name);
        TextView txt_aSpeak = (TextView) convertView.findViewById(R.id.says);
        img_icon.setBackgroundResource(mData.get(position).getaIcon());
        txt_aName.setText(mData.get(position).getaName());
        txt_aSpeak.setText(mData.get(position).getaSpeak());
        return convertView;
    }
}
