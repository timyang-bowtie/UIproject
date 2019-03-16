package com.tech_sim.uiproject.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.tech_sim.uiproject.R;
import com.tech_sim.uiproject.SearchResultActivity;

import java.util.Calendar;

public class Fragment3 extends Fragment {

    public static Fragment3 getInstance(){
        Fragment3 fragment3=new Fragment3();
        return fragment3;
    }
    Toolbar toolbar;
    private ImageView img_search;
    private TextView txt_title;
    private ImageView date1picker,date2picker;
    private TextView txt_date1,txt_date2;
    private int year;
    private int month;
    private int day;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_layout, container, false);
        img_search=getActivity().findViewById(R.id.imagesearch);
        img_search.setVisibility(View.VISIBLE);
        txt_title=getActivity().findViewById(R.id.tvTitle);
        txt_title.setText("Fragment3");
        date1picker=(ImageView)view.findViewById(R.id.date1);
        date2picker=(ImageView)view.findViewById(R.id.date2);
        txt_date1=view.findViewById(R.id.date1_txt);
        txt_date2=view.findViewById(R.id.date2_txt);

        date1picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog.OnDateSetListener myDataListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                        txt_date1.setText(String.valueOf(dayOfMonth)+" "+String.valueOf(month+1)+" "+String.valueOf(year));

                    }
                };
                DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(),myDataListener,year,month,day);
                datePickerDialog.setTitle("Choose Date");
//                datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                datePickerDialog.show();
            }
        });
        date2picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog.OnDateSetListener myDataListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                        txt_date2.setText(String.valueOf(dayOfMonth)+" "+String.valueOf(month+1)+" "+String.valueOf(year));

                    }
                };
                DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(),myDataListener,year,month,day);
                datePickerDialog.setTitle("Choose Date");
//                datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                datePickerDialog.show();
            }
        });
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchResultActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
