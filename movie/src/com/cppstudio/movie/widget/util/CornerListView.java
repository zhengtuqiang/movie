package com.cppstudio.movie.widget.util;

import com.cppstudio.movie.activity.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ListView;

public class CornerListView extends ListView{
    
	public CornerListView(Context context) {  
        super(context);  
    }  
  
    public CornerListView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
    }  
  
    public CornerListView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
    
    @Override  
    public boolean onInterceptTouchEvent(MotionEvent ev) {  
    	 
    	switch (ev.getAction()) {  
        
        case MotionEvent.ACTION_DOWN:  
                
        	int x = (int) ev.getX();  
            int y = (int) ev.getY();  
            int itemnum = pointToPosition(x, y);
                if (itemnum == AdapterView.INVALID_POSITION)  
                        break;                   
                else  
                {    
                        if(itemnum==0){  
                                if(itemnum==(getAdapter().getCount()-1)){                                      
                                    setSelector(R.drawable.list_corner_bottom_selector);  //只有一项
                                }else{  
                                    setSelector(R.drawable.list_corner_mid_selector);  //第一项 
                                }  
                        }else if(itemnum==(getAdapter().getCount()-1))  
                                setSelector(R.drawable.list_corner_bottom_selector);   //最后一项
                        else{                              
                                setSelector(R.drawable.list_corner_mid_selector);   //中间项
                        }  
                }  
  
                break;  
        case MotionEvent.ACTION_UP:  
        	
                break;  
        }  
      return super.onInterceptTouchEvent(ev);  
    	
    }  
}
