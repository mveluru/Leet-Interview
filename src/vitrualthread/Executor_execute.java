package vitrualthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor_execute {

    public static void execute() {
        try(ExecutorService executor = Executors.newSingleThreadExecutor()) {
            executor.execute(new Runnable() {
                public void run() {
                    System.out.println("Task running asynchronously.");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            executor.execute(() -> {
                System.out.println(
                        "Task running: " + Thread.currentThread()
                );
            });
        }
    }

    public static void main(String[] args) {
        execute();



    }
}
/*
execute() takes a Runnable:
executor.execute(Runnable task);
So it is good when you don't need a return value.
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

    executor.execute(() -> System.out.println("Payment task"));
    executor.execute(() -> System.out.println("Account task"));
    executor.execute(() -> System.out.println("Email task"));
    Each submitted task gets its own virtual thread.
    execute() → Runnable → no result
    submit()  → Runnable/Callable → can return Future
}
 */