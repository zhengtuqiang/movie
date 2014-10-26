package com.cppstudio.movie.fragment;

import com.cppstudio.movie.activity.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FilmFragment extends Fragment{
     
	 @Override  
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        // TODO Auto-generated method stub  
	        super.onActivityCreated(savedInstanceState);  
	    }  
	  
	    @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) {  
	        return inflater.inflate(R.layout.fragment_film, container, false);  
	    }  
}
