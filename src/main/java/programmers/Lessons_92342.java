package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 * 코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT > 양궁대회
 * */
public class Lessons_92342 {
    private int[] givenInfo;
    private int gapMax = 1;
    private final List<int[]> list = new ArrayList<>();

    public int[] solution(int n, int[] info) {
        givenInfo = info;
        dfs(n, new int[11], 0);
        return list.stream().max((o1, o2) -> {
            for (int i = 10; i >=0; i --) {
                if (o1[i] == o2[i]) continue;
                return o1[i] - o2[i];
            }
            return 0;
        }).orElse(new int[] {-1});
    }

    private void dfs(int count, int[] result, int start) {
        if (count == 0 || start == 10) {
            int gap = getScoreGap(result);
            if (gapMax <= gap) {
                if (gapMax < gap) {
                    list.clear();
                }
                gapMax = gap;
                int[] tmp = result.clone();
                tmp[10] += count;
                list.add(tmp);
            }
            return;
        }
        for (int i = start; i < 10; i ++) {
            int nextCount = count - givenInfo[i] - 1;
            if (nextCount >= 0) {
                result[i] += (givenInfo[i] + 1);
                dfs(nextCount, result, i + 1);
                result[i] -= (givenInfo[i] + 1);
                continue;
            }
            dfs(count, result, i + 1);
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
