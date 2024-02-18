package leetcode.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-02-18
 */
public class Q2402_H_MeetingRoomsIII {

    public static void main(String[] args) {
        Q2402_H_MeetingRoomsIII q2402HMeetingRoomsIII = new Q2402_H_MeetingRoomsIII();
        System.out.println(q2402HMeetingRoomsIII.mostBooked(2, new int[][]{
                {0, 10}, {1, 5}, {2, 7}, {3, 4}
        }));
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0])); // interesting new way for such details' comparison

        Queue<Node> occupied = new PriorityQueue<>((a, b) -> a.endTime == b.endTime
                ? Integer.compare(a.roomId, b.roomId)
                : Long.compare(a.endTime, b.endTime));
        Queue<Integer> availableRoomIds = new PriorityQueue<>();

        for (int i = 0; i < n; i++) availableRoomIds.offer(i);

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!occupied.isEmpty() && occupied.peek().endTime <= start)
                availableRoomIds.offer(occupied.poll().roomId);
            if (availableRoomIds.isEmpty()) {
                Node node = occupied.poll();
                count[node.roomId]++;
                occupied.offer(new Node(node.endTime + (end - start), node.roomId));
            } else {
                final int roomId = availableRoomIds.poll();
                count[roomId]++;
                occupied.offer(new Node(end, roomId));
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < n; i++) if (count[i] > count[maxIndex]) maxIndex = i;
        return maxIndex;
    }

    private static class Node {
        public long endTime;
        public int roomId;

        public Node(long endTime, int roomId) {
            this.endTime = endTime;
            this.roomId = roomId;
        }
    }
}