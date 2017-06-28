package yibo.zhang.spider.spider1;

public class IPTest {
	public static void main(String[] args){
		//指定纯真数据库的文件名和所在文件夹
		IPSeeker ip=new IPSeeker("QQwry.Dat","E:\\qqwry.dat");
		//测试IP 111.13.100.91
		IPLocation loc=ip.getIPLocation("111.13.100.91");
		System.out.println(loc.getCountry()+":"+loc.getArea());
	}
}
