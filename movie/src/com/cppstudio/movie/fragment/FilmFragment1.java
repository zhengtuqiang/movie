package com.cppstudio.movie.fragment;

import java.util.ArrayList;
import java.util.List;

import com.cppstudio.movie.activity.R;
import com.cppstudio.movie.adapter.GridViewAdapter;
import com.cppstudio.movie.model.GridViewItem;
import com.cppstudio.movie.widget.util.LineGridView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FilmFragment1 extends Fragment{
     private GridViewAdapter adapter;
     private LineGridView gridview;
     private List<GridViewItem> list;
	 @Override  
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        // TODO Auto-generated method stub  
	        super.onActivityCreated(savedInstanceState);  
	    }  
	  
	    @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) {  
	    	 View view=inflater.inflate(R.layout.fragment_film_1, container, false);
	    	 gridview=(LineGridView)view.findViewById(R.id.gridview);
	   
	    	 adapter=new GridViewAdapter(this.getActivity(),initData());
	    	 gridview.setAdapter(adapter);
	    	 return view; 
	    } 
	    
	    private List<GridViewItem> initData(){
	    	list=new ArrayList<GridViewItem>();
	    	for(int i=0;i<20;i++){
	    		GridViewItem item=new GridViewItem();
	    		item.setImage(R.drawable.splash);
	    		item.setScore("7.5");
	    		item.setTitle("»¶Ó­¹âÁÙ");
	    	    list.add(item);
	    	}
	    	 return list;
	    }
       
}
