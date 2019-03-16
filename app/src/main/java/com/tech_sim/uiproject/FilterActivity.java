package com.tech_sim.uiproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class FilterActivity extends AppCompatActivity {

    private ImageView img_back;
    private ImageView img_check;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    private boolean check=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        img_back=(ImageView)findViewById(R.id.imagefilter);
        img_check=(ImageView)findViewById(R.id.imagesearch);
        checkBox1=(CheckBox)findViewById(R.id.check1);
        checkBox2=(CheckBox)findViewById(R.id.check2);
        checkBox3=(CheckBox)findViewById(R.id.check3);
        checkBox4=(CheckBox)findViewById(R.id.check4);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        img_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check) {
                    checkBox1.setChecked(true);
                    checkBox2.setChecked(true);
                    checkBox3.setChecked(true);
                    checkBox4.setChecked(true);
                    check = false;
                } else {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    check=true;

                }
            }
        });
    }
}
