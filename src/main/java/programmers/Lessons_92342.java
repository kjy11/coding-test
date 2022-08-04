package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 * 코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT > 양궁대회
 * */
public class Lessons_92342 {
    private int[] givenInfo;
    private int gapMax = 0;
    private int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        givenInfo = info;
        dfs(n, new int[11], 9);
        return answer;
    }

    private void dfs(int count, int[] result, int start) {
        if (count == 0 || start == -1) {
            int gap = getScoreGap(result);
            if (gapMax < gap) {
                gapMax = gap;
                answer = result.clone();
                answer[10] += count;
            }
            return;
        }
        for (int i = start; i >= 0; i --) {
            int nextCount = count - givenInfo[i] - 1;
            if (nextCount >= 0) {
                result[i] += (givenInfo[i] + 1);
                dfs(nextCount, result, i - 1);
                result[i] -= (givenInfo[i] + 1);
                continue;
            }
            dfs(count, result, i - 1);
        }
    }

    private int getScoreGap(int[] result) {
        int apeach = 0;
        int ryan = 0;
        for (int i = 0; i < 11; i ++) {
            if (givenInfo[i] < result[i]) {
                ryan += (10 - i);
            } else if (givenInfo[i] != 0) {
                apeach += (10 - i);
            }
        }
        return ryan - apeach;
    }
}
