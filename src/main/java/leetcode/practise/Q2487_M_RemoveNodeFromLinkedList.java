package leetcode.practise;

public class Q2487_M_RemoveNodeFromLinkedList {
    private ListNode head;

    public ListNode removeNodes(ListNode head) { // too slow, 26ms
        if (head == null) return head;

        this.head = head;
        compute(null, head);
        return this.head;
    }

    private int compute(ListNode prev, ListNode current) {
        if (current.next == null) return current.val;
        int val = compute(current, current.next);
        if (val < current.val) {
            if (prev != null) prev.next = current.next;
            else head = current.next;
        }
        return Math.max(val, current.val);
    }

    private static class Pair<T, K> {
        private final T first;
        private final K second;

        public Pair(T first, K second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public K getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            Pair<T, K> other = (Pair<T, K>) obj;
            return first == other.first && second == other.second;
        }

        @Override
        public String toString() {
            return String.format("%s %s", first, second);
        }
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
