package com.example.crystal.contact.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.crystal.contact.R;

/**
 * Created by Claudia on 2018/1/26.
 */

public class OnlineService extends AppCompatActivity {
   /* public Button returntome;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onlineservice);
/*        returntome=(Button)findViewById(R.id.return1);

        returntome.setOnClickListener(this);*/
    }
/*
    @Override
    public void onClick(View view){
        int v =view.getId();
        switch (v){
            case R.id.return1:
                Intent intent =new Intent(OnlineService.this,Me.class);
                startActivity(intent);
                break;
        }
    }*/
}
