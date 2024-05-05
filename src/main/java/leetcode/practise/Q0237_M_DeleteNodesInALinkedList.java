package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-05-05
 */
public class Q0237_M_DeleteNodesInALinkedList {

    public void deleteNode(ListNode node) {
        ListNode current = node.next, prev = node;
        while (current.next != null) {
            prev.val = current.val;
            prev = current;
            current = current.next;
        }
        prev.val = current.val;
        prev.next = null;
    }


    private static final class ListNode {
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
