package lock;

public class DB {
	public static Record records[] = new Record[10];
	
	public void init(){
		for(int i=0; i<records.length; i++){
			Record record = new Record(i,i);
			records[i] = record;
		}
		System.out.println("初始化数据库中的记录为：");
		for(int i=0; i<records.length; i++){
			System.out.println(records[i]);
		}
		System.out.println();
	}
	
	public void read(Record record,String name){
		System.out.println(name+"读得记录"+record.getId()+"的x值为："+record.getX());
	}
	
	public void write(Record record,int x,String name){
		record.setX(x);
		System.out.println(name+"写入记录"+record.getId()+"中的x值为："+x);
	}
	
	public void printRecords(){
		for(int i=0; i<records.length; i++){
			System.out.println(records[i]);
		}
	}
}
