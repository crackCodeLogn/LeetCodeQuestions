package leetcode.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q2285_M_MaximumTotalImportanceOfRoads {

    public static void main(String[] args) {
        Q2285_M_MaximumTotalImportanceOfRoads q2285MMaximumTotalImportanceOfRoads = new Q2285_M_MaximumTotalImportanceOfRoads();
        System.out.println(q2285MMaximumTotalImportanceOfRoads.maximumImportance(5, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}
        }));
        System.out.println(q2285MMaximumTotalImportanceOfRoads.maximumImportance(5, new int[][]{
                {0, 3}, {2, 4}, {1, 3}
        }));
    }

    public long maximumImportance(int n, int[][] roads) {
        Node[] nodes = new Node[n];
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
            map.put(i, nodes[i]);
        }

        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0], dest = roads[i][1];
            nodes[src].degree++;
            nodes[dest].degree++;
        }
//        System.out.println(nodes);
        //nodes.sort(Collections.reverseOrder());
        Arrays.sort(nodes, Comparator.reverseOrder());
//        System.out.println(nodes);
        for (int i = 0, rank = n; i < nodes.length; i++, rank--) nodes[i].setRank(rank);
        long sum = 0;
        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0], dest = roads[i][1];
            sum += map.get(src).rank + map.get(dest).rank;
        }
        return sum;
    }

    private static final class Node implements Comparable<Node> {
        int node;
        int degree = 0;
        int rank = 0;

        public Node(int node) {
            this.node = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", degree=" + degree +
                    '}';
        }

        public int getNode() {
            return node;
        }

        public int getDegree() {
            return degree;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        @Override
        public int compareTo(Node o) {
            return degree - o.degree;
        }

//        @Override
//        public int compare(Node o1, Node o2) {
//            return o1.degree - o2.degree;
//        }
    }
}
