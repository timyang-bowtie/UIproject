package com.tech_sim.uiproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tech_sim.uiproject.R;

public class FragmentSwitchFirst extends Fragment {
    public static FragmentSwitchFirst getInstance()
    {
        FragmentSwitchFirst first=new FragmentSwitchFirst();
        return first;
    }
    private TextView text_close;
    private ImageView imge_back;
    private RelativeLayout relativeLayout;
    private TextView txt_label1,txt_label2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_one_layout, container, false);
        text_close=getActivity().findViewById(R.id.close);
        text_close.setVisibility(View.VISIBLE);
        imge_back=getActivity().findViewById(R.id.backarrow);
        imge_back.setVisibility(View.GONE);
        relativeLayout=(RelativeLayout)getActivity().findViewById(R.id.bottom_layout);
        txt_label1=view.findViewById(R.id.txt1);
        txt_label2=view.findViewById(R.id.txt2);
//        txt_label2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            public void onFocusChange(View v, boolean hasFocus) {
//
//              relativeLayout.setVisibility(View.GONE);
//            }
//        });


        return view;
    }

}
