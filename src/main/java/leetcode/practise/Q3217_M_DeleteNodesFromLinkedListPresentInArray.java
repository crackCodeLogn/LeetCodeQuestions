package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 11/1/25
 */
public class Q3217_M_DeleteNodesFromLinkedListPresentInArray {

  public ListNode modifiedList(int[] nums, ListNode head) { // 21ms, beats 47.02%
    Set<Integer> data = new HashSet<>();
    for (int n : nums) data.add(n);

    ListNode current = head, prev = null;
    while (current != null) {
      if (data.contains(current.val)) {
        if (prev == null) head = current.next;
        else prev.next = current.next;
      } else prev = current;
      current = current.next;
    }
    return head;
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
