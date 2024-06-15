package leetcode.practise;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q0502_H_IPO {
    public static void main(String[] args) {
        Q0502_H_IPO q0502HIpo = new Q0502_H_IPO();
        System.out.println(q0502HIpo.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));// 4
        System.out.println(q0502HIpo.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));// 6
    }

    public int findMaximizedCapital(int k, int W, int[] profits, int[] capital) {
        Queue<Node> minHeap = new PriorityQueue<>((a, b) -> a.cap - b.cap);
        Queue<Node> maxHeap = new PriorityQueue<>((a, b) -> b.pro - a.pro);

        for (int i = 0; i < capital.length; i++) minHeap.offer(new Node(profits[i], capital[i]));

        while (k-- > 0) {
            while (!minHeap.isEmpty() && minHeap.peek().cap <= W) maxHeap.offer(minHeap.poll());
            if (maxHeap.isEmpty()) break;
            W += maxHeap.poll().pro;
        }

        return W;
    }

    private static final class Node {
        public int pro;
        public int cap;

        public Node(int pro, int cap) {
            this.pro = pro;
            this.cap = cap;
        }
    }
}
