package leetcode.contest.weekly.w406_202407;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-07-14
 */
public class Q3217_M_DeleteNodesFromLinkedListPresentInArray {

    private static ListNode generateList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    private static void traverse(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q3217_M_DeleteNodesFromLinkedListPresentInArray q3217MDeleteNodesFromLinkedListPresentInArray = new Q3217_M_DeleteNodesFromLinkedListPresentInArray();
        ListNode head = generateList(new int[]{1, 2, 3, 4, 5});
        traverse(head);
        ListNode node = q3217MDeleteNodesFromLinkedListPresentInArray.modifiedList(new int[]{1, 2, 3}, head);
        traverse(node);
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Arrays.sort(nums);

        ListNode current = head, prev = null;
        while (current != null) {
            if (Arrays.binarySearch(nums, current.val) > -1) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else
                prev = current;
            current = current.next;
        }
        return head;
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

        @Override
        public String toString() {
            String sb = "ListNode{" + "val=" + val +
                    '}';
            return sb;
        }
    }
}
