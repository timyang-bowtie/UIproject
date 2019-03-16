package com.tech_sim.uiproject;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.tech_sim.uiproject.adapter.SearchAdapter;
import com.tech_sim.uiproject.model.SearchModel;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<SearchModel> searchModels;
    private ImageView image_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlist_layout);
        recyclerView=(RecyclerView)findViewById(R.id.serch_recyclerview);
        image_back=(ImageView)findViewById(R.id.imageview);
        SearchAdapter adapter=new SearchAdapter(this,getArrayData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public ArrayList<SearchModel> getArrayData(){
        searchModels=new ArrayList<>();
        for(int i=0;i<20;i++)
        {
            SearchModel searchModel=new SearchModel("Title1","Title2","Subtitle");
            searchModels.add(searchModel);
        }
        return searchModels;
    }
}
