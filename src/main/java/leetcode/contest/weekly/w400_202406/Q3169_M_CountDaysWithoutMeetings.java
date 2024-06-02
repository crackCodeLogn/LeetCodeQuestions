package leetcode.contest.weekly.w400_202406;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-06-02
 */
public class Q3169_M_CountDaysWithoutMeetings {

    public static void main(String[] args) {
        Q3169_M_CountDaysWithoutMeetings q3169MCountDaysWithoutMeetings = new Q3169_M_CountDaysWithoutMeetings();
        System.out.println(q3169MCountDaysWithoutMeetings.countDays(10, new int[][]{
                {5, 7}, {1, 3}, {9, 10}
        }));
        System.out.println(q3169MCountDaysWithoutMeetings.countDays(5, new int[][]{
                {2, 4}, {1, 3}
        }));
        System.out.println(q3169MCountDaysWithoutMeetings.countDays(6, new int[][]{
                {1, 6}
        }));
        System.out.println(q3169MCountDaysWithoutMeetings.countDays(10, new int[][]{
                {1, 5}, {1, 3}, {9, 10}
        }));
    }

    public int countDays(int days, int[][] meetings) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < meetings.length; i++) nodes.add(new Node(meetings[i][0], meetings[i][1]));
        nodes.sort(Comparator.comparingInt(Node::getStart));

        List<Node> merged = new ArrayList<>();
        Node current = new Node(-1, -1);
        for (Node node : nodes) {
            if (current.getStart() == -1) {
                current.setStart(node.getStart());
                current.setEnd(node.getEnd());
            } else {
                if (node.getStart() <= current.getEnd()) {
                    current.setEnd(Math.max(node.getEnd(), current.getEnd()));
                } else {
                    merged.add(current);
                    current = new Node(node.getStart(), node.getEnd());
                }
            }
        }
        merged.add(current);

        int daysCount = merged.get(0).getStart() - 1; // starting delta
        int prev = merged.get(0).getEnd();
        int i;

        for (i = 1; i < merged.size(); i++) {
            Node node = merged.get(i);
            daysCount += node.getStart() - prev - 1;
            prev = node.getEnd();
        }
        i--;
        daysCount += days - merged.get(i).getEnd();

        return daysCount;
    }

    private static final class Node {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            String sb = "Node{" + "start=" + start +
                    ", end=" + end +
                    '}';
            return sb;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

}
