package com.tech_sim.uiproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tech_sim.uiproject.ItemActivity;
import com.tech_sim.uiproject.R;
import com.tech_sim.uiproject.model.SearchModel;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private ArrayList<SearchModel> searchModels;
    private Context context;
    private LayoutInflater layoutInflater;

    public SearchAdapter(Context context,ArrayList<SearchModel> searchModels){
        this.context=context;
        this.searchModels=searchModels;
        this.layoutInflater=LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public SearchAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= (View) layoutInflater.inflate(R.layout.item_search_result, viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.MyViewHolder myViewHolder, int i) {
        final SearchModel searchModel=searchModels.get(i);
        myViewHolder.txt_title2.setText(searchModel.getTitle2());
        myViewHolder.txt_title1.setText(searchModel.getTitle1());
        myViewHolder.txt_subtitle.setText(searchModel.getSubtitle());
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ItemActivity.class);
                intent.putExtra("item",searchModel.getTitle1());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_title1,txt_title2,txt_subtitle;
        private CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_subtitle=itemView.findViewById(R.id.subtitle);
            txt_title1=itemView.findViewById(R.id.title1);
            txt_title2=itemView.findViewById(R.id.title2);
            cardView=itemView.findViewById(R.id.announced);
        }
    }
}
