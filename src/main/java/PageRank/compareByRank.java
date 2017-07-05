package PageRank;

import java.util.Comparator;
import java.util.Hashtable;

public class compareByRank implements Comparator<String> {
	Hashtable<String,Integer> hashedPages;
	String[] pages;
	int[] nLinks;
	double[] rank;
	String[] sortedRank;
	public int compare(String a,String b){
		
		int indexA=hashedPages.get(a);
		int indexB=hashedPages.get(b);
		if(rank[indexA]==rank[indexB]){
			return (0);
		}else if(rank[indexA]>rank[indexB]){
			return (-1);
		}else{
			return (1);
		}
	}
	public java.lang.String[] pageRank(java.lang.String[] s){
		//height of data
		int theSize=Math.max(4*s.length/3+1, 16);
		//初始化
		hashedPages=new Hashtable<String,Integer>(theSize);
		String[] pages=new String[s.length];
		int[] nLinks=new int[s.length];
		rank=new double[s.length];
		sortedRank=new String[s.length];
		String[] dataEntry=new String[s.length];
		//获取数据
		for(int i=0;i<s.length;i++){
			String[] temp=s[i].split(" ");
			pages[i]=temp[0];
			nLinks[i]=temp.length-1;
			sortedRank[i]=temp[0];
			rank[i]=1;
			dataEntry[i]="";
			hashedPages.put(pages[i], i);
		}
		int tRow,tCol;
		//初始化矩阵
		for(int i=0;i<s.length;i++){
			String[] temp=s[i].split(" ");
			for(int j=1;j<temp.length;j++){
				tCol=hashedPages.get(temp[0]);
				tRow=hashedPages.get(temp[j]);
				dataEntry[tRow]+="{"+tCol+","+(1/(double)nLInks[i])+"};";
			}
		}
		//创建矩阵数据
		BigMatrix dataMatrix=new BigMatrix(dataEntry);
		//排序
		rankFilter(dataMatrix);
		//返回排序后的URL列表
		return (sortedRank);
	}
}
