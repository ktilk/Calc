package com.example.kaspar.calc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private static final String STATE_DISP = "dispState";
    private static final String STATE_OP1 = "op1State";
    private static final String STATE_OP2 = "op2State";
    private static final String STATE_OPTR = "optrState";

    private CalcEngine calc = new CalcEngine();
    private TextView textViewOutput;
    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnComma;
    private Button btnClear;
    private Button btnEqual;

    private UOW uow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onCreate called");
        }

        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        textViewOutput = (TextView) findViewById(R.id.textViewOutput);

        // Võtan layoutist nupud
        btnZero = (Button) findViewById(R.id.button0);
        btnOne = (Button) findViewById(R.id.button1);
        btnTwo = (Button) findViewById(R.id.button2);
        btnThree = (Button) findViewById(R.id.button3);
        btnFour = (Button) findViewById(R.id.button4);
        btnFive = (Button) findViewById(R.id.button5);
        btnSix = (Button) findViewById(R.id.button6);
        btnSeven = (Button) findViewById(R.id.button7);
        btnEight = (Button) findViewById(R.id.button8);
        btnNine = (Button) findViewById(R.id.button9);
        btnPlus = (Button) findViewById(R.id.buttonAdd);
        btnMinus = (Button) findViewById(R.id.buttonSubstract);
        btnMultiply = (Button) findViewById(R.id.buttonMultiply);
        btnDivide = (Button) findViewById(R.id.buttonDivide);
        btnComma = (Button) findViewById(R.id.buttonComma);
        btnEqual = (Button) findViewById(R.id.buttonEquals);
        btnClear = (Button) findViewById(R.id.buttonClear);

        // Panen nuppudele onClickListener-id
        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnComma.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        if(savedInstanceState != null){
            if (BuildConfig.DEBUG) { Log.d(TAG, "Restoring state"); }
            calc.setDisp(savedInstanceState.getString(STATE_DISP));
            calc.setOp1(savedInstanceState.getString(STATE_OP1));
            calc.setOp2(savedInstanceState.getString(STATE_OP2));
            calc.setOptr(savedInstanceState.getString(STATE_OPTR));
        }
        drawDisplay();

        uow = new UOW(getApplicationContext());

        initListView();
    }

    private void initListView(){
        OperandsAdapter operandsAdapter = new OperandsAdapter(getApplicationContext(), , uow)
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(operandsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        if (BuildConfig.DEBUG) { Log.d(TAG, "onSaveInstanceState called"); }
        savedInstanceState.putString(STATE_DISP, calc.getDisp());
        savedInstanceState.putString(STATE_OP1, calc.getOp1());
        savedInstanceState.putString(STATE_OP2, calc.getOp2());
        savedInstanceState.putString(STATE_OPTR, calc.getOptr());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onStart called");
        }
    }// The activity is about to become visible.

    @Override
    protected void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onResume called");
        }
    }// The activity has become visible (it is now "resumed").   

    @Override
    protected void onPause() {
        super.onPause();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onPause called");
        }
        // Another activity is taking focus (this activity is about to be "paused").   
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onStop called");
        }
    }// The activity is no longer visible (it is now "stopped")    }   

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onDestroy called");
        }
    }// The activity is about to be destroyed.    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                calc.addNumber("0");
                drawDisplay();
                break;
            case R.id.button1:
                calc.addNumber("1");
                drawDisplay();
                break;
            case R.id.button2:
                calc.addNumber("2");
                drawDisplay();
                break;
            case R.id.button3:
                calc.addNumber("3");
                drawDisplay();
                break;
            case R.id.button4:
                calc.addNumber("4");
                drawDisplay();
                break;
            case R.id.button5:
                calc.addNumber("5");
                drawDisplay();
                break;
            case R.id.button6:
                calc.addNumber("6");
                drawDisplay();
                break;
            case R.id.button7:
                calc.addNumber("7");
                drawDisplay();
                break;
            case R.id.button8:
                calc.addNumber("8");
                drawDisplay();
                break;
            case R.id.button9:
                calc.addNumber("9");
                drawDisplay();
                break;
            case R.id.buttonAdd:
                calc.changeOperator("+");
                drawDisplay();
                break;
            case R.id.buttonSubstract:
                calc.changeOperator("-");
                drawDisplay();
                break;
            case R.id.buttonMultiply:
                calc.changeOperator("*");
                drawDisplay();
                break;
            case R.id.buttonDivide:
                calc.changeOperator("/");
                drawDisplay();
                break;
            case R.id.buttonEquals:
                calc.calculate();
                drawDisplay();
                break;
            case R.id.buttonClear:
                calc.clear();
                drawDisplay();
                break;
            case R.id.buttonComma:
                calc.addComma();
                drawDisplay();
                break;
        }
    }
    public void drawDisplay(){
        textViewOutput.setText(calc.getDisplayText());
    }
}
