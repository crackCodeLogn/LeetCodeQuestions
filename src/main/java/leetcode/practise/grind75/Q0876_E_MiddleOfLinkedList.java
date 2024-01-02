package leetcode.practise.grind75;

/**
 * @author Vivek
 * @since 2023-12-29
 */
public class Q0876_E_MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;
        if (head.next.next == null) return head.next;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            //System.out.println(slow.val+" "+fast.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        return slow;
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
