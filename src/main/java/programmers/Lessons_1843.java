package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1843
 * 코딩테스트 연습 > 동적계획법 > 사칙연산
 **/

public class Lessons_1843 {
    public int solution(String[] arr) {
        int[] numbers = new int[arr.length / 2 + 1];
        String[] operations = new String[arr.length / 2];
        Set<String[]> opSet = new HashSet<>();
        opSet.add(operations);

        for (int i = 0; i < arr.length; i ++) {
            if (i % 2 == 0) {
                numbers[(i + 1) / 2] = Integer.parseInt(arr[i]);
                continue;
            }
            operations[i / 2] = arr[i];
        }

        for (int i = 0; i < operations.length - 1; i ++) {
            String[] tmp = new String[operations.length];
            System.arraycopy(operations, 0, tmp, 0, operations.length);
            if (operations[i].equals("-")) {
                for (int j = i + 1; j < operations.length; j ++) {
                    tmp[j] = change(tmp[j]);
                    String[] tmp2 = new String[operations.length];
                    System.arraycopy(tmp, 0, tmp2, 0, operations.length);
                    opSet.add(tmp2);
                }
            }
        }
        List<Integer> results = new ArrayList<>();
        for (String[] op : opSet) {
            results.add(calculate(numbers, op));
        }

        return results.stream().max(Comparator.comparingInt(o -> o)).orElse(0);
    }

    int calculate(int[] numbers, String[] operations) {
        int result = numbers[0];
        for (int i = 0; i < operations.length; i ++) {
            result = calculate(result, operations[i], numbers[i + 1]);
        }
        return result;
    }

    int calculate(int a, String o, int b) {
        if (o.equals("+")) {
            return a + b;
        }
        return a - b;
    }

    String change(String o) {
        if (o.equals("+")) {
            return "-";
        }
        return "+";
    }
}
