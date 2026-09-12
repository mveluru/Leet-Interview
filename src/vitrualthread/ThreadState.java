package vitrualthread;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                // Keep the thread alive for 500 milliseconds
                Thread.sleep(500);
                System.out.println("Hello from thread");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread.start();

        // The main thread checks the state immediately while background thread is sleeping
        System.out.println("State before join (1): " + thread.getState()); // Likely TIMED_WAITING
        System.out.println("State before join (2): " + thread.getState()); // Likely TIMED_WAITING

        // Main thread will now pause here and actively wait for the 500ms to finish
        thread.join();

        // Now that join() has successfully finished waiting, the thread is guaranteed to be dead
        System.out.println("State after join: " + thread.getState());
    }
}
