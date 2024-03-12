package Lab06.director.fisiere_java;

import java.util.concurrent.ArrayBlockingQueue;

public class WorkerThread extends Thread {
    private volatile boolean running = true; // Adding volatile to ensure visibility across threads
    private ArrayBlockingQueue<Runnable> taskQueue;

    // Constructor to initialize the taskQueue
    public WorkerThread(ArrayBlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void run() {
        try {
            while (running) {
                Runnable task = taskQueue.poll(); // Get a task from the queue.
                if (task == null) {
                    break; // (because the queue is empty)
                }
                task.run(); // Execute the task;
            }
        } finally {
            threadFinished(); // Records fact that this thread has terminated.
        }
    }

    private void threadFinished() {
        // Logic to record thread termination
        // You can implement your specific logic here
    }
}
