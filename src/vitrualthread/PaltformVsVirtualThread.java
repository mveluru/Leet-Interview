package vitrualthread;

import java.util.ArrayList;
import java.util.List;

public class PaltformVsVirtualThread {
	public final int threadCount = 50000;
	List<Thread> threadList = new ArrayList<>();
	
	public  void platformThread() throws InterruptedException{
		Runnable runnable =()->{
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ie) {
				System.out.println(ie.getMessage());
			}
			
		};
		
		for (int i=0;i<threadCount;i++) {
			Thread thread = new Thread(runnable);
			thread.setName("pthreadName : "+i);
			thread.start();
			System.out.println("ThreadNumber "+i);
			threadList.add(thread);
		}
		for (Thread t:threadList) {
			t.join();
			System.out.println("Completed "+t.getName());
		}
	}
	
	public  void vitualThread() throws InterruptedException{
		Runnable runnable =()->{
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ie) {
				System.out.println(ie.getMessage());
			}
			
		};
		
		for (int i=0;i<threadCount;i++) {
			Thread thread = Thread.ofVirtual().unstarted(runnable);
			thread.setName("vthreadName : "+i);
			thread.start();
			System.out.println("ThreadNumber "+i);
			threadList.add(thread);
		}
		for (Thread t:threadList) {
			t.join();
			System.out.println("Completed "+t.getName());
		}
	}
	
	
public static void main(String[] args) {
	PaltformVsVirtualThread pv = new PaltformVsVirtualThread();
	try {
		//pv.platformThread();
		pv.vitualThread();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
