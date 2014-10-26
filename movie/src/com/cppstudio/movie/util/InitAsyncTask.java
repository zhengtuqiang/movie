package com.cppstudio.movie.util;

import com.cppstudio.movie.activity.LoginActivity;
import com.cppstudio.movie.activity.MainActivity;
import com.cppstudio.movie.activity.R;
import com.cppstudio.movie.activity.WelcomeActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class InitAsyncTask extends AsyncTask<Void,Void,Integer>{
    private Context context;
    private Activity activity;
    private static final int MIN_TIME = 2000;
	
    public InitAsyncTask(Activity activity,Context context){
		super();
    	this.context=context;
		this.activity=activity;
	}
	
    @Override
	protected Integer doInBackground(Void... arg0) {
		// TODO Auto-generated method stub
    	long startTime = System.currentTimeMillis();
    	long loadingTime = System.currentTimeMillis() - startTime;
    	Log.v("loading",""+loadingTime);
        if (loadingTime < MIN_TIME) {
             try {
                 Thread.sleep(MIN_TIME-loadingTime);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
		return null;
	}
	
	  @Override  
	    protected void onPostExecute(Integer result) {  
		    Intent intent = new Intent();
	        intent.setClass(context, MainActivity.class);
	        activity.startActivity(intent);
	        activity.finish();
	        //实现淡入淡出效果,手机开启动画可用
	        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);  
	    }  

}
