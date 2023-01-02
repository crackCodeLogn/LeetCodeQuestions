package leetcode.practise;

/**
 * @author Vivek
 * @since 24/10/22
 */
public class Q203_E_Remove_Linked_List_Element {

    public Q21_E_Merge_Two_Sorted_Lists.ListNode removeElements(Q21_E_Merge_Two_Sorted_Lists.ListNode head, int val) {
        Q21_E_Merge_Two_Sorted_Lists.ListNode header = head, last = head;
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