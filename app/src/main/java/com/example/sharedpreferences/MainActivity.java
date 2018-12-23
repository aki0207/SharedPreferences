package com.example.sharedpreferences;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calendar cal;
    int current_year;
    String selected_year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] year_list = new String[12];
        for (int i = 0; i < 12; i++) {
            year_list[i] = String.valueOf(i + 1);
        }

        //年のセレクトボックス
        Spinner year_spinner = (Spinner) findViewById(R.id.year);
        ArrayAdapter year_adapter =
                new ArrayAdapter(this, android.R.layout.simple_spinner_item, year_list);



        selected_year = (String) year_spinner.getSelectedItem();
        cal = Calendar.getInstance();
        current_year = cal.get(Calendar.YEAR);

        cal.set(Calendar.YEAR,current_year);
        cal.set(Calendar.MONTH,Integer.parseInt(selected_year));
        int max_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        String[] month_list = new String[max_day];
        for (int i = 0; i < max_day; i++) {
            month_list[i] = String.valueOf(i + 1);
        }

        Spinner month_spinner = (Spinner)findViewById(R.id.month);
        ArrayAdapter month_adapter =
                new ArrayAdapter(this, android.R.layout.simple_spinner_item, month_list);







        

        //yearのスピナーのリスナー
        year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year_spinner.setAdapter(year_adapter);
        year_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // スピナー要素の文字列を取得

                selected_year = (String) parent.getSelectedItem();
                cal.set(Calendar.MONTH,Integer.parseInt(selected_year));
                int max_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

                String[] month_list = new String[max_day];
                for (int i = 0; i < max_day; i++) {
                    month_list[i] = String.valueOf(i + 1);
                }

                Spinner month_spinner = (Spinner)findViewById(R.id.month);
                ArrayAdapter month_adapter =
                        new ArrayAdapter(this, android.R.layout.simple_spinner_item, month_list);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

}