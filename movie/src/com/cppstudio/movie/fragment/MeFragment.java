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
       //   private CornerListView midListview;
       //   private CornerListView bottomListview;
       //   private SimpleAdapter adapter=null;
       //   private List<Map<String,String>> listData1=null;
       //   private List<Map<String,String>> listData2=null;
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        // TODO Auto-generated method stub  
	        super.onActivityCreated(savedInstanceState);  
	    }  
	  
	    @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) { 
	    	View view=inflater.inflate(R.layout.fragment_me_2, null);
	     //   midListview=(CornerListView)view.findViewById(R.id.mid);
	     //   bottomListview=(CornerListView)view.findViewById(R.id.bottom);
	    ///	initData();
	    //	String from[] ={"text"};
	     //   int to[] ={R.id.me_settings_title};
	    ///	adapter=new SimpleAdapter(this.getActivity(),listData1,R.layout.connerlistview_item,from,to);
	    //	midListview.setAdapter(adapter);
	    	
	    	//adapter=new SimpleAdapter(this.getActivity(),listData2,R.layout.connerlistview_item,from,to);
	    //    bottomListview.setAdapter(adapter);
	    	return view;  
	    } 
	    
	/*    private void initData(){
	    	listData1=new ArrayList<Map<String,String>>();
	    	Map<String,String> map1 = new HashMap<String, String>();
	    	map1.put("text",getResources().getString(R.string.my_account));  
	        listData1.add(map1);  
	          
	        map1 = new HashMap<String, String>();  
	        map1.put("text",getResources().getString(R.string.my_friends));
	        listData1.add(map1);  
	          
	        map1 = new HashMap<String, String>();  
	        map1.put("text",getResources().getString(R.string.my_collect));  
	        listData1.add(map1);  
	        
	        listData2=new ArrayList<Map<String,String>>();
	        Map<String,String> map2 = new HashMap<String, String>();
	        map2.put("text",getResources().getString(R.string.details));  
	        listData2.add(map2); 
	          
	        map2 = new HashMap<String, String>();  
	        map2.put("text",getResources().getString(R.string.sdv));
	        listData2.add(map2); 
	          
	        map2 = new HashMap<String, String>();  
	        map2.put("text",getString(R.string.settings));  
	        listData2.add(map2);  
	    }
	    */
}
