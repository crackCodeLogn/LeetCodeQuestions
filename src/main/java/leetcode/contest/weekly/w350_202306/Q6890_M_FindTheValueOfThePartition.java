package leetcode.contest.weekly.w350_202306;


import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-06-18
 */
public class Q6890_M_FindTheValueOfThePartition {

    public static void main(String[] args) {
        Q6890_M_FindTheValueOfThePartition q6890MFindTheValueOfThePartition = new Q6890_M_FindTheValueOfThePartition();
        System.out.println(q6890MFindTheValueOfThePartition.findValueOfPartition(new int[]{1, 3, 2, 4})); //1
        System.out.println(q6890MFindTheValueOfThePartition.findValueOfPartition(new int[]{1, 10, 100})); //9
        System.out.println(q6890MFindTheValueOfThePartition.findValueOfPartition(new int[]{59, 51, 1, 98, 73})); //8
    }

    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) min = Math.min(min, Math.abs(nums[i] - nums[i + 1]));
        return min;
    }
}
