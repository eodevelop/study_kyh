package thread.start.test;

import static util.MyLogger.log;

public class StartTest1Main_My {

    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread();
        counterThread.start();
    }

    static class CounterThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                log("value: " + (i + 1));

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}