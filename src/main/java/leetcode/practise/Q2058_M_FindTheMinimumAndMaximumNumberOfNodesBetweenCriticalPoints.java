package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-07-05
 */
public class Q2058_M_FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    private static ListNode generateTest(int[] data) {
        ListNode head = new ListNode(data[0]), current = head;

        for (int i = 1; i < data.length; i++) {
            current.next = new ListNode(data[i]);
            current = current.next;
        }
        return head;
    }

    private static void display(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q2058_M_FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints q2058MFindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints = new Q2058_M_FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints();
//        ListNode head = generateTest(new int[]{5, 3, 1, 2, 5, 1, 2});
        ListNode head = generateTest(new int[]{2, 3, 3, 2});
        System.out.println(Arrays.toString(q2058MFindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.nodesBetweenCriticalPoints(head)));
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) { // 6ms
        int count = 2, minDistance = Integer.MAX_VALUE, lastPeakPosition = -1, firstPeakPosition = -1;
        int peaks = 0;
        ListNode current = head.next, prev = head.next, prevPrev = head;
        if (current.next == null) return new int[]{-1, -1};
        current = current.next;

        while (current != null) {
            if (isPeak(prevPrev, prev, current)) {
                peaks++;
                if (lastPeakPosition == -1) {
                    lastPeakPosition = count;
                    firstPeakPosition = count;
                } else {
                    minDistance = Math.min(minDistance, count - lastPeakPosition);
                    lastPeakPosition = count;
                }
            }
            count++;
            prevPrev = prev;
            prev = current;
            current = current.next;
        }
        if (peaks == 1) return new int[]{-1, -1};
        return new int[]{minDistance == Integer.MAX_VALUE ? -1 : minDistance,
                (lastPeakPosition - firstPeakPosition) == 0 ? -1 : lastPeakPosition - firstPeakPosition};
    }

    private boolean isPeak(ListNode prevPrev, ListNode prev, ListNode current) {
        return (prev.val > prevPrev.val && prev.val > current.val) ||
                (prev.val < prevPrev.val && prev.val < current.val);
    }

    private static final class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            String sb = "ListNode{" + "val=" + val +
                    '}';
            return sb;
        }
    }
}
