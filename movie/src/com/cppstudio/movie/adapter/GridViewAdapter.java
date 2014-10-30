package com.cppstudio.movie.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cppstudio.movie.activity.R;
import com.cppstudio.movie.model.GridViewItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class GridViewAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private Context context;
    private List<GridViewItem> list =new ArrayList<GridViewItem>();
	
    public GridViewAdapter(Context context,List<GridViewItem> list){
    	
    	this.context=context;
    	this.list=list;
    	
    }
    @Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=LayoutInflater.from(context);
		ViewHolder holder=null;
		
		if(view==null){
			view=inflater.inflate(R.layout.gridview_item,null);
			holder=new ViewHolder();
			holder.filmView=(ImageView)view.findViewById(R.id.film_view);
			holder.score=(TextView)view.findViewById(R.id.score);
			holder.title=(TextView)view.findViewById(R.id.title);
			holder.rating=(RatingBar)view.findViewById(R.id.rating);
			//holder.line=(View)view.findViewById(R.id.line);
		    view.setTag(holder);
		}else{
			holder=(ViewHolder)view.getTag();
		}
		
		holder.filmView.setImageResource(list.get(position).getImage());
		holder.title.setText(list.get(position).getTitle());
		holder.score.setText(list.get(position).getScore());
		
		
		return view;
	}
	
	private static class ViewHolder{
		private ImageView filmView;
		private TextView score;
		private RatingBar rating;
		private TextView title;
		//private View line;
	}

}
