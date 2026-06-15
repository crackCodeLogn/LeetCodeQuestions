package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-06-14
 */
public class Q2095_M_DeleteTheMiddleNodeOfALinkedList {
  public ListNode deleteMiddle(ListNode head) {
    if (head.next == null) return null;

    ListNode prev = null, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = prev.next.next;
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
      final StringBuilder sb = new StringBuilder("ListNode{");
      sb.append("val=").append(val);
      sb.append('}');
      return sb.toString();
    }
  }
}
