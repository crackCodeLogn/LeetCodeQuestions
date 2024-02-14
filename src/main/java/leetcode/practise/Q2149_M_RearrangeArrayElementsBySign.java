package leetcode.practise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-02-14
 */
public class Q2149_M_RearrangeArrayElementsBySign {

    private static void printArray(int[] data) {
        for (int t : data) System.out.print(t + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Q2149_M_RearrangeArrayElementsBySign q2149MRearrangeArrayElementsBySign = new Q2149_M_RearrangeArrayElementsBySign();
        int[] result;
        result = q2149MRearrangeArrayElementsBySign.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4});
        printArray(result);
        result = q2149MRearrangeArrayElementsBySign.rearrangeArray(new int[]{-1, 1});
        printArray(result);
    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] data = new int[n];
        int i = 0, j = 1;
        for (int k = 0; k < n; k++) {
            if (nums[k] > 0) {
                data[i] = nums[k];
                i += 2;
            } else {
                data[j] = nums[k];
                j += 2;
            }
        }
        return data;
    }

    public int[] rearrangeArray2(int[] nums) {
        int n = nums.length;
        int[] data = new int[n];
        Queue<Integer> positives = new LinkedList<>();
        Queue<Integer> negatives = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) positives.add(nums[i]);
            else negatives.add(nums[i]);
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            data[i] = flag ? positives.poll() : negatives.poll();
            flag = !flag;
        }
        return data;
    }
}
