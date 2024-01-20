package leetcode.practise;

import java.util.ArrayList;

/**
 * @author Vivek
 * @since 2024-01-21
 */
public class Q0907_M_SumOfSubarrayMinimums {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Q0907_M_SumOfSubarrayMinimums q0907MSumOfSubarrayMinimums = new Q0907_M_SumOfSubarrayMinimums();
        System.out.println(q0907MSumOfSubarrayMinimums.sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] data = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) right[i] = i;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 1; i < n; i++) {
            int current = arr[i];
            while (!list.isEmpty() && current < arr[list.get(list.size() - 1)]) {
                int index = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                right[index] = i;
            }
            list.add(i);
        }

        data[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int lastIndex = right[i];
            if (lastIndex == i) {
                int curr = (n - i) * arr[i];
                data[i] = curr;
            } else {
                int upto_small = (lastIndex - i) * arr[i];
                int curr_sum = upto_small + data[lastIndex];
                data[i] = curr_sum;
            }
        }
        int sum = 0;
        for (int datum : data) sum = (sum + datum) % MOD;
        return sum;
    }

    public int sumSubarrayMins2(int[] arr) { //brute force
        int sum = 0, n = arr.length, m = Integer.MAX_VALUE;
        int[] data = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            m = Math.min(m, data[i]);
            data[i] = m;
        }
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % MOD;
            }
        }

        return sum;
    }
}
