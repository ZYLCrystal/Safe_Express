package com.example.crystal.contact.activity;

/**
 * Created by Claudia on 2018/1/26.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.crystal.contact.R;


public class PointsMall extends AppCompatActivity {
    public Button returntome;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pointsmall);
/*        returntome=(Button)findViewById(R.id.return1);

        returntome.setOnClickListener(this);*/
    }
/*    @Override
    public void onClick(View view){
        int v =view.getId();
        switch (v){
            case R.id.return1:
                Intent intent =new Intent(PointsMall.this,Me.class);
                startActivity(intent);
                break;
        }
    }*/
}