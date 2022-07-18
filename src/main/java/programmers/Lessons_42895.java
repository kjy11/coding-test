package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895?language=java
 * 코딩테스트 연습 > 동적계획법 > N으로 표현
 **/

public class Lessons_42895 {
    public int solution(int N, int number) {
        int answer = -1;
        CaseSet[] caseSets = new CaseSet[8];

        for (int count = 1; count < 9; count ++) {
            CaseSet caseSet = new CaseSet(number);
            concatAsString(N, count, caseSet);

            for (int i = 0; i < count/ 2; i ++) {
                pickXY(caseSets[count - i - 2], caseSets[i], caseSet);
            }

            if (caseSet.finish()) {
                answer = count;
                break;
            }

            caseSets[count - 1] = caseSet;
        }
        return answer;
    }

    public void pickXY(CaseSet caseSet1, CaseSet caseSet2, CaseSet caseSet3) {
        for (Integer x : caseSet1.caseSet) {
            for (Integer y : caseSet2.caseSet) {
                operation(x, y, caseSet3);
            }
        }
    }

    public void concatAsString(int N, int count, CaseSet caseSet) {
        int result = 0;
        for (int i = 0; i < count; i ++) {
            result = result * 10 + N;
        }
        caseSet.add(result);
    }

    public void operation(int x, int y, CaseSet caseSet) {
        caseSet.add(x + y);
        caseSet.add(x * y);
        caseSet.add(x - y);
        caseSet.add(y - x);
        if (x != 0) {
            caseSet.add(y / x);
        }
        if (y != 0) {
            caseSet.add(x / y);
        }
    }

    public static class CaseSet {
        Set<Integer> caseSet;
        int number;

        public CaseSet(int number) {
            caseSet = new HashSet<>();
            this.number = number;
        }

        void add(int i) {
            caseSet.add(i);
        }

        boolean finish() {
            return caseSet.contains(number);
        }
    }
}
