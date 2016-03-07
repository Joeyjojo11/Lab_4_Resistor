package com.example.jdolan.lab_4_resistors;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {



    String temp_Resistance;     // Used to pull the 3 band strings together
    String Display_Resistance;  // The final displayed Resistance Value
    String Display_Range;       // The final displayed Range Values
    String band_1 = "0";        // Used to get the First Band Value
    String band_2 = "0";        // Used to get the Second Band Value
    String band_3 = "";         // Used to get the Third Band Value

    //int ValuePastOut = 0;
    double Resistance_Value=0;
    double temp_Resistance2 = 0; // Used for doing Calculations
    double Resistance_Lower_Limit=0;
    double Resistance_Upper_Limit=0;
    float Tolerance=0;

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;


    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemstoBandSpinners();

        initializeTextBand1();
        initializeTextBand2();
        initializeTextBand3();
        initializeTextBand4();


    }


    public void initializeTextBand1(){
        spinner = (Spinner) findViewById(R.id.Band_1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3)
            {
                // Get the item selected in the Spinner
                String itemSelectedInSpinner1 = parent.getItemAtPosition(pos).toString();

                // Check Which band colour is selected
                checkWhichhColorIsSlected1(itemSelectedInSpinner1);

                //Update the resistance reading and display
                Updated();

            }
            public void onNothingSelected(AdapterView<?> arg0)
            {
                // TODO maybe add something here later
            }
        });
    }

    public void checkWhichhColorIsSlected1(String colour1) {


        if (colour1.equals("Black")) {

            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.black);
            band_1 = "0";

        }

        else if (colour1.equals("Brown")){

            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.brown);
            band_1 = "1";
        }

        else if (colour1.equals("Red")){
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.red);
            band_1 = "2";
        }

        else if (colour1.equals("Orange")){
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.orange);
            band_1 = "3";

        }

        else if (colour1.equals("Yellow")){
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.yellow);
            band_1 = "4";

        }

        else if (colour1.equals("Green")){
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.green);
            band_1 = "5";

        }

        else if (colour1.equals("Blue")){
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.blue);
            band_1 = "6";

        }

        else if (colour1.equals("Violet")){
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.violet);
            band_1 = "7";

        }

        else if (colour1.equals("Grey")){
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.grey);
            band_1 = "8";

        }

        else if (colour1.equals("White")){
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setBackgroundResource(R.color.white);
            band_1 = "9";

        }


    }

    public void initializeTextBand2(){
        spinner = (Spinner) findViewById(R.id.Band_2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3)
            {
                // Get the item selected in the Spinner
                String itemSelectedInSpinner2 = parent.getItemAtPosition(pos).toString();

                // Check Which band colour is selected
                checkWhichhColorIsSlected2(itemSelectedInSpinner2);

                //Update the resistance reading and display
                Updated();

            }
            public void onNothingSelected(AdapterView<?> arg0)
            {
                // TODO maybe add something here later
            }
        });
    }

    public void checkWhichhColorIsSlected2(String colour2) {


        if (colour2.equals("Black")) {

            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.black);
            band_2 = "0";

        }

        else if (colour2.equals("Brown")){

            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.brown);
            band_2 = "1";
        }

        else if (colour2.equals("Red")){
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.red);
            band_2 = "2";

        }

        else if (colour2.equals("Orange")){
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.orange);
            band_2 = "3";

        }

        else if (colour2.equals("Yellow")){
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.yellow);
            band_2 = "4";

        }

        else if (colour2.equals("Green")){
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.green);
            band_2 = "5";

        }

        else if (colour2.equals("Blue")){
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.blue);
            band_2 = "6";

        }

        else if (colour2.equals("Violet")){
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.violet);
            band_2 = "7";

        }

        else if (colour2.equals("Grey")){
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.grey);
            band_2 = "8";

        }

        else if (colour2.equals("White")){
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setBackgroundResource(R.color.white);
            band_2 = "9";

        }


    }

    public void initializeTextBand3(){
        spinner = (Spinner) findViewById(R.id.Band_3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3)
            {
                // Get the item selected in the Spinner
                String itemSelectedInSpinner3 = parent.getItemAtPosition(pos).toString();

                // Check Which band colour is selected
                checkWhichhColorIsSlected3(itemSelectedInSpinner3);

                //Update the resistance reading and display
                Updated();

            }
            public void onNothingSelected(AdapterView<?> arg0)
            {
                // TODO maybe add something here later
            }
        });
    }

    public void checkWhichhColorIsSlected3(String colour3) {


        if (colour3.equals("Black")) {

            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.black);
            band_3 = "";

        }

        else if (colour3.equals("Brown")){

            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.brown);
            band_3 = "0";

        }

        else if (colour3.equals("Red")){
            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.red);
            band_3 = "00";
            //k_1 = "K";

        }

        else if (colour3.equals("Orange")){
            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.orange);
            band_3 = "000";

        }

        else if (colour3.equals("Yellow")){
            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.yellow);
            band_3 = "0000";

        }

        else if (colour3.equals("Green")){
            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.green);
            band_3 = "00000";

        }

        else if (colour3.equals("Blue")){
            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.blue);
            band_3 = "000000";

        }

        else if (colour3.equals("Violet")){
            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.violet);
            band_3 = "0000000";

        }

        else if (colour3.equals("Grey")){
            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.grey);
            band_3 = "00000000";

        }

        else if (colour3.equals("White")){
            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setBackgroundResource(R.color.white);
            band_3 = "000000000";

        }


    }


    public void initializeTextBand4(){
        spinner = (Spinner) findViewById(R.id.Band_4);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3)
            {
                // Get the item selected in the Spinner
                String itemSelectedInSpinner4 = parent.getItemAtPosition(pos).toString();

                // Check Which band colour is selected
                checkWhichhColorIsSlected4(itemSelectedInSpinner4);

                //Update the resistance reading and display
                Updated();


            }
            public void onNothingSelected(AdapterView<?> arg0)
            {
                // TODO maybe add something here later
            }
        });
    }

    public void checkWhichhColorIsSlected4(String colour4) {


        if (colour4.equals("Brown")) {

            TextView tv = (TextView) findViewById(R.id.textView5);
            tv.setBackgroundResource(R.color.brown);
            Tolerance = 1;

        }

        else if (colour4.equals("Red")){

            TextView tv = (TextView) findViewById(R.id.textView5);
            tv.setBackgroundResource(R.color.red);
            Tolerance = 2;

        }

        else if (colour4.equals("Gold")){
            TextView tv = (TextView) findViewById(R.id.textView5);
            tv.setBackgroundResource(R.color.gold);
            Tolerance = 5;

        }

        else if (colour4.equals("Silver")){
            TextView tv = (TextView) findViewById(R.id.textView5);
            tv.setBackgroundResource(R.color.silver);
            Tolerance = 10;

        }

    }


    public void addItemstoBandSpinners(){

        //Add Items (Colours)  to Spinner 1 (For the First Band)
        spinner1 = (Spinner) findViewById(R.id.Band_1);
        ArrayAdapter<CharSequence> spinner1Adapter =
                ArrayAdapter.createFromResource(this, R.array.Resistor_array, android.R.layout.simple_spinner_item);
        spinner1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinner1Adapter);

        //Add Items (Colours) to Spinner 1 (For the Second Band)
        spinner2 = (Spinner) findViewById(R.id.Band_2);
        ArrayAdapter<CharSequence> spinner2Adapter =
                ArrayAdapter.createFromResource(this, R.array.Resistor_array, android.R.layout.simple_spinner_item);
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinner2Adapter);

        //Add Items (Colours)  to Spinner 1 (For the Third Band)
        spinner3 = (Spinner) findViewById(R.id.Band_3);
        ArrayAdapter<CharSequence> spinner3Adapter =
                ArrayAdapter.createFromResource(this, R.array.Resistor_array, android.R.layout.simple_spinner_item);
        spinner3Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(spinner3Adapter);

        //Add Items (Colours)  to Spinner 1 (For the Forth Band)
        spinner4 = (Spinner) findViewById(R.id.Band_4);
        ArrayAdapter<CharSequence> spinner4Adapter =
                ArrayAdapter.createFromResource(this, R.array.tolerance_array, android.R.layout.simple_spinner_item);
        spinner4Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(spinner4Adapter);





    }

    public void Updated() { // This is called everytime a Spinner is changed to update the Displayed Values


        //Join the strings associated with Bands 1,2 and 3
        temp_Resistance = band_1.concat(band_2).concat(band_3);
        //Convert it to a Double to perform the Claculations
        temp_Resistance2 = Double.parseDouble(temp_Resistance);
        //Move around the decimal point so the Resistance can be displayed in KΩ or MΩ
        if (temp_Resistance2 >= 1000 && temp_Resistance2 <= 999999){

            Resistance_Value = temp_Resistance2/1000;
            Calc();
            Display_Resistance = (String.valueOf(Resistance_Value).concat(" KΩ"));
            Display_Range = (String.valueOf(Resistance_Lower_Limit).concat(" ~ ")
                    .concat(String.valueOf(Resistance_Upper_Limit)).concat(" KΩ"));




        }

        else if (temp_Resistance2 >= 1000000){

            Resistance_Value = temp_Resistance2/1000000;
            Calc();
            Display_Resistance = (String.valueOf(Resistance_Value).concat(" MΩ"));
            Display_Range = (String.valueOf(Resistance_Lower_Limit).concat(" ~ ")
                    .concat(String.valueOf(Resistance_Upper_Limit)).concat(" MΩ"));
        }

        else {
            Resistance_Value = temp_Resistance2;
            Calc();
            Display_Resistance = (String.valueOf(Resistance_Value).concat(" Ω"));
            Display_Range = (String.valueOf(Resistance_Lower_Limit).concat(" ~ ")
                    .concat(String.valueOf(Resistance_Upper_Limit)).concat(" Ω"));
        }

        //Display the Resistor Resistance
        TextView tv = (TextView) findViewById(R.id.textView8);
        tv.setText(Display_Resistance);

        //Display the Upper and Lower Limits
        TextView tv1 = (TextView) findViewById(R.id.textView10);
        tv1.setText(Display_Range);

    }

    public void Calc() {
        //String.format(Locale.CANADA, "%.2f", Resistance_Lower_Limit);

        //NumberFormat nf = new DecimalFormat("##");
        Resistance_Lower_Limit = ( Resistance_Value - ((Resistance_Value/100)*Tolerance));
        //convert the Lower Limit to a String limiting it to 2 Decamil places
        String str = String.format("%1.2f", Resistance_Lower_Limit);
        //convert it Back to a Double
        Resistance_Lower_Limit = Double.valueOf(str);

        Resistance_Upper_Limit = (Resistance_Value + ((Resistance_Value/100)*Tolerance));
        //convert the Upper Limit to a String limiting it to 2 Decamil places
        String str1 = String.format("%1.2f", Resistance_Upper_Limit );
        //convert it Back to a Double
        Resistance_Upper_Limit = Double.valueOf(str1);




    }


}

