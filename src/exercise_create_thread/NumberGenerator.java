package exercise_create_thread;

public class NumberGenerator{
    public static void main(String[] args) throws InterruptedException {
        // Class Task1
        TaskA taskA = new TaskA();
        Thread taskAThread = new Thread(taskA);
        taskAThread.setPriority(Thread.MAX_PRIORITY);
        taskAThread.hashCode();
        taskAThread.start();

        // Class Task2
        TaskB taskB = new TaskB();
        taskB.setPriority(Thread.MIN_PRIORITY);
        taskB.start();
    }
}
class TaskA implements Runnable{
    @Override
    public void run() {
        System.out.println("Task A started: ");

            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("<-" + i + " Mã băm: " + hashCode() + " -> ");
                Thread.sleep(500);
            }
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
        System.out.println(" \nTask A done...");
    }
}

class TaskB extends Thread{
    public void run() {
        System.out.println("Task B started: ");

        try {
            for (int i = 9; i >=0; i--) {
                System.out.println("<-" + i + " Mã băm " + hashCode() + " -> ");
                Thread.sleep(500);

            }
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" \nTask B done...");
    }
}
