package com.example.crystal.contact;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.MenuInflater;
import android.util.Log;



import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.crystal.contact.IndexBar;
import com.example.crystal.contact.suspension.SuspensionDecoration;

import java.util.ArrayList;
import java.util.List;

import com.example.crystal.contact.model.FriendsBean;
import com.example.crystal.contact.R;
import com.example.crystal.contact.adapter.FriendsAdapter;
import com.example.crystal.contact.decoration.DividerItemDecoration;


public class Contacts extends Fragment {

    public Contacts() {
        // Required empty public constructor
    }

    private static final String TAG = "zxt";
    private static final String INDEX_STRING_TOP = "↑";
    private RecyclerView mRv;
    private FriendsAdapter mAdapter;
    private LinearLayoutManager mManager;
    private List<FriendsBean> mDatas = new ArrayList<>();

    private SuspensionDecoration mDecoration;

    /**
     * 右侧边栏导航区域
     */
    private IndexBar mIndexBar;

    /**
     * 显示指示器DialogText
     */
    private TextView mTvSideBarHint;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView() " + savedInstanceState);
        setHasOptionsMenu(true);

        return inflater.inflate(R.layout.first, container, false);
    }

    @Override

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated(): " + savedInstanceState);

        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar =(Toolbar) view.findViewById(R.id.toolbar);//得到Toolbar的实例
        toolbar.inflateMenu(R.menu.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                                               public boolean onMenuItemClick(MenuItem item) {
                                                   switch (item.getItemId()) {
                                                       case R.id.addpeople:
                                                           Toast.makeText(getActivity(), "You clicked addpeople", Toast.LENGTH_SHORT).show();
                                                           break;
                                                       default:
                                                   }
                                                   return true;
                                               }
                                           });

        mRv = (RecyclerView) view.findViewById(R.id.recycler_view); //得到recyclerview的实例
        mRv.setLayoutManager(mManager = new LinearLayoutManager(this.getActivity()));

        mAdapter = new FriendsAdapter(this.getActivity(), mDatas);
        mRv.setAdapter(mAdapter);
        mRv.addItemDecoration(mDecoration = new SuspensionDecoration(this.getActivity(), mDatas));
        //如果add两个，那么按照先后顺序，依次渲染。
        mRv.addItemDecoration(new DividerItemDecoration(this.getActivity(), DividerItemDecoration.VERTICAL_LIST));

        //使用indexbar
        mTvSideBarHint = (TextView) view.findViewById(R.id.tvSideBarHint);//HintTextView
        mIndexBar = (IndexBar) view.findViewById(R.id.indexBar);//IndexBar

        //indexbar初始化
        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(true)//设置需要真实的索引
                .setmLayoutManager(mManager);//设置RecyclerView的LayoutManager

        //模拟线上加载数据
        initDatas(getResources().getStringArray(R.array.Friends_name));

    }




    /**
     * 组织数据源
     *
     * @param data
     * @return
     */
    private void initDatas(final String[] data) {
        //延迟两秒 模拟加载数据中....
        getActivity().getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                mDatas = new ArrayList<>();
                //微信的头部 也是可以右侧IndexBar导航索引的，
                // 但是它不需要被ItemDecoration设一个标题titile

                for (int i = 0; i < data.length; i++) {
                    FriendsBean friendsBean = new FriendsBean();
                    friendsBean.AddFriends(data[i]);//设置城市名称
                    mDatas.add(friendsBean);
                }
                mAdapter.setDatas(mDatas);
                mAdapter.notifyDataSetChanged();

                mIndexBar.setmSourceDatas(mDatas)//设置数据
                        .invalidate();
                mDecoration.setmDatas(mDatas);
            }
        }, 500);
    }

    /**
     * 更新数据源
     *
     * @param view
     */
    public void updateDatas(View view) {
        for (int i = 0; i < 5; i++) {
            mDatas.add(new FriendsBean("Crystal"));
            mDatas.add(new FriendsBean("SooJung"));
        }

        mIndexBar.setmSourceDatas(mDatas)
                .invalidate();
        mAdapter.notifyDataSetChanged();
    }
}
