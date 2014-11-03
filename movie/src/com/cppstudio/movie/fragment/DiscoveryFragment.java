package com.cppstudio.movie.fragment;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cppstudio.movie.activity.R;
import com.cppstudio.movie.adapter.ViewPagerAdapter;

public class DiscoveryFragment extends Fragment{
	private static final int TIME = 2500;
	private Runnable viewpagerRunnable;
	private static Handler handler;
	private ViewPager viewpager;
	 @Override  
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        // TODO Auto-generated method stub  
	        super.onActivityCreated(savedInstanceState);  
	        handler = new Handler();

			// ����¼�����
			initListener();
			viewpager.setAdapter(new ViewPagerAdapter(initData()));

			// �����Զ��л�ͼƬ
			initRunnable();
	 }  
	  
	    @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) {  
	        View view=inflater.inflate(R.layout.fragment_discovery, container, false);  
	    	
	        viewpager=(ViewPager)view.findViewById(R.id.viewpager);
	        
	    	
	    	return view;
	    } 
	    
	    public List<View> initData(){
	    	
	    	int drawable[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.splash};
	    	List<View> list=new ArrayList<View>();
	    	ImageView img;
	    	View view=null;
	    	LayoutInflater inflater=LayoutInflater.from(getActivity());
	        for(int i=0;i<drawable.length;i++){
	    	  view=inflater.inflate(R.layout.viewpager_item,null);
	    	  img = (ImageView) view.findViewById(R.id.img);
		      img.setBackgroundResource(drawable[i]);
			  list.add(view);
	        }
	      
	    	
	        return list;
	    	
	    	
	    }
	    
	    public void initListener(){
	    	viewpager.setOnPageChangeListener(new OnPageChangeListener(){
	    		boolean isScrolled = false;
				@Override
				public void onPageScrollStateChanged(int arg0) {
					// TODO Auto-generated method stub
				     switch(arg0){
				        
				        case 1:// ���ƻ���
							isScrolled = false;
							break;
						case 2:// �����л�
							isScrolled = true;
							break;
						case 0:// ��������
							// ��ǰΪ���һ�ţ���ʱ�������󻬣����л�����һ��
							if (viewpager.getCurrentItem() == viewpager.getAdapter()
									.getCount() - 1 && !isScrolled)
							{
								viewpager.setCurrentItem(0);
							}
							// ��ǰΪ��һ�ţ���ʱ�������һ������л������һ��
							else if (viewpager.getCurrentItem() == 0 && !isScrolled)
							{
								viewpager.setCurrentItem(viewpager.getAdapter()
										.getCount() - 1);
							}
							break;
				     }
				}

				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onPageSelected(int arg0) {
					// TODO Auto-generated method stub
					
				}
	    		
	    	
	    	});
	    	
	    	
	    }
	    
	    /**
		 * ��ʱ�л�
		 */
		protected void initRunnable()
		{
			viewpagerRunnable = new Runnable()
			{

				@Override
				public void run()
				{
					int nowIndex = viewpager.getCurrentItem();
					int count = viewpager.getAdapter().getCount();
					// �����һ�ŵ������������һ�ţ����л�����һ��
					//if (nowIndex + 1 >= count)
				//	{
				//		viewpager.setCurrentItem(0);
				//	} else
				//	{
						viewpager.setCurrentItem(nowIndex + 1);
				//	}
					handler.postDelayed(viewpagerRunnable, TIME);
				}
			};
			handler.postDelayed(viewpagerRunnable, TIME);
		}
}
