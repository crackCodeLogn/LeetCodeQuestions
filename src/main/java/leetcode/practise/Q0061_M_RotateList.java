package leetcode.practise;


/**
 * @author Vivek
 * @since 2026-05-04
 */
public class Q0061_M_RotateList {
  private int k;
  private ListNode newHead;

  public static void main(String[] args) {
    Q0061_M_RotateList q0061MRotateList = new Q0061_M_RotateList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    q0061MRotateList.displayList(head);
    head = q0061MRotateList.rotateRight(head, 2);
    q0061MRotateList.displayList(head);

    head = new ListNode(0);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    q0061MRotateList.displayList(head);
    head = q0061MRotateList.rotateRight(head, 4);
    q0061MRotateList.displayList(head);
  }

  public ListNode rotateRight(ListNode head, int k) { // 0ms, beats 100%
    if (k == 0 || head == null) return head;
    ListNode prev, current = head;
    int n = 1;
    while (current.next != null) {
      n++;
      current = current.next;
    }
    k %= n;
    if (k == 0) return head;
    this.k = k;
    this.newHead = head;
    current.next = head; // cycle linking
    prev = current; // last node
    current = head;
    dig(prev, current, prev);
    return newHead;
  }

  private void dig(ListNode prev, ListNode current, ListNode target) {
    if (current != target) dig(current, current.next, target);
    k--;
    if (k == 0) {
      prev.next = null;
      newHead = current;
    }
  }

  private void displayList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
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
