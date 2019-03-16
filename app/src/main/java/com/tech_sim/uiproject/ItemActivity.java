package com.tech_sim.uiproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

  String title="";
  private TextView txt_tile;
  Toolbar topToolBar;
  private ImageView image_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        Intent intent=getIntent();
        title=intent.getStringExtra("item");
        initXml();
        txt_tile.setText(title);
        image_back=(ImageView)findViewById(R.id.imageback);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void initXml(){
        txt_tile=(TextView)findViewById(R.id.tvTitle);
        topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation_menu_clinic, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home_bottom) {
         Intent intent=new Intent(ItemActivity.this,FullScreenActivity.class);
         startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
