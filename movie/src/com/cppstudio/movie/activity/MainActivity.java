package com.cppstudio.movie.activity;

import com.cppstudio.movie.fragment.*;
import com.cppstudio.movie.widget.util.ActionBarTool;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;

public class MainActivity extends ActionBarActivity{
	private RadioButton radioFilm;
	private RadioButton radioCinema;
	private RadioButton radioComm;
	private RadioButton radioMe;
	private CheckBox checkbox;
	
	private android.support.v4.app.Fragment fragment;
	private android.support.v4.app.FragmentManager fManager;
	
	private ActionBarTool tool;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.bottom_tab);
	        
	        initUI();
	      
	        
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
	    
	    public void initUI(){
	    	tool=new ActionBarTool(this);
	    	 
	    	radioFilm=(RadioButton)findViewById(R.id.fragment_film);
	    	radioFilm.setOnClickListener(new switchFragment());
	    	radioCinema=(RadioButton)findViewById(R.id.fragment_cinema);
	    	radioCinema.setOnClickListener(new switchFragment());
	    	radioComm=(RadioButton)findViewById(R.id.fragment_community);
	    	radioComm.setOnClickListener(new switchFragment());
	    	radioMe=(RadioButton)findViewById(R.id.fragment_me);
	    	radioMe .setOnClickListener(new switchFragment());
	    	
	    	fragment = new FilmFragment();
	    	//fragment = new FilmFragment();
            tool.setActionBar(R.layout.film_actionbar);  
            radioFilm.setTextColor(getResources().getColor(R.color.black));  
	        
            fManager =getSupportFragmentManager();  
            
            if (fragment != null) {  
                fManager.beginTransaction()  
                        .replace(R.id.content, fragment).commit();  
            } else {  
                Log.e("MainActivity", "Error in creating fragment");  
            }  
            
            changeFilm();
           
	    }
	    
	    public void initBtn(){
	    	radioFilm.setTextColor(getResources().getColor(R.color.white));
	    	radioFilm.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.tab_test) ,null,null);
	    	
	    	radioCinema.setTextColor(getResources().getColor(R.color.white));
	    	radioCinema.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.tab_test) ,null,null);
	        
	    	radioComm.setTextColor(getResources().getColor(R.color.white));
	    	radioComm.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.tab_test) ,null,null);
	    
	    	radioMe.setTextColor(getResources().getColor(R.color.white));
	    	radioMe.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.tab_test) ,null,null);
	    
	    }
	    
	    public void changeFilm(){
	    	//LayoutInflater inflater=LayoutInflater.from(this);
	    	//View view=inflater.inflate(R.layout.film_actionbar,null);
	    	
	       View view=tool.getMyActionBar();
	       checkbox=(CheckBox)view.findViewById(R.id.actionbar_check);
	   	   checkbox.setChecked(true);
	    //   Log.v("T_T",""+checkbox.isChecked());
	    
	    	
	    	
	    checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {  
            
            @Override  
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {  
                if (isChecked) {  
                	 Log.v("@_@",""+isChecked); 
                	fragment = new FilmFragment();
                }else {  
                	Log.v("@_@",""+isChecked);  
                	fragment = new FilmFragment1();
                }  
                if (fragment != null) {  
	                fManager.beginTransaction()  
	                        .replace(R.id.content, fragment).commit();  
	            } else {  
	                Log.e("MainActivity", "Error in creating fragment");  
	            }  
            }  
        });  
	    	
	    }
	    
	    
	    class switchFragment implements OnClickListener{
            
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				initBtn();
				switch(view.getId()){
				case R.id.fragment_film:
					//fragment = new FilmFragment(); 
					fragment = new FilmFragment();
	                tool.setActionBar(R.layout.film_actionbar);  
	                radioFilm.setTextColor(getResources().getColor(R.color.black));  
	                changeFilm();
	                //btn_my.setCompoundDrawablesWithIntrinsicBounds(null,   
                   // getResources().getDrawable(R.drawable.my_indicator_s), null, null);  
	                break;
				
				case R.id.fragment_cinema:
					fragment = new CinemaFragment();  
	                tool.setActionBar(R.layout.cinema_actionbar);  
	            	radioCinema.setTextColor(getResources().getColor(R.color.black));
					break;
					
				case R.id.fragment_community:
					fragment = new DiscoveryFragment();  
	                tool.setActionBar(R.layout.community_actionbar);  
	                radioComm.setTextColor(getResources().getColor(R.color.black));
					break;
					
				case R.id.fragment_me:
					fragment = new MeFragment();  
	                tool.setActionBar(R.layout.me_actionbar);  
	                radioMe.setTextColor(getResources().getColor(R.color.black));
					break;
				}
				if (fragment != null) {  
	                fManager.beginTransaction()  
	                        .replace(R.id.content, fragment).commit();  
	            } else {  
	                Log.e("MainActivity", "Error in creating fragment");  
	            }  
			}
			
			
	    	
	    }
	    
}
