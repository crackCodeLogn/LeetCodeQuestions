package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @updated 27/12/23
 * @since 16/10/22
 */
public class Q1531_H_StringCompression2 {

    private int[][] data;
    private int n;
    private String input;

    public static void main(String[] args) {
        Q1531_H_StringCompression2 object = new Q1531_H_StringCompression2();
        //System.out.println(object.getLengthOfOptimalCompression("aaabcccd", 2));
        System.out.println(object.getLengthOfOptimalCompression("aaabaaa", 2));
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        input = s;
        n = s.length();

        data = new int[n][k + 1];
        for (int i = 0; i < n; i++) Arrays.fill(data[i], -1);
        return compute(0, k);
    }

    private int compute(int i, int k) {
        if (k < 0) return n;
        if (n <= i + k) return 0;

        int stored = data[i][k];
        if (stored != -1) return stored;

        stored = compute(i + 1, k - 1); // selecting the index i char
        int runningLength = 0;
        int conseq = 0;
        int diff = 0;

        for (int j = i; j < n && diff <= k; j++) {
            if (input.charAt(j) == input.charAt(i)) {
                conseq++;
                if (conseq <= 2 || conseq == 10 || conseq == 100) runningLength++;
            } else {
                diff++;
            }
            stored = Math.min(stored,
                    runningLength + compute(j + 1, k - diff));
        }
        data[i][k] = stored;
        return data[i][k];
    }

    public int getLengthOfOptimalCompression2(String s, int k) {
        PriorityQueue<Node> data = getCompressed(s);
        List<Node> sequence = new ArrayList<>(data.size());
        for (int i = 0; i < data.size(); i++) sequence.add(null); //dry init
        for (Node node : data) sequence.set(node.getOrder(), node); //setting up
        int length = getLength(sequence);

        while (k-- > 0 && !data.isEmpty()) {
            Node removed = data.poll();
            int v1 = removed.getSize();
            if (removed.decrementCountAndSurvive()) {
                int v2 = removed.getSize();
                length -= v1 - v2;
                data.offer(removed);
            } else {
                int location = sequence.indexOf(removed);
                int v3 = sequence.size();
                sequence.remove(removed);
                length -= v1;
                if (location > 0 && location != v3 - 1) {
                    //check for combining capability
                    Node n1 = sequence.get(location - 1), n2 = sequence.get(location);
                    if (n1.getCh() == n2.getCh()) {
                        // merge
                        n1.setCount(n1.getCount() + n2.getCount());
                        sequence.remove(n2);
                        data.remove(n2);
                        length -= n2.getSize();
                        n2 = null;
                    }
                }
            }
        }
        System.out.println(sequence);
        return length;
    }

    private int getLength(List<Node> d) {
        int length = 0;
        for (Node node : d) length += node.getSize();
        return length;
    }

    private PriorityQueue<Node> getCompressed(String s) {
        char last = s.charAt(0);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int runLength = 1, order = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                runLength++;
            } else {
                queue.offer(new Node(last, order++, runLength));
                last = s.charAt(i);
                runLength = 1;
            }
        }
        if (runLength > 1) {
            queue.offer(new Node(last, order++, runLength));
        }
        return queue;
    }

    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int order;
        private int count;

        public Node(char ch, int order, int count) {
            this.ch = ch;
            this.order = order;
            this.count = count;
        }

        public boolean decrementCountAndSurvive() {
            count--;
            return count > 0;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getOrder() {
            return order;
        }

        private boolean doesSizeDecrease() {
            return String.valueOf(count - 1).length() < String.valueOf(count).length();
        }

        public int getSize() {
            return 1 + (count == 1 ? 0 : String.valueOf(count).length());
        }

        public char getCh() {
            return ch;
        }

        @Override
        public String toString() {
            return ch + ":" + count + "=" + order;
        }

        @Override
        public int compareTo(Node o) {
            if (count == o.count) return 0;
            if (count == 1) return -1;
            if (o.count == 1) return +1;
            if (doesSizeDecrease()) return -1;
            if (o.doesSizeDecrease()) return +1;
            return 0;
        }
    }
}