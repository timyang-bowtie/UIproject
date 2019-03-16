package com.tech_sim.uiproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FullScreenActivity extends AppCompatActivity {

    private TextView back;
    private ImageView img_close;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen_activity);

        back=(TextView) findViewById(R.id.close);
        img_close=(ImageView)findViewById(R.id.plusdraw);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FullScreenActivity.this,ItemActivity.class);
                startActivity(intent);
                finish();
            }
        });
        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FullScreenActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
