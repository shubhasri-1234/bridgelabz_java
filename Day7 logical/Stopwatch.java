public class Stopwatch {
    private long startTime;
    private long endTime;

    // Start the stopwatch
    public void start() {
        startTime = System.currentTimeMillis();
        System.out.println("Stopwatch started at: " + startTime);
    }

    // Stop the stopwatch
    public void stop() {
        endTime = System.currentTimeMillis();
        System.out.println("Stopwatch stopped at: " + endTime);
    }

    // Calculate and print the elapsed time
    public void elapsedTime() {
        if (startTime == 0) {
            System.out.println("Stopwatch not started. Please start the stopwatch first.");
        } else if (endTime == 0) {
            System.out.println("Stopwatch not stopped. Please stop the stopwatch first.");
        } else {
            long elapsedTime = endTime - startTime;
            System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
        }
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();

        // Start the stopwatch
        stopwatch.start();

        // Simulate some task or operation
        try {
            Thread.sleep(3000); // Simulate a 3-second task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the stopwatch
        stopwatch.stop();

        // Print the elapsed time
        stopwatch.elapsedTime();
    }
}
