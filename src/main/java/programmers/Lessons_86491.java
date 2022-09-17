package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * 코딩테스트 연습 > 완전탐색 > 최소직사각형
 * */
public class Lessons_86491 {
    public int solution(int[][] sizes) {
        int longSide = 0;
        int shortSide = 0;
        for (int[] size : sizes) {
            longSide = Math.max(longSide, Math.max(size[0], size[1]));
            shortSide = Math.max(shortSide, Math.min(size[0], size[1]));
        }
        return longSide * shortSide;
    }
}
