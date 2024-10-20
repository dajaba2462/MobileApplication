package com.example.project6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer Chrono;
    RadioButton rdoDate, rdoTime;
    RadioGroup RG;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear,selectMonth, selectDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chrono = (Chronometer) findViewById(R.id.Chronometer1);
        rdoDate = (RadioButton)findViewById(R.id.rdoDate    );
        rdoTime = (RadioButton)findViewById(R.id.rdoTime);

        dPicker = (DatePicker) findViewById(R.id.dPicker);
        tPicker = (TimePicker) findViewById(R.id.Timepicker1);

        tvYear = (TextView) findViewById(R.id.Year);
        tvMonth = (TextView) findViewById(R.id.Month);
        tvDay = (TextView) findViewById(R.id.Day);
        tvHour = (TextView) findViewById(R.id.Hour);
        tvMinute = (TextView) findViewById(R.id.Minute);


        rdoTime.setVisibility(View.INVISIBLE);
        rdoDate.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);


        rdoDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dPicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);


            }
        });


        Chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chrono.setBase(SystemClock.elapsedRealtime());
                Chrono.start();
                Chrono.setTextColor(Color.RED);
                rdoDate.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);

            }
        });

        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Chrono.stop();
                Chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(1 + dPicker.getMonth()));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
                rdoDate.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
                return false;


            }
        });


    }
}