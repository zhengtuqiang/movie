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
                                    setSelector(R.drawable.list_corner_down);  
                                }else{  
                                    setSelector(R.drawable.list_corner_top_down);  
                                }  
                        }else if(itemnum==(getAdapter().getCount()-1))  
                                setSelector(R.drawable.list_corner_bottom_down);  
                        else{                              
                                setSelector(R.drawable.list_corner_mid_down);  
                        }  
                }  
  
                break;  
        case MotionEvent.ACTION_UP:  
        	int x1 = (int) ev.getX();  
            int y1 = (int) ev.getY();  
            int itemnum1 = pointToPosition(x1, y1);

             if (itemnum1 == AdapterView.INVALID_POSITION)  
                     break;                   
             else  
             {    
                     if(itemnum1==0){  
                             if(itemnum1==(getAdapter().getCount()-1)){                                      
                                 setSelector(R.drawable.list_corner_up);  
                             }else{  
                                 setSelector(R.drawable.list_corner_top_up);  
                             }  
                     }else if(itemnum1==(getAdapter().getCount()-1))  
                             setSelector(R.drawable.list_corner_bottom_up);  
                     else{                              
                             setSelector(R.drawable.list_corner_mid_up);  
                     }  
             }  
                break;  
        }  
        return super.onInterceptTouchEvent(ev);  
    }  
}
