package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main_My {

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while(true) {
                log("A");

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread-A");
        Thread threadB = new Thread(() -> {
            while(true) {
                log("B");

                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread-B");
        threadA.start();
        threadB.start();
    }
}