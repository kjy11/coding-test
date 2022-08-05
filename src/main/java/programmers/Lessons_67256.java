package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 * 코딩테스트 연습 > 2020 카카오 인턴십 > 키패드 누르기
 * */
public class Lessons_67256 {
    private String mainHand;
    private final Map<String, int[]> map = new HashMap<>();
    private int[] left;
    private int[] right;

    public String solution(int[] numbers, String hand) {
        mainHand = hand.equals("right") ? "R" : "L";
        for (int i = 0; i < 12; i ++) {
            if (i < 9) {
                map.put(Integer.toString(i + 1), new int[] {i / 3, i % 3});
            } else if (i == 9) {
                map.put("*", new int[] {3, 0});
            } else if (i == 10) {
                map.put("0", new int[] {3, 1});
            } else {
                map.put("#", new int[] {3, 2});
            }
        }
        left = map.get("*");
        right = map.get("#");

        StringBuilder answer = new StringBuilder(numbers.length);
        for (int number : numbers) {
            answer.append(move(number));
        }
        return answer.toString();
    }

    private String move(int number) {
        String result;
        int[] location = map.get(Integer.toString(number));
        switch (number) {
            case 1:
            case 4:
            case 7:
                result = "L";
                break;
            case 3:
            case 6:
            case 9:
                result = "R";
                break;
            default:
                int leftMove = Math.abs(left[0] - location[0]) + Math.abs(left[1] - location[1]);
                int rightMove = Math.abs(right[0] - location[0]) + Math.abs(right[1] - location[1]);
                if (leftMove > rightMove) {
                    result = "R";
                } else if (rightMove > leftMove) {
                    result = "L";
                } else {
                    result = mainHand;
                }
        }
        if (result.equals("L")) {
            left = location;
        } else {
            right = location;
        }
        return result;
    }
}
