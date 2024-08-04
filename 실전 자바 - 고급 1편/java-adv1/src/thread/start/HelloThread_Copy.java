package thread.start;

public class HelloThread_Copy extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
}
