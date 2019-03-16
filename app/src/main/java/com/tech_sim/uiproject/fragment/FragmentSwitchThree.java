package com.tech_sim.uiproject.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.tech_sim.uiproject.R;

import java.util.Calendar;

public class FragmentSwitchThree extends Fragment  {

    public static FragmentSwitchThree getInstance()
    {
        FragmentSwitchThree three=new FragmentSwitchThree();
        return three;
    }
    private ImageView f_arrow,bak_arrow,plus_arrow;
    private ImageView imag_data,imag_time;
    private TextView txt_time,txt_date;
    private int MY_FRAGMENT_ID=1000;
    private static final int DATE_DIALOG_ID = 1;
    private int year;
    private int month;
    private int day;
    private String currentDate;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_three_layout, container, false);
        f_arrow=getActivity().findViewById(R.id.fowardarrow);
        f_arrow.setVisibility(View.GONE);
        plus_arrow=getActivity().findViewById(R.id.plusdraw);
        plus_arrow.setVisibility(View.VISIBLE);
        bak_arrow=getActivity().findViewById(R.id.backarrow);
        imag_data=view.findViewById(R.id.datapicker);
        imag_time=view.findViewById(R.id.timepicker);
        imag_data=view.findViewById(R.id.datapicker);
        txt_time=(TextView)view.findViewById(R.id.timer);
        txt_date=(TextView)view.findViewById(R.id.datepicker);
        bak_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.switch_content, FragmentSwitchSecond.getInstance()).addToBackStack("tag").commit();
            }
        });
        imag_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar myCalender = Calendar.getInstance();
                final int hour = myCalender.get(Calendar.HOUR_OF_DAY);
                int minute = myCalender.get(Calendar.MINUTE);


                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (view.isShown()) {
                            myCalender.set(Calendar.HOUR_OF_DAY, hourOfDay);
                            myCalender.set(Calendar.MINUTE, minute);

                            if(hour<10)
                            {
                                txt_time.setText("0"+hourOfDay+":"+minute);
                            }
                            else if(minute<10) {
                                txt_time.setText(hourOfDay+":"+"0"+minute);
                            }
                            else {
                                txt_time.setText(hourOfDay+":"+minute);
                            }


                        }
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_NoActionBar, myTimeListener, hour, minute, true);
                timePickerDialog.setTitle("Choose hour");
                timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                timePickerDialog.show();

            }
        });
        imag_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog.OnDateSetListener myDataListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                        txt_date.setText(String.valueOf(dayOfMonth)+" "+String.valueOf(month+1)+" "+String.valueOf(year));

                    }
                };
                DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(),myDataListener,year,month,day);
                datePickerDialog.setTitle("Choose Date");
//                datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                datePickerDialog.show();


            }
        });


        return view;
    }


}
