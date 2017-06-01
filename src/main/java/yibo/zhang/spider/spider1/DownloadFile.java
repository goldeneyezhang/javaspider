package yibo.zhang.spider.spider1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public class DownloadFile {
	//根据URL和网页类型生成需要保存的网页的文件名
	public String getFileNameByUrl(String url,String contentType){
		//移除HTTP
		url=url.substring(7);
		//text/html类型
		if(contentType.indexOf("html")!=-1){
			url=url.replaceAll("[\\?/:*|<>\"]", "_")+".html";
			return url;
		}
		//如application/pdf类型
		else
		{
			return url.replaceAll("[\\?/:*|<>\"]", "_")+"."+contentType.substring(contentType.lastIndexOf("/")+1);
		}
	}
	//保存网页字节数组到本地文件
	private void saveToLocal(byte[] data,String filePath){
		try{
			DataOutputStream out=new DataOutputStream(new FileOutputStream(new File(filePath)));
			for(int i=0;i<data.length;i++){
				out.write(data[i]);
			}
			out.flush();
			out.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//下载URL指向的网页
	public String downloadFile(String url){
		String filePath=null;
		//1.生成HttpClient对象并设置参数
		CloseableHttpClient httpClient=HttpClients.createDefault();
		//设置HTTP连接超时5s//设置get超时5s
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();//设置请求和传输超时时间
		
		//2.生成GetMethod对象并设置参数
		HttpGet httpGet=new HttpGet(url);
		httpGet.setConfig(requestConfig);
		//设置请求重试处理
		//httpClient.getParams().se(new DefaultHttpRequestRetryHandler());
		//3.执行Http Get请求
		try{
			CloseableHttpResponse response=httpClient.execute(httpGet);//执行请求
			//判断访问的状态码
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				System.err.println("Method failed:"+response.getStatusLine());
				filePath=null;
			}
			//4.处理HTTP响应内容
			byte[] responseBody=EntityUtils.toByteArray(response.getEntity());
			//根据网页URL生成保存时的文件名
			Header[] header=response.getAllHeaders();
			filePath="temp\\"+getFileNameByUrl(url,.)
		}
	}
}
