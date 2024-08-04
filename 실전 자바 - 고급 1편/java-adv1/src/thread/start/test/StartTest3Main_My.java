package thread.start.test;

import static util.MyLogger.log;

public class StartTest3Main_My {

    public static void main(String[] args) {
        Runnable counterRunnable = new Runnable() {
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
        };

        Thread thread = new Thread(counterRunnable);
        thread.setName("counter");
        thread.start();
    }
}