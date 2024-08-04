package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV1_Copy {
    public static void main(String[] args) {
        log("main() start");

        MyRunnable_Copy runnable = new MyRunnable_Copy();
        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }


    static class MyRunnable_Copy implements Runnable {

        @Override
        public void run() {
            log("run()");
        }
    }

}
