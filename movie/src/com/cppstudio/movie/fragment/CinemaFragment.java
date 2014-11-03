package com.cppstudio.movie.fragment;

import java.util.ArrayList;
import java.util.List;

import com.cppstudio.movie.activity.R;
import com.cppstudio.movie.adapter.CinemaListViewAdapter;
import com.cppstudio.movie.model.Cinema;
import com.cppstudio.movie.widget.util.CornerListView;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class CinemaFragment extends Fragment {
	
	private CornerListView listview;
	private CinemaListViewAdapter adapter;
	private List<Cinema> list;//adapter的数据
	private Cinema[] cinemas;//总的数据
	private static int index=0;//数组下标
	private int count ;//数组长度
	private boolean flag=false;//判断是否已addfootview
	private ImageView more;
	private View footView;
	private int MAX_NUM=5;
	private int lastIndex;
	private Handler handler=new Handler();;
	
	 @Override  
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        // TODO Auto-generated method stub  
	        super.onActivityCreated(savedInstanceState); 
	        
	        
	        more.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 handler.post(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							 load();
							// adapter.notifyDataSetChanged();
						}
						
					});
				}
	        	
	        });
	       
	    }  
	  
	    @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) {  
	    	View view=inflater.inflate(R.layout.fragment_cinema, container, false);
	        listview=(CornerListView)view.findViewById(R.id.list_often);
	        footView=LayoutInflater.from(getActivity()).inflate(R.layout.footview, null);
	        more=(ImageView)footView.findViewById(R.id.arrow_down);
	        
	        list=new ArrayList<Cinema>();
	        
	        cinemas=new Cinema[10];
	        for(int i=0;i<10;i++){
	        	Cinema cinema=new Cinema();
	        	cinema.setName("大地影院（湛江店）");
	        	cinema.setAddress("广东省湛江市霞山区XXX街道");
	        	cinemas[i]=cinema;
	        }
	        
	        count=cinemas.length;
	        Log.v("-_-!", ""+count);
	        
	        	if(count<=3){//不足或等于三个
	        		for(int j=0;j<count;j++){
		        		list.add(cinemas[index++]);
		        	 }
	        	    adapter=new CinemaListViewAdapter(this.getActivity(),list);
	        		index=0;
	        	}else{
	        		for(int j=0;j<3;j++){
		        		list.add(cinemas[index++]);
		        	 }
	        		 if(!flag){
	        	    	 adapter=new CinemaListViewAdapter(this.getActivity(),list);
	        	    	 listview.addFooterView(footView, null, false);
	        	    	 flag=true;
	        	      }
	        		adapter=new CinemaListViewAdapter(this.getActivity(),list);
	        	}
	        
	      listview.setAdapter(adapter);
	      return view;  
	    } 
	   
	    private void load(){
	    
	    	 if(count>3&&(count-index)>3){//超出三个，再判断一次循环后，是否还足三个
	        	   for(int j=0;j<3;j++){
	        		  list.add(cinemas[index++]);
	        		 
	        	    } 
	        	   adapter.notifyDataSetChanged();
	        	    
	        	  }else if((count-index)<=3){//循环后不超出三个
		        		for(int j=0;j<(count-index);j++){
			        		list.add(cinemas[index++]);
			        		
			        	}
		             adapter.notifyDataSetChanged();
		             listview.removeFooterView(footView);
		             flag=false;
		             index=0;
	        	  }
	     }
	    }
	  
	 
		
	       

