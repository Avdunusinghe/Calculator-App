package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_value;
    RadioButton btn_celcius;
    RadioButton btn_fahranheit;
    Button btn_calculate;
    TextView tv_displayAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value = findViewById(R.id.et_value);
        btn_celcius = findViewById(R.id.btn_celcius);
        btn_fahranheit = findViewById(R.id.btn_fahrenhite);
        btn_calculate = findViewById(R.id.btn_calc);
        tv_displayAnswer = findViewById(R.id.tv_displayAnswer);
    }


    @Override
    protected void onResume() {
        super.onResume();

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }


    private void calculateAnswer(){

        Calculations calculations = new Calculations();

        String temp_value = et_value.getText().toString();

        if(TextUtils.isEmpty(temp_value)){

            Toast.makeText(this, "Please enter atemperature value", Toast.LENGTH_LONG).show();

            temp_value = "0.0";

            tv_displayAnswer.setText(temp_value);
        }else {

            Float temp = Float.parseFloat(temp_value);

            if(btn_celcius.isChecked()){

                temp = calculations.convertCelciusToFahrenheit((temp));

            }else if (btn_fahranheit.isChecked()){

                temp = calculations.convertFahrenheitToCelcius((temp));

            }
            else {
                Toast.makeText(this, "Please please select redio button", Toast.LENGTH_LONG).show();
                temp = 0.0f;
            }
            tv_displayAnswer.setText(new Float(temp).toString());
        }
    }
}