package com.cppstudio.movie.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cppstudio.movie.activity.R;
import com.cppstudio.movie.widget.util.CornerListView;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class MeFragment extends Fragment{
       
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        // TODO Auto-generated method stub  
	        super.onActivityCreated(savedInstanceState);  
	    }  
	  
	    @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) { 
	    	//View view=inflater.inflate(R.layout.fragment_me_2, null);
	    	View view=inflater.inflate(R.layout.fragment_me_2, null);
	   
	    	return view;  
	    } 
	    
	
	   
}
