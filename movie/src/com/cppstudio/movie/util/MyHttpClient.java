package com.cppstudio.movie.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class MyHttpClient {
       private String MyUrl;
       private HttpClient client;
       private HttpParams params;//实现设置网络超时的参数
       private final int TIMEOUT_CONNECTION=10000;
       private final int TIMEOUT_SOCKET=10000;
       
       public MyHttpClient(String MyUrl){
    	  this.MyUrl=MyUrl;
    	  setTimeout();
    	  client=new DefaultHttpClient(params);
       }
       //设置超时
       public void setTimeout(){
    	   params=new BasicHttpParams();
    	   HttpConnectionParams.setConnectionTimeout(params, TIMEOUT_CONNECTION);
    	   HttpConnectionParams.setSoTimeout(params, TIMEOUT_SOCKET);
    	   client=new DefaultHttpClient(params);
    	  }
       
       public HttpGet head(HttpGet get){
    	   get.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:32.0) Gecko/20100101 Firefox/32.0");
    	   get.addHeader("Accept-Encoding",	"gzip, deflate");
    	   get.addHeader("Host","192.168.1.103:8887");
    	   get.addHeader("Accept-Language","zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
    	   get.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    	   get.addHeader("Connection","keep-alive");
    	   return get;
       }
      
       private HttpPost head(HttpPost post){
    	   
    	   
    	   return post;
    	   
       }
       
       public String post(HashMap urlParams) throws Exception{
    	   HttpPost httpPost=head(new HttpPost(MyUrl));
    	   List<NameValuePair> postParams=new ArrayList<NameValuePair>();
    	   Iterator it=urlParams.entrySet().iterator();
    	   while(it.hasNext()){
    		   Map.Entry entry=(Map.Entry) it.next();
    		   postParams.add(new BasicNameValuePair(entry.getKey().toString(),entry.getValue().toString()));
    		 }
    	   HttpResponse httpResponse=client.execute(httpPost);
    	   if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
    		   String result= EntityUtils.toString(httpResponse.getEntity()); 
    	   }else{
    		   return null;
    	   }
    	   
    	   return null;
    	 }
       
       public String get() throws Exception{
    	   HttpGet httpGet=head(new HttpGet(MyUrl));
    	   HttpResponse httpResponse=client.execute(httpGet);
    	   if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
    		   String result= EntityUtils.toString(httpResponse.getEntity()); 
    	   }else{
    		   return null;
    	   }
    	   
    	   return null;
       }
}
