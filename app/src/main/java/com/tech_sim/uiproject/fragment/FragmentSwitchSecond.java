package com.tech_sim.uiproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.tech_sim.uiproject.R;

public class FragmentSwitchSecond extends Fragment {

    public static FragmentSwitchSecond getInstance()
    {
        FragmentSwitchSecond second=new FragmentSwitchSecond();
        return second;
    }
    private TextView text_close;
    private ImageView imge_back,plus,image_f;
    private Spinner spinner;
    String array[]={"One","Two","Three","Four","Five"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_two_layout, container, false);
        text_close=getActivity().findViewById(R.id.close);
        text_close.setVisibility(View.GONE);
        imge_back=getActivity().findViewById(R.id.backarrow);
        imge_back.setVisibility(View.VISIBLE);
        plus=getActivity().findViewById(R.id.plusdraw);
        plus.setVisibility(View.GONE);
        image_f=getActivity().findViewById(R.id.fowardarrow);
        image_f.setVisibility(View.VISIBLE);
        spinner=view.findViewById(R.id.rol_type);
        imge_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.switch_content, FragmentSwitchFirst.getInstance()).addToBackStack("tag").commit();
            }
        });
        image_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.switch_content, FragmentSwitchThree.getInstance()).addToBackStack("tag").commit();
            }
        });


        return view;
    }
}
