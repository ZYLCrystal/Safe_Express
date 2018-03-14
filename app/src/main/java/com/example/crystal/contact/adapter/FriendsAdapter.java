package com.example.crystal.contact.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import com.example.crystal.contact.model.FriendsBean;
import com.example.crystal.contact.R;


public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {
    protected Context mContext;
    protected List<FriendsBean> mDatas;
    protected LayoutInflater mInflater;

    public FriendsAdapter(Context mContext, List<FriendsBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    public List<FriendsBean> getDatas() {
        return mDatas;
    }

    public FriendsAdapter setDatas(List<FriendsBean> datas) {
        mDatas = datas;
        return this;
    }

    @Override
    public FriendsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(final FriendsAdapter.ViewHolder holder, final int position) {
        final FriendsBean friendBean = mDatas.get(position);
        holder.tvFriends.setText(friendBean.getName());
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "pos:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFriends;
        View content;

        public ViewHolder(View itemView) {
            super(itemView);
            tvFriends = (TextView) itemView.findViewById(R.id.tvFriends);
            content = itemView.findViewById(R.id.content);
        }
    }
}

