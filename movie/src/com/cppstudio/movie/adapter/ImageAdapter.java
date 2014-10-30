package com.cppstudio.movie.adapter;

import com.cppstudio.movie.activity.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/*画廊的适配器
 * 
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    
    
    private int selectItem;
    private int items[]={R.drawable.splash,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5};
    
    public ImageAdapter(Context context){
    		//,int[] items){
    	this.context=context;
    	//this.items=items;
    }
    public void setSelectItem(int selectItem){
      if(this.selectItem!=selectItem){
    	  this.selectItem=selectItem;
    	  notifyDataSetChanged();
      }
    	
    }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//返回一个无限大的总数，实现类似循环的效果
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;//positon的最大值是conunt-1
	}

	@Override
	public long getItemId(int id) {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		 if(position<0){
			 position+=items.length;
		 }
	    
		
		ViewHolder holder=null;
		 
		 if(view==null){
			 view=LayoutInflater.from(context).inflate(R.layout.gallery_item,null);
			 holder=new ViewHolder();
			 holder.mView=(ImageView)view.findViewById(R.id.view);
			 view.setTag(holder);
		 }else{
			 holder=(ViewHolder)view.getTag();
		 }
		 
		 holder.mView.setImageResource(items[(position+items.length)%items.length]);
		 
	    if(selectItem==position){
			//Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.my_scale_action);    //后期添加实现动画效果  
	        view.setLayoutParams(new Gallery.LayoutParams(300,450));  
	        //  imageView.startAnimation(animation);  //选中时，这是设置的比较大
		  
		}else{
			view.setLayoutParams(new Gallery.LayoutParams(150,250));  
		}
		
		
		
		
		return view;
	}
	
	private static class ViewHolder{
		ImageView mView;
	}

}

