package PageRank;
//元素列表，对行进行建模
public class EntryList {
	Entry data;
	EntryList next,tail;
	public EntryList(){
		next=null;
		tail=null;
		data=null;
	}
	//添加数据
	void add(Entry x){
		if(tail==null){
			data=x;
			tail=this;
		}else{
			tail.next=new EntryList();
			tail.next.data=x;
			tail=tail.next;
		}
	}
}
