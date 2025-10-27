package Week_02;

public class InterruptExample implements Runnable {
    public void run() {
        try {

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() + "] Interrupted by exception!");
        }

        while (!Thread.interrupted()) {
            System.out.println("Running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("[" + Thread.currentThread().getName() + "] Interrupted for the second time inside the loop.");
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Interrupted for the second time.");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new InterruptExample(), "myThread");
        myThread.start();
        System.out.println("[" + Thread.currentThread().getName() + "] Sleeping in main thread for 2s...");
        Thread.sleep(2000);
        System.out.println("[" + Thread.currentThread().getName() + "] Interrupting myThread");
        myThread.interrupt();
        System.out.println("[" + Thread.currentThread().getName() + "] Sleeping in main thread for 5s...");
        Thread.sleep(5000);
        System.out.println("[" + Thread.currentThread().getName() + "] Interrupting myThread");
        myThread.interrupt();
    }
}