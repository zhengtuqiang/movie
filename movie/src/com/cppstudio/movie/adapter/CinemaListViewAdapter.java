package com.cppstudio.movie.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cppstudio.movie.activity.R;
import com.cppstudio.movie.model.Cinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CinemaListViewAdapter extends BaseAdapter{
    private List<Cinema> list=new ArrayList<Cinema>();
    private Context context;
    
    public CinemaListViewAdapter(Context context,List<Cinema> list){
    	this.context=context;
    	this.list=list;
    }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=LayoutInflater.from(context);
		ViewHolder holder=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.cinema_listview_item,null);
			holder=new ViewHolder();
			holder.name=(TextView)convertView.findViewById(R.id.cinema_name);
			holder.address=(TextView)convertView.findViewById(R.id.cinema_address);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder)convertView.getTag();
		}
		   holder.name.setText(list.get(position).getName());
		   holder.address.setText(list.get(position).getAddress());
		   
		   return convertView;
	}
	
	private static class ViewHolder{
		 TextView name;
		 TextView address;
	}

}
