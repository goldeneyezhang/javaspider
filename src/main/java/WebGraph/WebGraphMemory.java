package WebGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebGraphMemory {
	//把每个URL映射为一个整数，存储在Web图中
	private Map<Integer,String> IdentifyerToURL;
	//存储Web图的Hash表
	private Map<String,Map<String,Integer>> URLToIdentifyer;
	//存储入度，其中整数的第一个参数是URL的ID，第二个参数存放指向这个URL链接的Map，Double表示权重
	private Map<Integer,Map<Integer,Double>> InLinks;
	//存储出度，其中第一个参数是URL的ID，第二个参数存放在网页中的超链接，Double表示权重
	private Map<Integer,Map<Integer,Double>> OutLinks;
	//图中节点的数目
	private int nodeCount;
	//构造函数，0个节点的构造函数
	public WebGraphMemory(){
		IdentifyerToURL=new HashMap<Integer,String>();
		URLToIdentifyer=new HashMap<String,Map<String,Integer>>();
		InLinks=new HashMap<Integer,Map<Integer,Double>>();
		OutLinks=new HashMap<Integer,Map<Integer,Double>>();
		nodeCount=0;
	}
	/**从一个文本文件中取得节点的构造函数。每行包含一个指向关系。例如：
	 * http://url1.com->http://ur2.com
	 * 表示url1.com指向url2.com的一个超链接，并且这个超链接的权重是1.0
	 */
	public WebGraphMemory(File file) throws IOException,FileNotFoundException{
		this();
		BufferedReader reader=new BufferedReader(new FileReader(file));
	}
}
