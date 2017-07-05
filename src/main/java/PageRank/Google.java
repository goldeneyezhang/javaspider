package PageRank;

import java.util.Arrays;
import java.util.Hashtable;

public class Google {
	private double[] rank;
	Hashtable<String,Integer> hashedPages;
	String[] sortedRank;
	public Google(){
		
	}
	private void rankFilter(BigMatrix dataMatrix){
	String[] tempRank=new String[sortedRank.length];
	Boolean isEqual=true;
	//迭代计算，直到数据收敛或者次数达到50次
	for(int i=0;i<50;i++){
		rank=dataMatrix.multiply(rank);
		//拷贝当前的数组值到临时数组
		for(int j=0;j<sortedRank.length;j++){
			tempRank[j]=sortedRank[j];
		}
		//排序
		Arrays.sort(sortedRank,new compareByRank());
		//计算是否收敛
		for(int j=0;j<sortedRank.length;j++){
			if(sortedRank[j].compareTo(tempRank[j])!=0){
				isEqual=false;
				break;
			}
		}
		if(isEqual==true){
			break;
		}else{
			isEqual=true;
		}
	}
	}
}
