package com.tech_sim.uiproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tech_sim.uiproject.R;
import com.tech_sim.uiproject.SwitchActivity;

public class Fragment1 extends Fragment implements View.OnClickListener{

    public static Fragment1 getInstance(){
        Fragment1 fragment1=new Fragment1();
        return fragment1;
    }
    private Button btn_open;
    private ImageView img_search;
    private TextView txt_tile;
    private RelativeLayout relativeLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        btn_open=(Button)view.findViewById(R.id.btton_open);
        img_search=getActivity().findViewById(R.id.imagesearch);
        img_search.setVisibility(View.INVISIBLE);
        txt_tile=getActivity().findViewById(R.id.tvTitle);
        txt_tile.setText("Fragment1");
        btn_open.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btton_open:
                switchOpenActivity();
                break;
        }
    }
    public void switchOpenActivity(){

        Intent intent=new Intent(getActivity(), SwitchActivity.class);
        startActivity(intent);

    }
}
