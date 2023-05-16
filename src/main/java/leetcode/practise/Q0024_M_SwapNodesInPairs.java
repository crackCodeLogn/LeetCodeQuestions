package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-05-16
 */
public class Q0024_M_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        int n = 0;
        ListNode h2 = head;
        while (h2 != null) {
            n++;
            h2 = h2.next;
        }
        if (n <= 1) return head;
        ListNode prev = head, curr = head.next;
        ListNode next = curr.next;
        curr.next = prev;
        prev.next = next;
        head = curr;
        curr = prev;
        while (curr.next != null && curr.next.next != null) {
            prev = curr.next;
            curr.next = prev.next;
            curr = prev.next;
            next = curr.next;
            curr.next = prev;
            prev.next = next;
            curr = prev;
        }
        return head;
    }

    public class ListNode {
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
