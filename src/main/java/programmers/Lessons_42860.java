package programmers;

import java.util.List;
import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * 코딩테스트 연습 > 탐욕법 > 조이스틱
 * */
public class Lessons_42860 {
    public int solution(String name) {
        char[] cArr = name.toCharArray();
        int answer = moveUpDown(cArr);
        answer += moveLeftRight(cArr);
        return answer;
    }

    private int moveUpDown(char[] cArr) {
        int result = 0;
        for (char c : cArr) {
            result += moveUpDown(c);
        }
        return result;
    }

    private int moveUpDown(char c) {
        if ((int) c - 'A' >= 13) {
            return 26 - c  + 'A';
        }
        return (int) c - 'A';
    }

    private int moveLeftRight(char[] cArr) {
        List<Integer> countList = getCountList(cArr);
        int result = cArr.length - 1;
        int preCount = 0;
        for (int i = 0; i < countList.size(); i ++) {
            int total;
            if (i % 2 == 0) {
                if (i == 0) {
                    total = cArr.length - countList.get(i);
                } else if (i == countList.size() - 1) {
                    total = preCount - 1;
                } else {
                    int rest = cArr.length - preCount - countList.get(i);
                    if (preCount - 1 < rest) {
                        total = 2 * preCount - 2 + rest;
                    } else {
                        total = 2 * rest - 1 + preCount;
                    }
                }
                if (result > total) {
                    result = total;
                }
            }
            preCount += countList.get(i);
        }
        return result;
    }

    private List<Integer> getCountList(char[] cArr) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        int nowCount = 0;

        for (char c : cArr) {
            if (c == 'A' && index % 2 == 0) {
                nowCount ++;
                continue;
            }
            if (c == 'A' && index % 2 == 1) {
                result.add(nowCount);
                nowCount = 1;
                index ++;
                continue;
            }
            if (c != 'A' && index % 2 == 0) {
                result.add(nowCount);
                nowCount = 1;
                index ++;
                continue;
            }
            if (c != 'A' && index % 2 == 1) {
                nowCount ++;
            }
        }
        result.add(nowCount);
        return result;
    }
}
