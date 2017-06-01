package yibo.zhang.spider.spider1;

public interface Frontier {
	public CrawlUrl getNext() throws Exception;
	public boolean putUrl(CrawlUrl url) throws Exception;
	
}
