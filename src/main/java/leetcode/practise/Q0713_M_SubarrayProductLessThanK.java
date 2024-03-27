package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-27
 */
public class Q0713_M_SubarrayProductLessThanK {

    public static void main(String[] args) {
        Q0713_M_SubarrayProductLessThanK q0713MSubarrayProductLessThanK = new Q0713_M_SubarrayProductLessThanK();
        System.out.println(q0713MSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100)); // 8
        System.out.println(q0713MSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0)); // 0
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) { // 6ms
        long product = 1;
        int n = nums.length, cnt = 0, length = 0, i = 0;
        for (int j = i; j < n; j++) { // window
            if (product * nums[j] >= k) {
                cnt += length * (length + 1) / 2;

                length++;
                product *= nums[j];
                while (length > 0 && i <= j && product >= k) {
                    product /= nums[i++];
                    length--;
                }
                if (i < j) cnt -= (j - i) * (j - i + 1) / 2;
            } else {
                product *= nums[j];
                length++;
            }
        }

        if (length > 0) cnt += length * (length + 1) / 2;
        return cnt;
    }
}
