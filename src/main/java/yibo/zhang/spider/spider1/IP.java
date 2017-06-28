package yibo.zhang.spider.spider1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class IP {
	public static void main(String[] args) throws IOException{
		String hostname;
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n");
		System.out.print("Host name: ");
		hostname=input.readLine();
		try{
			InetAddress ipaddress=InetAddress.getByName(hostname);
			System.out.println("IP Address:"+ipaddress.getHostAddress());
		}
		catch(Exception e)
		{
			System.out.println("Could not find IP address for:"+hostname);
		}
	}
}
