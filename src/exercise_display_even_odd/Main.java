package exercise_display_even_odd;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // OddThread...
        OddThread oddThread = new OddThread();
        Thread thread = new Thread(oddThread);
        thread.start();
        thread.join();
        // Even Thread...
        EvenThread evenThread = new EvenThread();
        evenThread.start();
    }
}

class OddThread implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(" Odd is: " + i);

                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class EvenThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(" Even is: " + i);

                    Thread.sleep(15);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
