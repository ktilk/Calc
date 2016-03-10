package com.example.kaspar.calc;

/**
 * Created by Kaspar on 9.03.2016.
 */
public class CalcEngine {
    private static final String TAG = "CalcEngine";

    private String calcState = "";
    private String dispText = "";
    private String op1 = "";
    private String op2 = "";
    private String optr = "";

    public String getOptr(){
        return optr;
    }
    public void setOptr(String s) {
        optr = s;
    }
    public String getOp2(){
        return op2;
    }
    public void setOp2(String s) {
        op2 = s;
    }
    public String getOp1(){
        return op1;
    }
    public void setOp1(String s) {
        op1 = s;
    }
    public String getState(){
        return calcState;
    }
    public void setCalcState(String s) {
        calcState = s;
    }
    public String getDisp() {
        return dispText;
    }
    public void setDisp(String disp) {
        dispText = disp;
    }

    public void handleInput(int s) {
        switch (s) {
            case R.id.button0:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "0";
                dispText = calcState;
                break;
            case R.id.button1:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "1";
                dispText = calcState;
                break;
            case R.id.button2:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "2";
                dispText = calcState;
                break;
            case R.id.button3:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "3";
                dispText = calcState;
                break;
            case R.id.button4:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "4";
                dispText = calcState;
                break;
            case R.id.button5:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "5";
                dispText = calcState;
                break;
            case R.id.button6:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "6";
                dispText = calcState;
                break;
            case R.id.button7:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "7";
                dispText = calcState;
                break;
            case R.id.button8:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "8";
                dispText = calcState;
                break;
            case R.id.button9:
                if (!op2.isEmpty()) {
                    op2 = "";
                    dispText = "";
                }
                calcState += "9";
                dispText = calcState;
                break;
            case R.id.buttonAdd:
                optr = "+";
                if (op1.isEmpty()) {
                    op1 = dispText;
                    dispText="";
                    calcState="";
                } else if (!op2.isEmpty()) {
                    op2 = "";
                    dispText="";
                    calcState="";
                } else {
                    op2 = calcState;
                    dispText="";
                    op1 = add(op1, op2);
                    dispText=op1;
                }
                break;
            case R.id.buttonSubstract:
                optr = "-";
                if (op1.isEmpty()) {
                    op1 = dispText;
                    dispText="";
                    calcState="";
                } else if (!op2.isEmpty()) {
                    op2 = "";
                    dispText="";
                    calcState="";
                } else {
                    op2 = calcState;
                    dispText="";
                    op1 = substract(op1, op2);
                    dispText=op1;
                }
                break;
            case R.id.buttonMultiply:
                optr = "*";
                if (op1.isEmpty()) {
                    op1 = dispText;
                    dispText="";
                    calcState="";
                } else if (!op2.isEmpty()) {
                    op2 = "";
                    dispText="";
                    calcState="";
                } else {
                    op2 = calcState;
                    dispText="";
                    op1 = multiply(op1, op2);
                    dispText=op1;
                }
                break;
            case R.id.buttonDivide:
                optr = "/";
                if (op1.isEmpty()) {
                    op1 = dispText;
                    dispText="";
                    calcState="";
                } else if (!op2.isEmpty()) {
                    op2 = "";
                    dispText="";
                    calcState="";
                } else {
                    op2 = calcState;
                    dispText="";
                    op1 = divide(op1, op2);
                    dispText=op1;
                }
                break;
            case R.id.buttonComma:
                if (!calcState.contains(".")){
                    if (!op2.isEmpty()) {
                        op2 = "";
                        dispText = "";
                    }
                    calcState += ".";
                    dispText = calcState;
                    break;
                }
                break;
            case R.id.buttonClear:
                op1 = "";
                op2 = "";
                calcState = "";
                dispText = "";
                break;
            case R.id.buttonEquals:
                if(!optr.equals(null)){
                    if(!op2.isEmpty()){
                        if(optr.equals("+")){
                            dispText="";
                            op1 = add(op1, op2);
                            dispText=op1;
                        }
                        else if(optr.equals("-")){
                            dispText="";
							op1 = substract(op1, op2);
                            dispText=op1;
                        }
                        else if(optr.equals("*")){
                            dispText="";
							op1 = multiply(op1, op2);
                            dispText=op1;
                        }
                        else if(optr.equals("/")){
                            dispText="";
							op1 = divide(op1, op2);
                            dispText=op1;
                        }
                    }
                    else{
                        operation();
                    }
                }
                break;
        }
    }
    public void operation(){
        if(optr.equals("+")){
            op2 = dispText;
            dispText="";
            op1 = add(op1, op2);
            dispText=op1;
        }
        else if(optr.equals("-")){
            op2 = dispText;
            dispText="";
            op1 = substract(op1, op2);
            dispText=op1;
        }
        else if(optr.equals("*")){
            op2 = dispText;
            dispText="";
            op1 = multiply(op1, op2);
            dispText=op1;
        }
        else if(optr.equals("/")){
            op2 = dispText;
            dispText="";
            op1 = divide(op1, op2);
            dispText=op1;
        }
    }


    public void addToState(String s) {
        calcState += s;
    }

/*    public void calculate(String s) {
        String[] operands = new String[2];
        if (s.contains("+")) {
            operands = s.split("\\+");
            calcState = add(Double.parseDouble(operands[0]), Double.parseDouble(operands[1]));
        }
        if (s.contains("-")) {
            operands = s.split("-");
            calcState = substract(Double.parseDouble(operands[0]), Double.parseDouble(operands[1]));
        }
        if (s.contains("*")) {
            operands = s.split("\\*");
            calcState = multiply(Double.parseDouble(operands[0]), Double.parseDouble(operands[1]));
        }
        if (s.contains("/")) {
            operands = s.split("/");
            if (Double.parseDouble(operands[1]) != 0) {
            }
            calcState = divide(Double.parseDouble(operands[0]), Double.parseDouble(operands[1]));
        }
    }*/

    public String add(String a, String b) {
        return String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
    }

    public String substract(String a, String b) {
        return String.valueOf(Double.parseDouble(a) - Double.parseDouble(b));
    }

    public String multiply(String a, String b) {
        return String.valueOf(Double.parseDouble(a) * Double.parseDouble(b));
    }

    public String divide(String a, String b) {
        return String.valueOf(Double.parseDouble(a) / Double.parseDouble(b));
    }

}
