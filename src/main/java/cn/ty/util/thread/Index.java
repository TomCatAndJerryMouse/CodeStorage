package main.java.cn.ty.util.thread;

public class Index {
	public static void main(String[] args) {
		ThreadLocal<String> tl = new ThreadLocal<String>();
		tl.set("sss");
		MyThread mt = new MyThread();
		MyThread mt1 = new MyThread();
		System.out.println(mt.getState());
		mt.start();
		mt1.start();
		System.out.println(mt.getState());
		try {
			mt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mt.getState());
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
////				tl.set("ss");
//			}
//		});
	}
}
