package leetcode.practise;

import java.util.Map;

/**
 * @author Vivek
 * @updated 2024-02-11
 * @since 2023-10-22
 */
public class Q0169_E_MajorityElement {

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q0169_E_MajorityElement majorityElement = new Q0169_E_MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); //2
        System.out.println(majorityElement.majorityElement(new int[]{3, 2, 3})); //3
    }

    public int majorityElement(int[] nums) {
        int data = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) data = nums[i];
            count += nums[i] == data ? 1 : -1;
        }
        return data;
    }

    private static class Node {
        private final int n;
        private int count;

        public Node(int n) {
            this.n = n;
            this.count = 0;
        }

        public void increaseCount() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
