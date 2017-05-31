package yibo.zhang.spider.spider1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class TestSpider {


		  private static HttpClient httpClient=HttpClientBuilder.create().build();
	    	public boolean downloadPage(String path) throws HttpException,IOException{
	    		OutputStream output=null;
	    		//得到post方法
	    		HttpPost httppost=new HttpPost(path);
	    		//设置post方法的参数
	    		List<NameValuePair> postData=new ArrayList<NameValuePair>();
	    		postData.add(new BasicNameValuePair("name","zhangyibo@finance365.com"));
	    		postData.add(new BasicNameValuePair("password","wmiwmi"));
	    		httppost.setEntity(new UrlEncodedFormEntity(postData));
	    		HttpResponse response=httpClient.execute(httppost);
	    		System.out.println("response="+response.getStatusLine().getStatusCode());
	    		if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
	    			String  str = EntityUtils.toString(response.getEntity());
	    			String filename="response.txt";  
	    			output=new FileOutputStream(filename);
	    			//输出到文件
	    			output.write(str.getBytes());
	    			if(output!=null){
	    				output.close();
	    			}
	    			return true;
	    		}
	    		return false;
	    	}
	    
}
