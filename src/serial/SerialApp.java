package serial;

public class SerialApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DB db = new DB();
		db.init();
		int i = (int)(Math.random()*10);
		System.out.println("此次随即产生的事务数目为："+i);
		System.out.println("串行操作开始！");
		for(int j=0; j<i;j++){
			Thread thread = new Thread(new Transaction("事务 "+j,db));
			thread.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("串行操作后，数据库记录变为：");
		db.printRecords();
	}

}
