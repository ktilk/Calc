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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String STATE_CALC = "calcState";
    private static final String STATE_DISP = "dispState";
    private static final String STATE_OP1 = "op1State";
    private static final String STATE_OP2 = "op2State";
    private static final String STATE_OPTR = "optrState";

    private CalcEngine calc = new CalcEngine();
    private TextView textViewOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) { Log.d(TAG, "onCreate called"); }

        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        textViewOutput = (TextView) findViewById(R.id.textViewOutput);

        if(savedInstanceState != null){
            if (BuildConfig.DEBUG) { Log.d(TAG, "Restoring state"); }
            calc.setDisp(savedInstanceState.getString(STATE_DISP));
            calc.setCalcState(savedInstanceState.getString(STATE_CALC));
            calc.setOp1(savedInstanceState.getString(STATE_OP1));
            calc.setOp2(savedInstanceState.getString(STATE_OP2));
            calc.setOptr(savedInstanceState.getString(STATE_OPTR));
        }
        drawOutput();
       /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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
        savedInstanceState.putString(STATE_CALC, calc.getState());
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
        if (BuildConfig.DEBUG) { Log.d(TAG, "onStart called"); }
    }// The activity is about to become visible.
    @Override
    protected void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG) { Log.d(TAG, "onResume called"); }
    }// The activity has become visible (it is now "resumed").   
    @Override
    protected void onPause() {
        super.onPause();
        if (BuildConfig.DEBUG) { Log.d(TAG, "onPause called"); }
        // Another activity is taking focus (this activity is about to be "paused").   
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (BuildConfig.DEBUG) { Log.d(TAG, "onStop called"); }
    }// The activity is no longer visible (it is now "stopped")    }   
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) { Log.d(TAG, "onDestroy called"); }
    }// The activity is about to be destroyed.    }

    public void buttonClicked(View view) {
//        String subName = "com.example.kaspar.calc:id/button";
        Button btn = (Button) view;
//        String idAsString = btn.getResources().getResourceName(btn.getId());
//        String buttonSuffix = idAsString.substring(subName.length());
//        if (BuildConfig.DEBUG) {
//            Log.d(TAG, "button pressed: " + buttonSuffix);
//        }
        calc.handleInput(view.getId());
        drawOutput();
    }
    public void drawOutput(){
        textViewOutput.setText(calc.getDisp());
    }
}
