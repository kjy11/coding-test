package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * 코딩테스트 연습 > 스택/큐 > 다리를 지나는 트럭
 * */
public class Lessons_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<int[]> ingQueue = new ArrayDeque<>();
        int index = 0;
        int now = 1;
        int weightSum = 0;
        while (index < truck_weights.length) {
            if (!ingQueue.isEmpty() && ingQueue.peek()[1] == now - bridge_length) {
                int[] tmp = ingQueue.poll();
                weightSum -= tmp[0];
            }
            if (ingQueue.size() < bridge_length && weightSum + truck_weights[index] <= weight) {
                ingQueue.offer(new int[] {truck_weights[index], now});
                weightSum += truck_weights[index];
                index ++;
            }
            now ++;
        }
        if (!ingQueue.isEmpty()) {
            now = ingQueue.peekLast()[1] + bridge_length;
        }
        return now;
    }
}
