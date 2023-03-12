package leetcode.contest.weekly.w336_202303;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-03-12
 */
public class Q6316_M_Rearrange_Array_to_Maximize_Prefix_Score {


    public static void main(String[] args) {
        Q6316_M_Rearrange_Array_to_Maximize_Prefix_Score q6316MRearrangeArraytoMaximizePrefixScore = new Q6316_M_Rearrange_Array_to_Maximize_Prefix_Score();
        System.out.println(q6316MRearrangeArraytoMaximizePrefixScore.maxScore(new int[]{
                2, -1, 0, 1, -3, 3, -3
        }));
        System.out.println(q6316MRearrangeArraytoMaximizePrefixScore.maxScore(new int[]{
                -2, -3, 0
        }));
    }

    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int cnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            sum += n;
            if (n > 0) {
                cnt++;
            } else {
                if (sum > 0) cnt++;
                else break;
            }
        }
        return cnt;
    }
}
