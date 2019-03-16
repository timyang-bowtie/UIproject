package com.tech_sim.uiproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.tech_sim.uiproject.FilterActivity;
import com.tech_sim.uiproject.R;
import com.tech_sim.uiproject.adapter.ItemAdapter;
import com.tech_sim.uiproject.model.ItemModel;

import java.util.ArrayList;

public class Fragment4 extends Fragment {
    public static Fragment4 getInstance()
    {
        Fragment4 fragment4=new Fragment4();
        return fragment4;
    }
    private TextView txt_title;
    private RecyclerView recyclerView;
    private ArrayList<ItemModel> itemModels;
    private ImageView imageView;
    private Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4_layout, container, false);
        setHasOptionsMenu(true);
        txt_title=getActivity().findViewById(R.id.tvTitle);
        txt_title.setText("Fragment4");
        imageView=getActivity().findViewById(R.id.imagesearch);
        imageView.setVisibility(View.GONE);
        recyclerView=view.findViewById(R.id.item_recyler);
        ItemAdapter itemAdapter=new ItemAdapter(getActivity(),getItems());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(itemAdapter);
        return view;
    }


    public ArrayList<ItemModel> getItems()
    {
        itemModels=new ArrayList<>();
        for(int i=0;i<20;i++)
        {
            ItemModel itemModel=new ItemModel("ListItem"+i,"Subtitle");
            itemModels.add(itemModel);
        }
        return itemModels;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment4_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.sort:
                break;
            case R.id.filter:
                Intent intent=new Intent(getActivity(), FilterActivity.class);
                startActivity(intent);
                break;
            case R.id.send:
                break;
            default:

        }
        return super.onOptionsItemSelected(item);
    }

}
