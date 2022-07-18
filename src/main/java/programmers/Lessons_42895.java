package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895?language=java
 * 코딩테스트 연습 > 동적계획법 > N으로 표현
 **/

public class Lessons_42895 {
    public int solution(int N, int number) {
        int answer = -1;
        List<CaseSet> caseSets = new ArrayList<>();

        for (int count = 1; count < 9; count ++) {
            CaseSet caseSet = new CaseSet(number);
            boolean flag = concatAsString(N, count, caseSet);
            if (flag) {
                answer = count;
                break;
            }

            for (int i = 0; i < (caseSets.size() + 1)/ 2; i ++) {
                if (pickXY(caseSets.get(caseSets.size() - i - 1), caseSets.get(i), caseSet)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                answer = count;
                break;
            }

            caseSets.add(caseSet);
        }
        return answer;
    }

    public boolean pickXY(CaseSet caseSet1, CaseSet caseSet2, CaseSet caseSet3) {
        for (Integer x : caseSet1.caseSet) {
            for (Integer y : caseSet2.caseSet) {
                if (operation(x, y, caseSet3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean concatAsString(int N, int count, CaseSet caseSet) {
        int result = 0;
        for (int i = 0; i < count; i ++) {
            result = result + (int) (N * Math.pow(10, i));
        }
        return caseSet.addAndCompare(result);
    }

    public boolean operation(int x, int y, CaseSet caseSet) {
        boolean result = caseSet.addAndCompare(x + y);
        result = result || caseSet.addAndCompare(x * y);
        result = result || caseSet.addAndCompare(x - y);
        result = result || caseSet.addAndCompare(y - x);
        if (x != 0) {
            result = result || caseSet.addAndCompare(y / x);
        }
        if (y != 0) {
            result = result || caseSet.addAndCompare(x / y);
        }
        return result;
    }

    public static class CaseSet {
        List<Integer> caseSet;
        int number;

        public CaseSet(int number) {
            caseSet = new ArrayList<>();
            this.number = number;
        }

        boolean addAndCompare(int i) {
            caseSet.add(i);
            return i == number;
        }
    }
}
