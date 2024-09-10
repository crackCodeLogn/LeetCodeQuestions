package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-09-09
 */
public class Q2807_M_InsertGreatestCommonDivisorsInLinkedList {

  private static int getGcd(int a, int b) {
    if (a == 0) return b;
    return getGcd(b % a, a);
  }

  public ListNode insertGreatestCommonDivisors(ListNode head) {
    if (head.next == null) return head;

    ListNode prev = head, current = head.next;
    while (current != null) {
      int gcd = getGcd(prev.val, current.val);
      ListNode node = new ListNode(gcd);
      prev.next = node;
      node.next = current;
      prev = current;
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
