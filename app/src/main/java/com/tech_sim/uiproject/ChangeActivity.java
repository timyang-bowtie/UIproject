package com.tech_sim.uiproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ChangeActivity extends AppCompatActivity {
    private ImageView image_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_activity);
        image_back=(ImageView)findViewById(R.id.imagefilter);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent=new Intent(ChangeActivity.this,SettingActivity.class);
                 startActivity(intent);
                 finish();
            }
        });
    }
}
