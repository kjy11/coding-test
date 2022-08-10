package programmers;

/**
* 코딩테스트 연습 > 스택/큐 > 주식가격
* https://school.programmers.co.kr/learn/courses/30/lessons/42584
* */
public class Lessons_42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i ++) {
            for (int j = i + 1; j < prices.length; j ++) {
                answer[i] += 1;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
}
