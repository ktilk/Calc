package com.example.kaspar.calc;

import android.widget.TextView;

/**
 * Created by Kaspar on 9.03.2016.
 */
public class CalcEngine {
    private static final String TAG = "CalcEngine";
    
    private String dispText = "0";
    private String op1 = "0";
    private String op2 = "";
    private String optr = "";


    public void changeOperator(String s) {
        optr = s;
        if (op2.equals("")){
            op1 = dispText;
        }
    }

    public void calculate() {
        switch (optr) {
            case "+":
                op1 = add();
                break;
            case "-":
                op1 = substract();
                break;
            case "*":
                op1 = multiply();
                break;
            case "/":
                op1 = divide();
                break;
        }
        dispText = op1;
        op2 = "";
        optr = "";
    }

    public void clear() {
        dispText = "0";
        op1 = "0";
        op2 = "";
        optr = "";
    }

    public void addComma() {
        if (optr.equals("")){
            if (!op1.contains(".")){
                op1 += ".";
                dispText = op1;
            }
        }else {
            if (!op2.contains(".")){
                op2 += ".";
                dispText = op2;
            }
        }
    }

    public void addNumber(String s) {
        if (optr.equals("")){ // kui operaatorit pole, siis sisestatakse esimest arvu
            if (op1.equals("0")){
                if (!s.equals("0")){
                    op1 = s;
                }
            }else {
                op1 += s;
            }
            dispText = op1;
        }else{ // kui operaator on olemas, siis sisestatakse teist arvu
            if (op2.equals("")){
                op2 = s;
            }else if (Double.parseDouble(op2)==0){
                if (!s.equals("0")){
                    op2 = s;
                }
            }else {
                op2 += s;
            }
            dispText = op2;
        }
    }

    public String getDisplayText() {
        if (op2.equals("")){ // kui teist arvu veel pole
            return dispText + optr;
        }else { //kui sisestatakse teist arvu
            return dispText;
        }
    }

    public String add() {
        return "" + (Double.parseDouble(op1) + Double.parseDouble(op2));
    }

    public String substract() {
        return "" + (Double.parseDouble(op1) - Double.parseDouble(op2));
    }
    public String multiply() {
        return "" + (Double.parseDouble(op1) * Double.parseDouble(op2));
    }
    public String divide() {
        if (Double.parseDouble(op2)==0){
            return "Error";
        }
        return "" + (Double.parseDouble(op1) / Double.parseDouble(op2));
    }
    // Getters and setters
    public void setDisp(String disp) {
        this.dispText = disp;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public void setOptr(String optr) {
        this.optr = optr;
    }

    public String getDisp() {
        return dispText;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

    public String getOptr() {
        return optr;
    }
}
