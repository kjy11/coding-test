package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * 코딩테스트 연습 > 동적계획법 > 정수 삼각형
 **/

public class Lessons_43105 {
    public int solution(int[][] triangle) {
        int[] results = new int[] {triangle[0][0]};

        for (int i = 1; i < triangle.length; i ++) {
            int[] newResult = new int[i + 1];
            int[] row = triangle[i];
            for (int j = 0; j < row.length; j ++) {
                int tmp1 = 0;
                int tmp2 = 0;
                if (j != 0) {
                    tmp1 = row[j] + results[j - 1];
                }
                if (j != row.length - 1) {
                    tmp2 = row[j] + results[j];
                }
                newResult[j] = Math.max(tmp1, tmp2);
            }
            results = newResult;
        }
        return Arrays.stream(results).max().orElse(0);
    }
}
