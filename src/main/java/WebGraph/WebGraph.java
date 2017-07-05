package WebGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;
import com.sleepycat.persist.StoreConfig;


public class WebGraph {
	//出度
	private PrimaryIndex<String,Link> outLinkIndex;
	//入度
	private SecondaryIndex<String,String,Link> inLinkIndex;
	private EntityStore store;
	
	/**
	 * 构造函数
	 */
	public WebGraph(String dbDir) throws DatabaseException{
		File envDir=new File(dbDir);
		EnvironmentConfig envConfig=new EnvironmentConfig();
		envConfig.setTransactional(false);
		envConfig.setAllowCreate(true);
		Environment env=new Environment(envDir,envConfig);
		
		StoreConfig storeConfig=new StoreConfig();
		storeConfig.setAllowCreate(true);
		storeConfig.setTransactional(false);
		
		store=new EntityStore(env,"classDb",storeConfig);
		outLinkIndex=store.getPrimaryIndex(String.class,Link.class);
		inLinkIndex=store.getSecondaryIndex(outLinkIndex, String.class, "toURL");
	}
	/**
	 * 构造Web图，从文件内读入。每一行为一个对应关系。
	 */
	public void load(File file) throws IOException,FileNotFoundException,DatabaseException{
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String line;
		while((line=reader.readLine())!=null){
			int index1=line.indexOf("->");
			if(index1==-1)
			{
				continue;
			}
			else{
				String url1=line.substring(0, index1).trim();
				String url2=line.substring(index1+2).trim();
				index1=url2.indexOf(" ");
				if(index1!=-1)
				{
					try
					{
						url2=url2.substring(0, index1).trim();
					}
					catch(Exception e){}
					addLink(url1,url2);
				}
			}
		}
	}
	//加入节点之间的对应关系
	public void addLink(String fromLink, String toLink) throws DatabaseException {
		// TODO Auto-generated method stub
		Link outLinks=new Link();
		
	}
}
