package yibo.zhang.spider.spider1;
//column有效性的记录
public class TableColumnValid {
	private int tdNum;
	private boolean valid;
	public int getTdNum(){
		return tdNum;
	}
	public void setTdNum(int tdNum){
		this.tdNum=tdNum;
	}
	public boolean isValid(){
		return valid;
	}
	public void setValid(boolean valid){
		this.valid=valid;
	}
}
