package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-07-23
 */
public class Q1636_E_SortArrayByIncreasingFrequency {

    public static void main(String[] args) {
        Q1636_E_SortArrayByIncreasingFrequency q1636ESortArrayByIncreasingFrequency = new Q1636_E_SortArrayByIncreasingFrequency();
        System.out.println(Arrays.toString(q1636ESortArrayByIncreasingFrequency.frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(q1636ESortArrayByIncreasingFrequency.frequencySort(new int[]{2, 3, 1, 3, 2})));
        System.out.println(Arrays.toString(q1636ESortArrayByIncreasingFrequency.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        List<Node> list = new ArrayList<>(n);
        Arrays.stream(nums).forEach(num -> {
            Integer index = map.get(num);
            if (index == null) {
                list.add(new Node(num));
                map.put(num, list.size() - 1);
            } else {
                list.get(map.get(num)).increment();
            }
        });
        Collections.sort(list);
        int k = -1;
        Node node = null;
        for (int i = 0; i < n; i++) {
            if (node == null || node.cnt == 0) node = list.get(++k);
            if (node.cnt > 0) nums[i] = node.val;
            node.decrement();
        }
        return nums;
    }

    private static final class Node implements Comparable<Node> {
        int val;
        int cnt;

        public Node(int val) {
            this(val, 1);
        }

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        public void increment() {
            this.cnt++;
        }

        public void decrement() {
            this.cnt--;
        }

        @Override
        public String toString() {
            String sb = "Node{" + "val=" + val +
                    ", cnt=" + cnt +
                    '}';
            return sb;
        }

        @Override
        public int compareTo(Node o) {
            if (o.cnt < this.cnt) return 1;
            else if (o.cnt > this.cnt) return -1;
            return o.val - val;
        }
    }
}
