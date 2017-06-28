package yibo.zhang.spider.spider1;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

import org.apache.commons.logging.LogFactory;

/**
 * 工具类，提供一些方便的方法
 */
public class Util {
	private static StringBuilder sb=new StringBuilder();
	/**
	 * 从IP的字符串形式得到字节数组形式
	 * @param ip字符串形式的IP
	 * @return 字节数组形式的IP
	 */
	public static byte[] getIpByteArrayFromString(String ip){
		byte[] ret=new byte[4];
		StringTokenizer st=new StringTokenizer(ip,".");
		try{
			ret[0]=(byte)(Integer.parseInt(st.nextToken())&0xFF);
			ret[1]=(byte)(Integer.parseInt(st.nextToken())&0xFF);
			ret[2]=(byte)(Integer.parseInt(st.nextToken())&0xFF);
			ret[3]=(byte)(Integer.parseInt(st.nextToken())&0xFF);
		} catch(Exception e){
			LogFactory.getLog(Util.class).error(e.getMessage());
		}
		return ret;
	}
	/**
	 * @param ip
	 * IP的字节数组形式
	 * @return 字符串形式的IP
	 */
	public static String getIpStringFromBytes(byte[] ip){
		sb.delete(0, sb.length());
		sb.append(ip[0]&0xFF);
		sb.append('.');
		sb.append(ip[1]&0xFF);
		sb.append('.');
		sb.append(ip[2]&0xFF);
		sb.append('.');
		sb.append(ip[3]&0xFF);
		return sb.toString();
	}
	
	/**
	 * 根据某种编码方式将字节数组转换成字符串
	 * @param b字节数组
	 * @param offset要转换的起始位置
	 * @param len要转换的长度
	 * @param encoding编码方式
	 * @return 如果encoding不支持，返回一个默认编码的字符串
	 */
	public static String getString(byte[] b,int offset,int len,String encoding){
		try{
			return new String(b,offset,len,encoding);
		}catch(UnsupportedEncodingException e){
			return new String(b,offset,len);
		}
	}
}
