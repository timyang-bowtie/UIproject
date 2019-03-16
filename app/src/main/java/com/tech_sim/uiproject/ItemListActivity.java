package com.tech_sim.uiproject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.tech_sim.uiproject.R.layout.dialog_layout;

public class ItemListActivity extends AppCompatActivity implements View.OnClickListener
{

    Toolbar topToolBar;
    String list_name="";
    TextView txt_title;
    CardView card1,card2,card3,card4,card5,card6,card7;
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_item_layout);
        Intent intent=getIntent();
        list_name=intent.getStringExtra("name");
        initXml();
        txt_title.setText(list_name);
        imageView=(ImageView)findViewById(R.id.image_bak);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void initXml(){
        txt_title=(TextView)findViewById(R.id.tvTitle);
        topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        card1=findViewById(R.id.card1_btn);
        card2=findViewById(R.id.card2_btn);
        card3=findViewById(R.id.card3_btn);
        card4=findViewById(R.id.card4_btn);
        card5=findViewById(R.id.card5_btn);
        card6=findViewById(R.id.card6_btn);
        card7=findViewById(R.id.card7_btn);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.start)
        {

        }
        else
        {
            final Dialog dialog=new Dialog(this);
            dialog.setContentView(R.layout.dialog_layout);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.show();
            Button btn_yes=(Button)dialog.findViewById(R.id.btn_yes);
            Button btn_no=(Button)dialog.findViewById(R.id.btn_no);
            btn_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            btn_no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.card1_btn:
                goUserActivity();
                break;
            case R.id.card2_btn:
                goUserActivity();
                break;
            case R.id.card3_btn:
                goUserActivity();

                break;
            case R.id.card4_btn:
                goUserActivity();

                break;
            case R.id.card5_btn:
                break;
            case R.id.card6_btn:
                goUserActivity();

                break;
            case R.id.card7_btn:
                goUserActivity();

                break;
        }

    }

    public void goUserActivity(){
        Intent intent=new Intent(ItemListActivity.this,UserActivity.class);
        startActivity(intent);
    }
}
