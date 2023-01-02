package leetcode.practise;

/**
 * @author Vivek
 * @since 24/10/22
 */
public class Q0203_E_RemoveLinkedListElement {

    public Q0021_E_MergeTwoSortedLists.ListNode removeElements(Q0021_E_MergeTwoSortedLists.ListNode head, int val) {
        Q0021_E_MergeTwoSortedLists.ListNode header = head, last = head;
        if (head == null) return head;

        while (head != null && head.val == val) {
            //System.out.println(head.val);
            head = head.next;
        }
        header = head;

        while (head != null) {
            if (head.val == val) {
                last.next = head.next;
            } else last = head;
            head = head.next;
        }

        return header;
    }
}