package cn.ty.util.thread;


public class MyThread extends Thread {
	private int count=0;
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
//			System.out.println("MyThread");
			try {
				count();
				System.out.println(currentThread().getName() + " " + count);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void count(){
		count ++;
	}
}
