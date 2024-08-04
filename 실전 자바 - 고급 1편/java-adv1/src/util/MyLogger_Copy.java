package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// 추상 클래스로 만들어서 직접 생성할 수 없게 한다.
public abstract class MyLogger_Copy {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj) {
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }
}
