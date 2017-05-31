package yibo.zhang.spider.spider1;

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
}
