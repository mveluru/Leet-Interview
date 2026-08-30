package vitrualthread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VitrualThread1 {
	public void startVirtualThread(){
		try {
			  Thread vThread = Thread.ofVirtual().start(() -> {
			        System.out.println("Virtual threads are daemon threads. If your main execution thread \n"
			        		+ "finishes execution and exits, the JVM will shut down immediately without\n "
			        		+ "waiting for background daemon threads to finish. Calling vThread.join() forces the main program \n"
			        		+ "thread to pause and wait until your virtual thread finishes printing its output.\n");
			    });

			    // Wait for the virtual thread to complete before the main program ends
			    vThread.join(); 	
		}catch (InterruptedException e) {
			System.out.println(e.getMessage().toString());
		}
	  
	}
	
	/* Create 5 virtual threads, each printing its task number.
       Expected output (order can vary):
       Task 1 Task 2 Task 3 Task 4 Task 5 Use virtual threads and make sure the method waits for all 5 to finish.*/

	public void startVirtual5Thread() {
		   // The try-with-resources block automatically waits for all threads to finish
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 5; i++) {
                final int taskNumber = i; // Must be effectively final to use inside lambda
                
                executor.submit(() -> {
                    System.out.println("Task " + taskNumber);
                });
            }
        } // Executor implicitly closes here, blocking until all 5 tasks are fully done
        
        System.out.println("All tasks finished!");
		
	}
	
	public void isVirtual() throws InterruptedException {
		
		Thread vthread = Thread.ofVirtual()
				.name("vthread1")
				.start(()->{
					System.out.println(Thread.currentThread().isVirtual());
				});
		vthread.join();
		
	}
	
	public void threeVirutalThreads() {
		try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
			for(int i=1;i<4;i++) {
				final int taskId =i;
				executor.submit(()->{
					System.out.println("Start-"+taskId);
					try {
						Thread.sleep(1000);
						System.out.println("End-"+taskId);
					}catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
					
				});
			}
		}
		System.out.println("\nExecution Completed");
	}
	
	public static void startThreadtask() {
		
			CompletableFuture<Integer> future =
				    CompletableFuture
				        .supplyAsync(() -> 10)
				        .thenApply(x-> x+5)
				        .thenApply(x -> x * 2);

				System.out.println(future.join());
		
	}
	
 public static void main(String[] args) throws InterruptedException {
	 VitrualThread1 vt = new VitrualThread1();
	 vt.startVirtualThread();
     vt.startVirtual5Thread();
     vt.isVirtual();
     vt.threeVirutalThreads();
 }
}
