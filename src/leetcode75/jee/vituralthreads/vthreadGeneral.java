package leetcode75.jee.vituralthreads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class vthreadGeneral {

    private static void vthread() {

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream stream = IntStream.rangeClosed(1, 50);

            stream.forEach(value -> {
                executor.submit(() -> {
                    System.out.print("vtask :" + value + " ");
                    try {
                        Thread.sleep(Duration.ofSeconds(1));
                    } catch (InterruptedException ie) {
                        ie.getCause();
                    }
                });
            });

        }

    }

    public static void main(String[] args) {
        vthread();
    }
}
