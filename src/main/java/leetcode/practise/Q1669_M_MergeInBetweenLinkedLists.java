package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-20
 */
public class Q1669_M_MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode node1 = list1, node2 = list2;
        while (node1 != null) {
            if (index + 1 == a) {
                ListNode currentNext = node1.next;
                node1.next = node2;
                while (node2.next != null) node2 = node2.next;
                node1 = currentNext;
                while (index++ != b) node1 = node1.next;
                node2.next = node1;
                return list1;
            }
            node1 = node1.next;
            index++;
        }
        return node1;
    }

    public static class ListNode {
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
