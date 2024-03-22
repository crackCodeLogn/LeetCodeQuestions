package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-22
 */
public class Q0234_E_PalindromeLinkedList {

    public static void main(String[] args) {
        Q0234_E_PalindromeLinkedList q0234MPalindromeLinkedList = new Q0234_E_PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(q0234MPalindromeLinkedList.isPalindrome(head));
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(q0234MPalindromeLinkedList.isPalindrome(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(q0234MPalindromeLinkedList.isPalindrome(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        System.out.println(q0234MPalindromeLinkedList.isPalindrome(head));

        head = new ListNode(1);
        System.out.println(q0234MPalindromeLinkedList.isPalindrome(head));

    }

    public boolean isPalindrome(ListNode head) { // 3ms
        if (head.next == null) return true;

        ListNode slow = head, fast = head, prev = head;
        while (fast != null) {
            if (fast.next == null) {
                slow = slow.next;
                break;
            }
            fast = fast.next.next;

            if (slow != head) {
                ListNode next = slow.next;
                slow.next = prev;
                prev = slow;
                slow = next;
            } else {
                prev = slow;
                slow = slow.next;
                prev.next = null;
            }
        }
        while (prev != null) {
            if (prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }

    private static class ListNode {
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
