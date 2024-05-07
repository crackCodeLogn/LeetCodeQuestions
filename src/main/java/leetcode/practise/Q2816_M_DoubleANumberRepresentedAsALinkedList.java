package leetcode.practise;

public class Q2816_M_DoubleANumberRepresentedAsALinkedList {

    private ListNode head;

    public ListNode doubleIt(ListNode head) { // 4ms
        this.head = head;
        compute(null, head);
        return this.head;
    }

    private int compute(ListNode prev, ListNode current) {
        if (current == null) return 0;

        int val = compute(current, current.next);
        current.val = current.val * 2 + val;
        val = current.val / 10;
        current.val %= 10;
        if (prev == null && val > 0) {
            ListNode node = new ListNode(val);
            node.next = current;
            this.head = node;
        }
        return val;
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
    }
}
