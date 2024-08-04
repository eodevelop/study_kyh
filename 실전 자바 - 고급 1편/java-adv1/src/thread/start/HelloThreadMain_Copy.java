package thread.start;

public class HelloThreadMain_Copy {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread_Copy helloThread_copy = new HelloThread_Copy();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        helloThread_copy.start();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
