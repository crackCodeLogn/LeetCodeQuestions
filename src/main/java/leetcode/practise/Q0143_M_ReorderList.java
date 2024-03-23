package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-03-23
 */
public class Q0143_M_ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println("xxxxxxxxxxxxxxxxx");
        display(head);
        Q0143_M_ReorderList q0143MReorderList = new Q0143_M_ReorderList();
        q0143MReorderList.reorderList(head);
        display(head);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("xxxxxxxxxxxxxxxxx");
        display(head);
        q0143MReorderList.reorderList(head);
        display(head);

        head.next = null;
        System.out.println("xxxxxxxxxxxxxxxxx");
        display(head);
        q0143MReorderList.reorderList(head);
        display(head);
    }

    private static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public void reorderList(ListNode head) { //4ms
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head, slow = head, fast = head;
        int n = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            n++;
        }
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
            n++;
        }
        boolean odd = n % 2 == 1;
        while (true) {
            ListNode next = current.next;
            if (stack.size() == (odd ? 1 : 0)) {
                current.next = null;
                break;
            }
            current.next = stack.pop();
            current = current.next;
            current.next = next;

            current = current.next;
        }
    }

    public void reorderList2(ListNode head) { //4ms

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        int n = 0;
        while (current != null) {
            stack.push(current);
            current = current.next;
            n++;
        }
        current = head;
        int mid = ((n & 1) == 1) ? n / 2 + 1 : n / 2;
        while (n >= mid) {
            ListNode next = current.next;
            if (n == mid) {
                current.next = null;
                break;
            }
            current.next = stack.pop();
            current = current.next;
            current.next = next;

            current = current.next;
            n--;
        }
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
