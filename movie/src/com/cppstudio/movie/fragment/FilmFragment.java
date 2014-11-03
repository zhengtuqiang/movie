package com.cppstudio.movie.fragment;

import com.cppstudio.movie.activity.R;
import com.cppstudio.movie.adapter.ImageAdapter;
import com.cppstudio.movie.widget.util.ActionBarTool;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.Toast;

public class FilmFragment extends Fragment implements OnItemSelectedListener,OnItemClickListener{
     private ImageAdapter adapter;
     private Gallery mGallery;
	 
     private int showingIndex = -1;   
     private int toShowIndex = 0;  
     
     
     
     @Override  
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        // TODO Auto-generated method stub  
	        super.onActivityCreated(savedInstanceState);  
	       
	 }  
	  
	    @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) {  
	       
	    	View view=inflater.inflate(R.layout.fragment_film, container, false);
	       mGallery=(Gallery)view.findViewById(R.id.film_gallery);
	       adapter=new ImageAdapter(this.getActivity());
	       mGallery.setAdapter(adapter);
	       mGallery.setSpacing(5);
	       mGallery.setSelection(adapter.getCount()/2);
	       mGallery.setOnItemSelectedListener(this);
	       mGallery.setOnItemClickListener(this);
	       return view;  
	    }

		@Override
		public void onItemSelected(AdapterView<?> arg0, View view, int position,
				long arg3) {
			// TODO Auto-generated method stub
			//if(position>6)
		  // adapter.setSelectItem(position);
	      //  Log.v("no",""+position%6);//position%6获得真实的position
		     
			  toShowIndex=position;
			//adapter.setSelectItem(position);
			
			final Handler handler=new Handler(){
				@Override
				public void handleMessage(Message msg){
					if(showingIndex!=toShowIndex){
						showingIndex=toShowIndex;
						adapter.setSelectItem(toShowIndex);
					}
				}
			};
			
			Thread checkChange=new Thread(){
				@Override
				public void run(){
					int myIndex=toShowIndex;
					try{
						sleep(100);
						if(myIndex==toShowIndex){
							handler.sendEmptyMessage(0);
						}
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			};
		      checkChange.start();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int position,
				long arg3) {
			// TODO Auto-generated method stub
			Log.v("VIEW",""+position%6);
		}

		
}
