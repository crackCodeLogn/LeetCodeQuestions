package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-02-15
 */
public class Q2971_M_FindPolygonWithTheLargestPerimeter {

    public static void main(String[] args) {
        Q2971_M_FindPolygonWithTheLargestPerimeter q2971MFindPolygonWithTheLargestPerimeter = new Q2971_M_FindPolygonWithTheLargestPerimeter();
        System.out.println(q2971MFindPolygonWithTheLargestPerimeter.largestPerimeter(new int[]{5, 5, 5})); // 15
        System.out.println(q2971MFindPolygonWithTheLargestPerimeter.largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3})); // 12
        System.out.println(q2971MFindPolygonWithTheLargestPerimeter.largestPerimeter(new int[]{5, 5, 50})); // -1
        System.out.println(q2971MFindPolygonWithTheLargestPerimeter.largestPerimeter(new int[]{5, 8, 34, 33, 6, 6, 42, 32, 29, 42})); // 237
    }

    // seems slower
    public long largestPerimeter(int[] nums) {
        long res = -1;
        Arrays.sort(nums);

        long sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        sum -= nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 1; i--) {
            if (sum > nums[i + 1]) {
                res = Math.max(res, sum + nums[i + 1]);
            }
            sum -= nums[i];
        }

        return res;
    }

    public long largestPerimeter2(int[] nums) {
        long res = -1;
        Arrays.sort(nums);

        long[] data = new long[nums.length];
        data[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) data[i] += data[i - 1] + nums[i];

        for (int i = nums.length - 2; i >= 1; i--) {
            if (data[i] > nums[i + 1]) {
                res = data[i] + nums[i + 1];
                break;
            }
        }

        return res;
    }
}
