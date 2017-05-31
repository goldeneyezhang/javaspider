package yibo.zhang.spider.spider1;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//TestGet();
    	try {
			//TestPost();
			TestSpider s=new TestSpider();
			s.downloadPage("http://www.cainiaobangbang.com/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println( "Hello World!" );
    }
    public static void TestGet()
    {
    	CloseableHttpClient httpclient=HttpClientBuilder.create().build();
    	HttpGet httpget=new HttpGet("http://www.cainiaobangbang.com");
    	HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			System.out.println("response="+response.getStatusLine().getStatusCode());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	httpget.releaseConnection();
    }
    public static void TestPost() throws Exception, IOException
    {
    	CloseableHttpClient httpclient=HttpClientBuilder.create().build();
    	HttpPost httppost=new HttpPost("http://hotels.ctrip.com/Domestic/ShowHotelList.aspx");
    	List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(3);
    	nameValuePairs.add(new BasicNameValuePair("checkIn","2017-6-1"));
    	nameValuePairs.add(new BasicNameValuePair("checkOut","2017-6-3"));
    	nameValuePairs.add(new BasicNameValuePair("cityId","1"));
    	try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	HttpResponse response=httpclient.execute(httppost);
    	System.out.println("response="+response.getStatusLine().getStatusCode());
    	httppost.releaseConnection();
    }
  
}
