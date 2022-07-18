package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 * 코딩테스트 연습 > Summer/Winter Coding(2019) > 멀정한 사각형
 **/

public class Lessons_62048 {
    public long solution(int w, int h) {
        long invalidCount = 0;
        double preY = 0;

        for (int x = 1; x <= w; x ++) {
            double y = ((double) h * x) / w;
            invalidCount = invalidCount + (long) Math.ceil(y) - (long) preY;
            preY = y;
        }
        return ((long) w * h) - invalidCount;
    }
}
