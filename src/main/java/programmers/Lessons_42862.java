package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * 코딩테스트 연습 > 탐욕법 > 체육복
 * */
public class Lessons_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(lost);
        for (int i = 0; i < lost.length; i ++) {
            if (contains(reserve, lost[i])) {
                lost[i] = -1;
            }
        }
        for (int i : lost) {
            if (i == -1) {
                continue;
            }
            if (i > 1 && contains(reserve, i - 1)){
                continue;
            }
            if (i < n && contains(reserve, i + 1)) {
                continue;
            }
            answer --;
        }
        return answer;
    }

    boolean contains(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if (i == arr[j]) {
                arr[j] = -1;
                return true;
            }
        }
        return false;
    }
}
