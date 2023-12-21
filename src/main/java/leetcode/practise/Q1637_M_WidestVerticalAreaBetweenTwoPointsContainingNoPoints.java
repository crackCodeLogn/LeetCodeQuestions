package leetcode.practise;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2023-12-21
 */
public class Q1637_M_WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public static void main(String[] args) {
        Q1637_M_WidestVerticalAreaBetweenTwoPointsContainingNoPoints q1637MWidestVerticalAreaBetweenTwoPointsContainingNoPoints = new Q1637_M_WidestVerticalAreaBetweenTwoPointsContainingNoPoints();
        System.out.println(q1637MWidestVerticalAreaBetweenTwoPointsContainingNoPoints.maxWidthOfVerticalArea(new int[][]{{8, 7}, {9, 9}, {7, 4}, {9, 7}}));
    }

    public int maxWidthOfVerticalArea2(int[][] points) {
        int n = points.length;
        TreeSet<Node> nodes = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(points[i][0], points[i][1]));
        }
        System.out.println(nodes);
        int last = -1, maxWidth = 0;
        for (Node node : nodes) {
            if (last == -1) {
                last = node.getX();
            }
            if (node.getX() - last > maxWidth) {
                maxWidth = node.getX() - last;
            }
            last = node.getX();
        }
        return maxWidth;
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = points[i][0];
        Arrays.sort(data);

        int last = -1, maxWidth = 0;
        for (int val : data) {
            if (last == -1) last = val;
            if (val - last > maxWidth) maxWidth = val - last;
            last = val;
        }
        return maxWidth;
    }

    private static class Node implements Comparable<Node> {
        private final int x;
        private final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            Node other = (Node) obj;
            return this.x == other.getX();
        }

        @Override
        public String toString() {
            return "" + x;
        }

        public int getX() {
            return x;
        }


        @Override
        public int compareTo(Node o) {
            return x - o.x;
        }
    }
}
