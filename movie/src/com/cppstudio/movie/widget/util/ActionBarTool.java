package com.cppstudio.movie.widget.util;

import com.cppstudio.movie.activity.R;


import android.app.Activity;
import android.app.ActionBar.LayoutParams;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

public class ActionBarTool {
   private ActionBarActivity activity;
   private ActionBar actionbar;
   public ActionBarTool(ActionBarActivity activity){
	   this.activity=activity;
   }
   
   public void setActionBar(int resource){
	   
	    actionbar=activity.getSupportActionBar();
        ActionBar.LayoutParams params=new ActionBar.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,Gravity.CENTER );
      // actionbar.setCustomView(LayoutInflater.from(this.getApplicationContext()).inflate(R.layout.login_actionbar, null),params); 
      // actionbar.setCustomView(LayoutInflater.from(this.getApplicationContext()).inflate(R.layout.film_actionbar, null),params); 
      // actionbar.setCustomView(LayoutInflater.from(this.getApplicationContext()).inflate(R.layout.cinema_actionbar, null),params);
       actionbar.setCustomView(LayoutInflater.from(activity.getApplicationContext()).inflate(resource, null),params);
       actionbar.setDisplayShowCustomEnabled(true);
       actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);  
       actionbar.setDisplayShowHomeEnabled(false);
       actionbar.setDisplayShowTitleEnabled(false);
   }
   
   public View getMyActionBar(){
	    
	   return  actionbar.getCustomView();
   }
   
   
}
