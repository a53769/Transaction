package lock;

public class ConcurrencyLockApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DB db = new DB();
		db.init();
		int i = (int)(Math.random()*10);
		System.out.println("此次随即产生的事务数目为："+i);
		System.out.println();
		for(int j=0; j<i;j++){
			Thread thread = new Thread(new Transaction("事务 "+j,db));
			thread.start();
		}
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("并行操作后，数据库记录变为：");
		db.printRecords();//在DB.java中
	}

}
