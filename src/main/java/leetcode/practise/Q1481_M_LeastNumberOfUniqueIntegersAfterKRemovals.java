package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-02-16
 */
public class Q1481_M_LeastNumberOfUniqueIntegersAfterKRemovals {

    public static void main(String[] args) {
        Q1481_M_LeastNumberOfUniqueIntegersAfterKRemovals q1481MLeastNumberOfUniqueIntegersAfterKRemovals = new Q1481_M_LeastNumberOfUniqueIntegersAfterKRemovals();
        System.out.println(q1481MLeastNumberOfUniqueIntegersAfterKRemovals.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1)); // 1
        System.out.println(q1481MLeastNumberOfUniqueIntegersAfterKRemovals.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3)); // 2
        System.out.println(q1481MLeastNumberOfUniqueIntegersAfterKRemovals.findLeastNumOfUniqueInts(new int[]{2, 4, 1, 8, 3, 5, 1, 3}, 3)); // 3
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Node> map = new HashMap<>();
        int n = arr.length;
        List<Node> data = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) map.get(arr[i]).bump();
            else {
                Node node = new Node();
                data.add(node);
                map.put(arr[i], node);
            }
        }
        data.sort(Comparator.comparingInt(Node::getCount));
        // System.out.println(data);
        int i = 0;
        while (k-- > 0) {
            if (data.get(i).getCount() == 0) i++;
            data.get(i).reduce();
        }
        return data.size() - i - (data.get(i).getCount() > 0 ? 0 : 1);
    }

    private static class Node {
        private int count;

        public Node() {
            count = 1;
        }

        public void reduce() {
            count--;
        }

        public void bump() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return count + "";
        }
    }
}
