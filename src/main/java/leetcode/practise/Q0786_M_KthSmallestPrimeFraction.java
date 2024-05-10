package leetcode.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q0786_M_KthSmallestPrimeFraction {
    public static void main(String[] args) {
        Q0786_M_KthSmallestPrimeFraction q0786MKthSmallestPrimeFraction = new Q0786_M_KthSmallestPrimeFraction();
        System.out.println(Arrays.toString(q0786MKthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3))); // [2,5]
        System.out.println(Arrays.toString(q0786MKthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1, 7}, 1))); // [1,7]
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) { //643ms
        PriorityQueue<Node> queue = new PriorityQueue<Node>(Comparator.comparingDouble(Node::getValue));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                queue.add(new Node(arr[i], arr[j]));
            }
        }
        while (k-- > 1) queue.poll();
        Node v = queue.poll();
        return new int[]{v.getFirst(), v.getSecond()};
    }

    private static final class Node {
        private final int first, second;
        private final double value;

        private Node(int first, int second) {
            this.first = first;
            this.second = second;

            this.value = (1.0 * first) / second;
        }

        public double getValue() {
            return value;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}
