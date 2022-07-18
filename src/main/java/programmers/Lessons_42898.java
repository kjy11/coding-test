package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=java
 * 코딩테스트 연습 > 동적계획법 > 등굣길
 * */
public class Lessons_42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (i == 0 && j == 0) {
                    map[i][j] = 1;
                } else if (isPuddle(i, j, puddles)) {
                    map[i][j] = 0;
                } else if (i == 0) {
                    map[i][j] = map[i][j - 1];
                } else if (j == 0) {
                    map[i][j] = map[i - 1][j];
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1] % 1000000007;
                }
            }
        }

        return map[n-1][m-1];
    }

    boolean isPuddle(int i, int j, int[][] puddles) {
        for (int[] puddle : puddles) {
            if (puddle[1] - 1 == i && puddle[0] - 1 == j) {
                return true;
            }
        }
        return false;
    }
}
