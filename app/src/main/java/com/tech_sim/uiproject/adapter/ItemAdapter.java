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
import com.tech_sim.uiproject.ItemListActivity;
import com.tech_sim.uiproject.R;
import com.tech_sim.uiproject.model.ItemModel;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<ItemModel> itemModels;
    private Context context;
    private LayoutInflater layoutInflater;
    public ItemAdapter(Context context,ArrayList<ItemModel> itemModels)
    {
        this.context=context;
        this.itemModels=itemModels;
        this.layoutInflater=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=layoutInflater.inflate(R.layout.item_list_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder viewHolder, int i) {

        final ItemModel itemModel=itemModels.get(i);
        viewHolder.list.setText(itemModel.getItemlist());
        viewHolder.sublist.setText(itemModel.getSubtitle());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ItemListActivity.class);
                intent.putExtra("name",itemModel.getItemlist());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView list,sublist;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            list=itemView.findViewById(R.id.title1);
            sublist=itemView.findViewById(R.id.subtitle);
            cardView=itemView.findViewById(R.id.announced);
        }
    }
}
