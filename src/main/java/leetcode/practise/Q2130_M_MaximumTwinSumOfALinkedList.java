package leetcode.practise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Vivek
 * @since 2026-06-13
 */
public class Q2130_M_MaximumTwinSumOfALinkedList {

  public int pairSum(ListNode head) { // 5ms, beats 58.50%
    // reverse linked list post mid-point
    ListNode slow = head, fast = head, prev = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;
    slow = reverseList(slow);
    int sum = 0;
    while (head != null && slow != null) {
      sum = Math.max(sum, head.val + slow.val);
      slow = slow.next;
      head = head.next;
    }
    return sum;
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public int pairSum2(ListNode head) { // 32ms, beats 5.16%
    int sum = 0;
    Queue<Integer> queue = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    while (head != null) {
      queue.offer(head.val);
      stack.push(head.val);
      head = head.next;
    }
    int n = stack.size();
    for (int i = 1; i <= n / 2; i++) sum = Math.max(sum, queue.poll() + stack.pop());
    return sum;
  }

  private static final class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("ListNode{");
      sb.append("val=").append(val);
      sb.append('}');
      return sb.toString();
    }
  }
}
