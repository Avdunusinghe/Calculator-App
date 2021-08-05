package com.example.calculator_app;

public class Claculations {

    protected float convertCelciusToFahrenheit(Float value) {
        Float ans = (value - 32) * 5/9;
        return ans;
    }
    protected float convertFahrenheitToCelcius(Float value) {
        Float ans = (value * 9/5) + 32;
        return ans;
    }
}
