package yibo.zhang.spider.spider1.Compare;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.htmlparser.PrototypicalNodeFactory;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.util.ParserException;
import org.jsoup.nodes.Node;

public class TestCompare {
	public static void main(String[] args) {
		Integer[] s1=new Integer[]{1,34,55,65656,8,8,0,1,2,3};
		Integer[] s2=new Integer[]{0,1,2,3,5,5,6,7,7,8};
		HtmlCompare<Integer> compare=new HtmlCompare<Integer>();
		List<Integer> result=compare.longestCommonSubsequence(s1, s2);
		for(Integer i:result){
			System.out.println(i);
		}
}
	//计算两个网页的相似度sim=(2*LCS-Length)/(Length1+Length2)
	public double getPageSim(String urlStr1,String urlStr2) throws ParserException, IOException{
		ArrayList<Node> pageNodes1=new ArrayList<Node>();
		URL url=new URL(urlStr1);
		Node node;
		Lexer lexer=new Lexer(url.openConnection());
		lexer.setNodeFactory(new PrototypicalNodeFactory());
		while(null!=(node=(Node) lexer.nextNode()))
		{
			pageNodes1.add(node);
		}
		ArrayList<Node> pageNodes2=new ArrayList<Node>();
		URL url2=new URL(urlStr2);
		lexer=new Lexer(url2.openConnection());
		lexer.setNodeFactory(new PrototypicalNodeFactory());
		while(null!=(node=(Node) lexer.nextNode()))
		{
			pageNodes2.add(node);
		}
		//得到distance
		double distance=100;//调用htmlcompare
		return (2.0*distance)/((double)pageNodes1.size()+(double)pageNodes2.size());
		
	}
}
