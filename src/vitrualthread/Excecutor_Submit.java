package vitrualthread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Excecutor_Submit {

    public static void submitThread(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(()->{
            System.out.println("Submitting task calculating.");
            Thread.sleep(1000);
            return 43;
        });
        try{
            //Blocks until the results are ready
            Integer taskResult = future.get();
            System.out.println(taskResult);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        submitThread();
    }
}
