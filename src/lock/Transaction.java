package lock;

import java.util.Random;


public class Transaction implements Runnable{
	private String name;
	private DB db = null;
	public Transaction(String name,DB db) {
		super();
		this.name = name;
		this.db = db;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//@Override
	public synchronized void run() {
		int i = (int)(Math.random()*10);
		int j = (int)(Math.random()*100);
		System.out.println(name+" 要操作的记录为："+i);
		System.out.println(name+"  begin!");
		db.read(db.records[i],name);
		db.write(db.records[i],j,name);
		System.out.println(name+"  commit!");
		System.out.println();
		Thread.interrupted();
	}

}
