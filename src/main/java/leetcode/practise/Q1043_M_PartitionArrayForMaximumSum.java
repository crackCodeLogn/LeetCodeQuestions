package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-02-03
 */
public class Q1043_M_PartitionArrayForMaximumSum {

    public static void main(String[] args) {
        Q1043_M_PartitionArrayForMaximumSum q1043MPartitionArrayForMaximumSum = new Q1043_M_PartitionArrayForMaximumSum();
        System.out.println(q1043MPartitionArrayForMaximumSum.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)); // 84
        System.out.println(q1043MPartitionArrayForMaximumSum.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)); //83
        System.out.println(q1043MPartitionArrayForMaximumSum.maxSumAfterPartitioning(new int[]{1}, 1)); //1
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] data = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = i; j > Math.max(0, i - k); j--) {
                max = Math.max(max, arr[j - 1]);
                data[i] = Math.max(data[i], data[j - 1] + max * (i - j + 1));
            }
        }

        return data[n];
    }
}
