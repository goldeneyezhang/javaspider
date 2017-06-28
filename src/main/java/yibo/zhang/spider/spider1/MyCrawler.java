package yibo.zhang.spider.spider1;

import java.io.IOException;
import java.util.Set;

import org.htmlparser.filters.LinkStringFilter;

public class MyCrawler {
	private ComputeUrl computeUrl=null;
	public MyCrawler(){
		computeUrl=new PageRankComputeUrl();
	}
	//使用种子初始化url队列
	private void initCrawlerWithSeeds(String[] seeds)
	{
		for(int i=0;i<seeds.length;i++)
			LinkQueue.addUnvisitedUrl(seeds[i]);
	}
	//抓取过程
	public void crawling(String[] seeds) throws IOException
	{
		//定义过滤器，提取以http://www.cainiaobangbang.com开头的链接
		LinkStringFilter filter=new LinkStringFilter("www.cainiaobangbang.com");
		//初始化URL队列
		initCrawlerWithSeeds(seeds);
		//循环条件：待抓取的链接不空且抓取的网页不多于1000
		while(!LinkQueue.unVisitedUrlsEmpty()&&LinkQueue.getVisitedUrlNum()<=1000)
		{
			//队头URL出队列
			String visitUrl=(String)LinkQueue.unVisitedUrlDequeue();
			if(visitUrl==null)
				continue;
			DownloadFile downLoader=new DownloadFile();
			//下载网页
			String content=downLoader.downloadFile(visitUrl);
			if(computeUrl.accept(visitUrl, content)){
				continue;
			}
			//该URL放入已访问的URL中
			LinkQueue.addVisitedUrl(visitUrl);
			//提取出下载网页中的URL
			Set<String>links=HtmlParserTool.extracLinks(visitUrl, filter);
			//新的未访问的URL入队
			for(String link:links)
			{
				LinkQueue.addUnvisitedUrl(link);
			}
		}
	}
	//main方法入口
	public static void main(String[] args)
	{
		MyCrawler crawler=new MyCrawler();
		try {
			crawler.crawling(new String[]{"http://www.cainiaobangbang.com"});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
