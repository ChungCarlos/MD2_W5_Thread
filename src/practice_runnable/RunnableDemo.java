package practice_runnable;

public class RunnableDemo implements Runnable{
    private Thread t;
    private final String threadName;

    public RunnableDemo(String name){
        threadName = name;
        System.out.println(" Creating " + threadName);
    }
    @Override
    public void run() {
        System.out.println(" Running " + threadName);
        try {
            for (int i = 4; i < 0; i--) {
                System.out.println(" Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e){
            System.out.println(" Thread " + threadName + " interrupted.");
        }
        System.out.println(" Thread " + threadName + " exiting.");
    }
    public  void start(){
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }

    public static void main(String[] args) {
        System.out.println("Main thread running... ");

        RunnableDemo runnableDemo1 = new RunnableDemo(" This is Chung ");
        runnableDemo1.start();

        RunnableDemo runnableDemo2 = new RunnableDemo("That is Thread.");
        runnableDemo2.start();

        System.out.println("Main thread stopped!!! ");
    }
}
