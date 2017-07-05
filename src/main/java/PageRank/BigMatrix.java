package PageRank;

public class BigMatrix {
	public int nCols,nRows;
	EntryList[] theRows;
	//构造函数采用string的数组作为输入，例如{(1,1);(4,3);(5,8)
	//每个字符串能够初始化一行数据。例如（2，5）表示在第二行的第二列值为5
	public BigMatrix(java.lang.String[] x){
		nRows=x.length;
		nCols=0;
		theRows=new EntryList[nRows];
		for(int i=0;i<nRows;i++){
			theRows[i]=new EntryList();
			if(x[i]!=null){
				String[] tempArr=x[i].split(";");
				if(tempArr[0]!=null){
					for(int j=0;j<tempArr.length;j++){
						Entry instance=new Entry(tempArr[j]);
						theRows[i].add(instance);
						if(nCols<=instance.col){
							nCols=instance.col+1;
						}
					}
				}
			}
		}
	}
	//乘以1维向量
	public double[] multiply(double[] x){
		double[] result=new double[nRows];
		int count;
		for(int i=0;i<nRows;i++){
			EntryList temp=theRows[i];
			count=0;
			while((temp!=null)&&(temp.data!=null)){
				result[i]+=(temp.data.value*x[temp.data.col]);
				temp=temp.next;
				count++;
			}
		}
		return (result);
	}
	
}
