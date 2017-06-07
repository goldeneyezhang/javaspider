package yibo.zhang.spider.spider1;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;

public class BDBFrontier extends AbstractFrontier implements Frontier{
	//使用默认的路径和缓存大小构造函数
	public BDBFrontier(String homeDirectory) throws DatabaseException,FileNotFoundException{
		super(homeDirectory);
		EntryBinding keyBinding=new SerialBinding(javaCatalog,String.class);
		EntryBinding valueBinding=new SerialBinding(javaCatalog,CrawlUrl.class);
		pendingUrisDB=new StoredMap(database,keyBinding,valueBinding,true);
		
	}
	//获得下一条记录
	public CrawlUrl getNext() throws Exception{
		CrawlUrl result=null;
		
	}
}
