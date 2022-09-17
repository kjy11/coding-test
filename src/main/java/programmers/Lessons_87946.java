package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/7946
 * 코딩테스트 연습 > 완전탐색 > 피로도
 * */
public class Lessons_87946 {
    int answer = 0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        explore(k, 0, dungeons);
        return answer;
    }

    private void explore(int k, int count, int[][] dungeons) {
        for (int i = 0; i < visit.length; i ++) {
            if (visit[i] || k < dungeons[i][0]) {
                continue;
            }
            visit[i] = true;
            explore(k - dungeons[i][1], count + 1, dungeons);
            visit[i] = false;
        }
        if (answer < count) {
            answer = count;
        }
    }
}
