package com.cppstudio.movie.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cppstudio.movie.activity.R;

public class CommunityFragment extends Fragment{
	 @Override  
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        // TODO Auto-generated method stub  
	        super.onActivityCreated(savedInstanceState);  
	    }  
	  
	    @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) {  
	        return inflater.inflate(R.layout.fragment_community, container, false);  
	    } 
}
