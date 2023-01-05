package leetcode.practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-01-05
 */
public class Q0452_M_MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        Q0452_M_MinimumNumberOfArrowsToBurstBalloons q0452MMinimumNumberOfArrowsToBurstBalloons = new Q0452_M_MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(q0452MMinimumNumberOfArrowsToBurstBalloons.findMinArrowShots(new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        }));
        System.out.println(q0452MMinimumNumberOfArrowsToBurstBalloons.findMinArrowShots(new int[][]{
                {1, 2}, {3, 4}, {5, 6}, {7, 8}
        }));
        System.out.println(q0452MMinimumNumberOfArrowsToBurstBalloons.findMinArrowShots(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {4, 5}
        }));
        System.out.println(q0452MMinimumNumberOfArrowsToBurstBalloons.findMinArrowShots(new int[][]{
                {3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}
        }));
    }

    public int findMinArrowShots(int[][] points) {
        List<Node> data = new ArrayList<>(points.length);
        for (int i = 0; i < points.length; i++) data.add(generateNode(points[i][0], points[i][1]));
        data.sort(Comparator.comparingLong(Node::getStart));
        //System.out.println(data);

        int arrows = 0;
        for (int i = 0; i < data.size(); ) {
            long ref = data.get(i).getEnd();
            int j = i + 1;
            for (; j < data.size() && ref >= data.get(j).getStart(); j++) {
                if (data.get(j).getEnd() < ref) {
                    ref = data.get(j).getEnd(); //this is the most important check to be done
                }
            }
            arrows++;
            i = j;
        }
        return arrows;
    }

    private Node generateNode(long start, long end) {
        return new Node(start, end);
    }

    private static class Node {
        private final long start;
        private final long end;

        public Node(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }
    }
}