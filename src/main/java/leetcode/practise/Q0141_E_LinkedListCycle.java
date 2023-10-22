package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-10-22
 */
public class Q0141_E_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode first = head, second = head.next;
        while (first != second) {
            first = first.next;
            if (second == null || second.next == null) return false;
            second = second.next.next;
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
