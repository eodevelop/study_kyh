package lambda.ex2_m1;

import lambda.ex2.MyPredicate;

import java.util.ArrayList;
import java.util.List;

public class FilterExamM1_M1 {

    public static List<Integer> filter(List<Integer> list, MyPredicate
            predicate) {
        List<Integer> result = new ArrayList<>();
        for (int val : list) {
            if (predicate.test(val)) {
                result.add(val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);
        System.out.println("원본 리스트: " + numbers);
        // 1. 음수(negative)만 뽑아내기

        MyPredicate negative = value -> value < 0;
        System.out.println("음수만: " + filter(numbers, negative));

        // 2. 짝수(even)만 뽑아내기

        MyPredicate even = value -> value % 2 == 0;
        System.out.println("짝수만: " + filter(numbers, even));
    }
}
