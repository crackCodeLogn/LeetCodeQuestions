package leetcode.practise.blind75;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2023-12-26
 */
public class Q0206_E_ReverseLinkedList {

    //iteration way
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        ListNode newHead = stack.pop();
        node = newHead;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return newHead;
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
