package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92343
 * 코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT > 양과 늑대
 * */
public class Lessons_92343 {
    private int answer = 0;
    public int solution(int[] info, int[][] edges) {
        Node[] arr = new Node[info.length];
        for (int i = 0; i < info.length; i ++) {
            arr[i] = new Node(i, info[i]);
        }
        for (int[] edge : edges) {
            arr[edge[0]].nextNodes.add(arr[edge[1]]);
        }
        List<Node> queue = new ArrayList<>(arr[0].nextNodes);
        move(queue, 1, 0);
        return answer;
    }

    private void move(List<Node> queue, int sheepCount, int wolfCount) {
        if (sheepCount <= wolfCount) {
            if (answer < sheepCount) {
                answer = sheepCount;
            }
            return;
        }
        List<Node> queueCopy = new ArrayList<>(queue);
        for (Node next : queue) {
            queueCopy.remove(next);
            queueCopy.addAll(next.nextNodes);
            move(queueCopy, sheepCount + (next.info ^ 1), wolfCount + next.info);
            queueCopy.removeAll(next.nextNodes);
            queueCopy.add(next);
        }
        if (answer < sheepCount) {
            answer = sheepCount;
        }
    }

    private static class Node {
        final int node;
        final int info;
        final List<Node> nextNodes;

        Node(int node, int info) {
            this.node = node;
            this.info = info;
            nextNodes = new ArrayList<>();
        }
    }
}
