package com.tech_sim.uiproject;

import android.content.Intent;
import android.icu.util.ICUUncheckedIOException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_sim.uiproject.fragment.Fragment1;
import com.tech_sim.uiproject.fragment.FragmentSwitchFirst;
import com.tech_sim.uiproject.fragment.FragmentSwitchSecond;

public class SwitchActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_close;
    private ImageView image_foward,image_back,plus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        initXml();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.switch_content, FragmentSwitchFirst.getInstance()).addToBackStack("tag").commit();
    }

    public void initXml()
    {
        txt_close=(TextView)findViewById(R.id.close);
        txt_close.setVisibility(View.VISIBLE);
        image_back=(ImageView)findViewById(R.id.backarrow);
        image_back.setVisibility(View.GONE);
        image_foward=(ImageView)findViewById(R.id.fowardarrow);
        image_foward.setVisibility(View.VISIBLE);
        plus=(ImageView)findViewById(R.id.plusdraw);
        plus.setVisibility(View.GONE);
        plus.setOnClickListener(this);
        txt_close.setOnClickListener(this);
        image_foward.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.close:
                backActivity();
                break;
            case R.id.fowardarrow:
                forwardActivity();
                break;
            case R.id.plusdraw:
                closeActivity();
                break;
        }
    }
    public void backActivity(){
        Intent intent=new Intent(SwitchActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void forwardActivity(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.switch_content, FragmentSwitchSecond.getInstance()).addToBackStack("tag").commit();
    }
    public void closeActivity(){
        Intent intent1=new Intent(SwitchActivity.this,MainActivity.class);
        startActivity(intent1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
