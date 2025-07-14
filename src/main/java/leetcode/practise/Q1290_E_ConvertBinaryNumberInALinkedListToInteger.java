package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 7/13/25
 */
public class Q1290_E_ConvertBinaryNumberInALinkedListToInteger {

  public int getDecimalValue(ListNode head) { // 0ms, beats 100%
    int num = 0;
    while (head != null) {
      num = num * 2 + head.val;
      head = head.next;
    }
    return num;
  }

  public int getDecimalValue2(ListNode head) { // 1ms, beats 12.29%
    int num = 0, k = 1;
    Stack<Integer> stack = new Stack<>();
    while (head != null) {
      stack.push(head.val);
      head = head.next;
    }
    while (!stack.isEmpty()) {
      num += stack.pop() * k;
      k <<= 1;
    }
    return num;
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
        String sb = "ListNode{" + "val=" + val +
                '}';
      return sb;
    }
  }
}
