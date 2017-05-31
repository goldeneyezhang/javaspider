package yibo.zhang.spider.spider1;
import java.util.LinkedList; 
public class Queue {
	//使用链表实现队列
	private LinkedList queue=new LinkedList();
	//入队列
	public void enQueue(Object t){
		queue.addLast(t);
	}
}
