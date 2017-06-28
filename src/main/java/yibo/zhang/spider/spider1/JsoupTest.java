package yibo.zhang.spider.spider1;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
	public static void main(String[] args){
		String url="http://www.cainiaobangbang.com";
		try {
			Document doc=Jsoup.connect(url).get();
			Elements links=doc.select("a[href]");
			for(Element link:links){
				String linkHref=link.attr("href");//得到href属性中的值，也就是URL地址
				String linkText=link.text();//得到锚点上的文字说明
				System.out.println(linkHref+" "+linkText);//输出URL地址和锚点上的文字说明
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
