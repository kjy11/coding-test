package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * 코딩테스트 연습 > 이분탐색 > 입국심사
 * */
public class Lessons_43238 {
    public long solution(int n, int[] times) {
        long answer;
        Arrays.sort(times);
        long max = (long) times[0] * n;
        long min = times[0] - 1;

        while(true) {
            if (max - 1 == min) {
                answer = max;
                break;
            }
            long mid = (max + min) / 2;
            if (checkAnswer(n, mid, times)) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return answer;
    }

    private boolean checkAnswer(int n, long mid, int[] times) {
        long count = 0;
        for (long time : times) {
            count += mid / time;
        }
        return count >= n;
    }

}
