package com.example.crystal.contact.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.widget.Button;

import com.example.crystal.contact.R;
import com.example.crystal.contact.activity.OnlineService;
import com.example.crystal.contact.activity.PointsMall;
import com.example.crystal.contact.activity.Proposal;
import com.example.crystal.contact.activity.SentRecords;
import com.example.crystal.contact.activity.TransactionRecord;

import java.util.concurrent.atomic.AtomicReference;

/**
 * A simple {@link Fragment} subclass.
 */

public class Me extends Fragment implements View.OnClickListener{

    public Button fw;// 服务热线，暂时没有设置跳转
    public Button kf;
    public Button ts;
    public Button jy;
    public Button jf;
    public Button jj;
    //public Button st;
    public Button testt;

    private static final String TAG = "me";



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView() " + savedInstanceState);
        setHasOptionsMenu(true);

        return inflater.inflate(R.layout.fragment_me, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated(): " + savedInstanceState);

        super.onViewCreated(view, savedInstanceState);

        fw = (Button)view.findViewById(R.id.fuwu);
        kf =(Button)view.findViewById(R.id.kefu);
        ts =(Button)view.findViewById(R.id.tousu);
        jy =(Button)view.findViewById(R.id.jiaoyi);
        jf =(Button)view.findViewById(R.id.jifen);
        jj =(Button)view.findViewById(R.id.jijianjilu);
        //testt=(Button)view.findViewById(R.id.test1);
        /*st= (Button)findViewById(R.id.setting);*/
        //点击
        fw.setOnClickListener(this);
        kf.setOnClickListener(this);
        ts.setOnClickListener(this);
        jy.setOnClickListener(this);
        jf.setOnClickListener(this);
        jj.setOnClickListener(this);
        //testt.setOnClickListener(this);
        //st.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        int v =view.getId();
        switch (v){
            case R.id.kefu:
                Intent intent =new Intent(getActivity(),OnlineService.class);
                startActivity(intent);
                break;
            case R.id.jifen:
                Intent intent1 =new Intent(getActivity(),PointsMall.class);
                startActivity(intent1);
                break;
            case R.id.tousu:
                Intent intent2 =new Intent(getActivity(),Proposal.class);
                startActivity(intent2);
                break;
            case R.id.jiaoyi:
                Intent intent3 =new Intent(getActivity(),SentRecords.class);
                startActivity(intent3);
                break;
            case R.id.jijianjilu:
                Intent intent4 =new Intent(getActivity(),TransactionRecord.class);
                startActivity(intent4);
                break;
 /*           case R.id.test1:
                Intent intent5 =new Intent(Me.this,MessageList.class);
                startActivity(intent5);
                break;*/

        }

    }
}







