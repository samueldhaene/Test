package be.test.sdh.test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_fr).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Locale looc = new Locale("FRENCH");
                Log.d("test", looc.toString());
                Locale.setDefault(looc);
                android.content.res.Configuration config = new android.content.res.Configuration();
                config.locale = looc;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                Log.d("test", "lang set to" + looc.getCountry().toString());

                restartactivity();
                return false;
            }
        });
        findViewById(R.id.btn_nl).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Locale looc = new Locale("DUTCH");
                Log.d("test",looc.toString());
                Locale.setDefault(looc);
                android.content.res.Configuration config = new android.content.res.Configuration();
                config.locale = looc;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                Log.d("test", "lang set to" + looc.getCountry().toString());

                restartactivity();
                return false;
            }
        });
        findViewById(R.id.btn_goToScreenTwo).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                getScreenTwo();
                return false;
            }
        });

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void restartactivity(){
        Intent i= getIntent();
        finish();
        startActivity(i);


    }
    private void getScreenTwo(){
        Intent i= new Intent(this, Scherm2.class);
        finish();
        startActivity(i);


    }


}
