package com.cppstudio.movie.activity;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        setContentView(R.layout.bottom_tab);
        customActionBar();
       
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void customActionBar(){
    	 
        ActionBar actionbar=this.getSupportActionBar();
        ActionBar.LayoutParams params=new ActionBar.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,Gravity.CENTER );
       // actionbar.setCustomView(LayoutInflater.from(this.getApplicationContext()).inflate(R.layout.login_actionbar, null),params); 
       // actionbar.setCustomView(LayoutInflater.from(this.getApplicationContext()).inflate(R.layout.film_actionbar, null),params); 
       // actionbar.setCustomView(LayoutInflater.from(this.getApplicationContext()).inflate(R.layout.cinema_actionbar, null),params);
        actionbar.setCustomView(LayoutInflater.from(this.getApplicationContext()).inflate(R.layout.community_actionbar, null),params);
        actionbar.setDisplayShowCustomEnabled(true);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);  
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setDisplayShowTitleEnabled(false);
    }
}