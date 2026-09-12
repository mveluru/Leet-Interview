package vitrualthread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public void completableFutureExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> account = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ACC100";
        });

        CompletableFuture<String> sell = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "SELL";
        });
        CompletableFuture.allOf(account, sell).join();
        System.out.println("completableFutureExample");
    }
    public static void  main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting CompletableFutureExample");
        CompletableFutureExample example = new CompletableFutureExample();
        example.completableFutureExample();
    }
}
