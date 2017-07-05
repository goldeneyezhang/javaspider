package PageRank;

public class Entry {
	int col;//元素所在列
	double value;//元素值
	public Entry(java.lang.String x){
		String[] temp=x.split(",");
		if(temp[0].compareTo("")!=0){
			col=Integer.parseInt(temp[0].trim().substring(1));
			value=Double.parseDouble(temp[1].trim().substring(0, temp[1].trim().length()-1));
		}
	}
}
