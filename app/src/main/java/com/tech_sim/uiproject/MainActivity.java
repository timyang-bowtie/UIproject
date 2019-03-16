package com.tech_sim.uiproject;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tech_sim.uiproject.fragment.Fragment1;
import com.tech_sim.uiproject.fragment.Fragment3;
import com.tech_sim.uiproject.fragment.Fragment4;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    Toolbar toolbar;
    RelativeLayout f1_layout,f2_layout,f3_layout,f4_layout,f5_layout;
    private ImageView search;
    private TextView txt_tile;
    private NavigationView drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        drawerLayout=(NavigationView)findViewById(R.id.nav_view);
        initXml();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, Fragment1.getInstance()).addToBackStack("tag").commit();
    }
    public void initXml(){
        f1_layout=(RelativeLayout)findViewById(R.id.frgament1_layout);
        f2_layout=(RelativeLayout)findViewById(R.id.frgament2_layout);
        f3_layout=(RelativeLayout)findViewById(R.id.frgament3_layout);
        f4_layout=(RelativeLayout)findViewById(R.id.frgament4_layout);
        f5_layout=(RelativeLayout)findViewById(R.id.frgament5_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        txt_tile=(TextView)findViewById(R.id.tvTitle);
        txt_tile.setText("Fragment1");
        search=(ImageView)findViewById(R.id.imagesearch);
        search.setVisibility(View.INVISIBLE);
        f2_layout.setOnClickListener(this);
        f1_layout.setOnClickListener(this);
        f3_layout.setOnClickListener(this);
        f4_layout.setOnClickListener(this);
        f5_layout.setOnClickListener(this);
        setupToolbar();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();
    }
    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");

    }
    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.frgament2_layout:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                Intent intent1=new Intent(MainActivity.this,SwitchActivity.class);
                startActivity(intent1);
                break;
            case R.id.frgament3_layout:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, Fragment3.getInstance()).addToBackStack("tag").commit();
                break;
            case R.id.frgament1_layout:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.content, Fragment1.getInstance()).addToBackStack("tag").commit();
                break;
            case R.id.frgament4_layout:
                mDrawerLayout.closeDrawer(GravityCompat.START);

                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.content, Fragment4.getInstance()).addToBackStack("tag").commit();
                break;
            case R.id.frgament5_layout:
                mDrawerLayout.closeDrawer(GravityCompat.START);

                Intent intent=new Intent(MainActivity.this,SettingActivity.class);
                  startActivity(intent);
                break;
        }
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId())
//        {
//            case R.id.sort:
//                break;
//            case R.id.filter:
//                Intent intent=new Intent(MainActivity.this, FilterActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.send:
//                break;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.fragment4_menu, menu);
//        return true;
//    }
}
