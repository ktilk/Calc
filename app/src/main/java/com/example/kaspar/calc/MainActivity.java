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

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) { Log.d(TAG, "onCreate called"); }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        //savedInstanceState.putString();
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
        String subName = "com.example.kaspar.calc:id/button";
        Button btn = (Button) view;
        String idAsString = btn.getResources().getResourceName(btn.getId());
        String buttonSuffix = idAsString.substring(subName.length());
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "button pressed: " + buttonSuffix);
        }
        /*switch (view.getId()){
            case R.id.
        }*/
    }
}
