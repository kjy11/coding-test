package programmers;


import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * 코딩테스트 연습 > 힙(Heap) > 이중우선순위큐
 * */
public class Lessons_42628 {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String operation : operations) {
            String[] arr = operation.split(" ");
            String opString = arr[0];
            int opInt = Integer.parseInt(arr[1]);

            if (opString.equals("I")) {
                if (map.containsKey(opInt)) {
                    map.put(opInt, map.get(opInt) + 1);
                } else {
                    map.put(opInt, 1);
                }
                continue;
            }

            if (opString.equals("D") && map.isEmpty()) {
                continue;
            }

            Integer key = null;
            if (opString.equals("D") && opInt == 1) {
                key = map.lastKey();
            }
            if (opString.equals("D") && opInt == -1) {
                key = map.firstKey();
            }
            if (key != null) {
                Integer count = map.put(key, map.get(key) - 1);
                if (count != null && count == 1) {
                    map.remove(key);
                }
            }
        }
        if (!map.isEmpty()) {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        return answer;
    }

    public int[] solution1(String[] operations) {
        int[] answer = {0, 0};
        Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> queueReverse = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            String[] arr = operation.split(" ");
            String opString = arr[0];
            int opInt = Integer.parseInt(arr[1]);

            if (opString.equals("I")) {
                queue.add(opInt);
                queueReverse.add(opInt);
                continue;
            }

            if (opString.equals("D") && queue.isEmpty()) {
                continue;
            }

            if (opString.equals("D") && opInt == 1) {
                int max = queueReverse.remove();
                queue.remove(max);
                continue;
            }

            if (opString.equals("D") && opInt == -1) {
                int min = queue.remove();
                queueReverse.remove(min);
            }
        }
        if (!queue.isEmpty()) {
            answer[0] = queueReverse.remove();
            answer[1] = queue.remove();
        }
        return answer;
    }
}
