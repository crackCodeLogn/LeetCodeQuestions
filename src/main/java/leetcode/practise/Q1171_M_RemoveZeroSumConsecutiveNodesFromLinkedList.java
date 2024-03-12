package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-12
 */
public class Q1171_M_RemoveZeroSumConsecutiveNodesFromLinkedList {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(-3);
//        head.next.next.next.next = new ListNode(4);
        ListNode head = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(-1);
        head.next.next.next.next.next = new ListNode(-1);

        Q1171_M_RemoveZeroSumConsecutiveNodesFromLinkedList q1171MRemoveZeroSumConsecutiveNodesFromLinkedList = new Q1171_M_RemoveZeroSumConsecutiveNodesFromLinkedList();

        ListNode result;
        result = q1171MRemoveZeroSumConsecutiveNodesFromLinkedList.removeZeroSumSublists(head);
        System.out.println(result);
    }

    public ListNode removeZeroSumSublists(ListNode head) { // 3ms, beats 54% -- think about improvement #IMPROVE
        ListNode current = head;
        int cnt = 0;
        while (current != null) {
            if (current.val != 0) cnt++;
            current = current.next;
        }
        if (cnt == 0) return null;

        current = head;
        int[] data = new int[cnt];
        int i = 0;
        int negatives = 0;
        while (current != null) {
            if (current.val != 0) data[i++] = current.val;
            if (current.val < 0) negatives++;
            current = current.next;
        }

        if (negatives == 0) return createList(data);
        i = 0;

        while (i < data.length) {
            int startI = i;

            int sum = data[i];
            boolean flag = false;
            for (int j = i + 1; j < data.length; j++) {
                sum += data[j];
                if (sum == 0) {
                    int[] data2 = new int[data.length - (j - i + 1)];
                    int k = 0;
                    for (; k < i; k++) data2[k] = data[k];
                    for (int v = j + 1; v < data.length; v++) data2[k++] = data[v];
                    negatives--;
                    data = data2;
                    i = startI;
                    flag = true;
                    break;
                }
            }
            if (!flag) i++;
        }

        return createList(data);
    }

    private ListNode createList(int[] data) {
        ListNode head = null, current = head;
        for (int i = 0; i < data.length; i++) {
            ListNode node = new ListNode(data[i]);
            if (head == null) {
                head = node;
                current = node;
                continue;
            }
            current.next = new ListNode(data[i]);
            current = current.next;
        }
        return head;
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
