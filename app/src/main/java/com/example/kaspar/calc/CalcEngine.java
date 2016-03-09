package com.example.kaspar.calc;

/**
 * Created by Kaspar on 9.03.2016.
 */
public class CalcEngine {
    private static final String TAG = "CalcEngine";

    private String displayText = "0";

    public void addInputToText(String input){
        displayText = displayText+input;
    }
    public void setOutput(String text){

    }
    public double add(double a, double b){
        return a+b;
    }
    public double substract(double a, double b){
        return a-b;
    }
    public double multiply(double a, double b){
        return a*b;
    }
    public double divide(double a, double b){
        return a/b;
    }

}
