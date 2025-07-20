package lambda.ex2_m1;

import lambda.ex2.StringFunction;

import java.util.ArrayList;
import java.util.List;

public class FilterExamM2_M1 {
    // 고차 함수, 함수를 인자로 받아, 리스트의 각 요소를 변환
    public static List<String> map(List<String> list, StringFunction func) {
        List<String> result = new ArrayList<>();
        for (String str : list) { //"hello", "java", "lambda"
            result.add(func.apply(str));
        }

        // 코드 작성
        return result;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);
        // 1. 대문자 변환
        StringFunction upper = s -> s.toUpperCase();
        System.out.println("대문자 변환 결과: " + map(words, upper));
        // 2. 앞뒤에 *** 붙이기 (람다로 작성)
        StringFunction addStar = s -> "***" + s + "***";
        System.out.println("특수문자 데코 결과: " + map(words, addStar));
    }
}
