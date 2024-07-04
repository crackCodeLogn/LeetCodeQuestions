package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-07-04
 */
public class Q2181_M_MergeNodesInBetweenZeros {

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
    }

    public static void main(String[] args) {
        Q2181_M_MergeNodesInBetweenZeros q2181MMergeNodesInBetweenZeros = new Q2181_M_MergeNodesInBetweenZeros();
        ListNode head = generateTest(new int[]{0, 3, 1, 0, 4, 5, 2, 0});
        display(q2181MMergeNodesInBetweenZeros.mergeNodes(head));
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode prev = head, current = head.next;
        int sum = 0;
        while (current.next.next != null) {
            if (current.val == 0) { // action
                prev.val = sum;
                prev.next = current;
                prev = current;
                sum = 0;
            } else {
                sum += current.val;
            }
            current = current.next;
        }
        prev.val = sum + current.val;
        prev.next = null;
        return head;
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
