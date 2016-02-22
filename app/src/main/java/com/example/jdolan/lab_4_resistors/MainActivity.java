package com.example.jdolan.lab_4_resistors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String temp_Resistance;
    int Resistance_Value=0;
    int Resistance_Lower_Limit=0;
    int Resistance_Upper_Limit=0;


    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.Band_1);
        adapter = ArrayAdapter.createFromResource(this, R.array.Resistor_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner = (Spinner) findViewById(R.id.Band_2);
        adapter = ArrayAdapter.createFromResource(this, R.array.Resistor_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();

               temp_Resistance = Integer.toString(position-1);
                TextView tv = (TextView) findViewById(R.id.textView2);
                tv.setText(temp_Resistance);
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
