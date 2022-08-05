package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 * 코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT > 파괴되지 않은 건물
 * */
public class Lessons_92344 {
    private int[][] mBoard;
    private int[][] delta;
    public int solution(int[][] board, int[][] skill) {
        mBoard = board;
        delta = new int[board.length + 1][board[0].length + 1];
        for (int[] s : skill) {
            afterSkill(s[0], s[1], s[2], s[3], s[4], s[5]);
        }
        return getAnswer();
    }

    private void afterSkill(int type, int r1, int c1, int r2, int c2, int degree) {
        if (type == 1) {
            degree = -degree;
        }
        delta[r1][c1] += degree;
        delta[r2 + 1][c2 + 1] += degree;
        delta[r1][c2 + 1] -= degree;
        delta[r2 + 1][c1] -= degree;
    }

    private int getAnswer() {
        int result = 0;
        for (int i = 0; i < mBoard.length; i ++) {
            for (int j = 0; j < mBoard[0].length; j ++) {
                if (i > 0) {
                    delta[i][j] += delta[i - 1][j];
                }
                if (j > 0) {
                    delta[i][j] += delta[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    delta[i][j] -= delta[i - 1][j - 1];
                }
                if (mBoard[i][j] + delta[i][j] > 0) {
                    result ++;
                }
            }
        }
        return result;
    }
}
