package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV3_Coyp {

    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });
        thread.start();

        log("main() end");
    }

}
