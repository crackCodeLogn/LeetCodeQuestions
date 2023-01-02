package leetcode.practise;

/**
 * @author Vivek
 * @since 16/10/22
 */
public class Q21_E_Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(), header = result;
        while (list1 != null && list2 != null) {
            while (list1 != null && list2 != null && list1.val <= list2.val) {
                ListNode node = new ListNode(list1.val);
                result.next = node;
                result = result.next;
                list1 = list1.next;
            }
            while (list2 != null && list1 != null && list2.val <= list1.val) {
                ListNode node = new ListNode(list2.val);
                result.next = node;
                result = result.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            ListNode node = new ListNode(list1.val);
            result.next = node;
            result = result.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            ListNode node = new ListNode(list2.val);
            result.next = node;
            result = result.next;
            list2 = list2.next;
        }
        return header.next;
    }

    public class ListNode {
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
