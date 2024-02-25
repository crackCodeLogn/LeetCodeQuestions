package leetcode.contest.weekly.w386_202402;

/**
 * @author Vivek
 * @since 2024-02-25
 */
public class Q3046_E_SplitTheArray {

    public boolean isPossibleToSplit(int[] nums) {

        int[] data = new int[101];
        for (int i = 0; i < nums.length; i++) {
            data[nums[i]]++;
            if (data[nums[i]] > 2) return false;
        }
        return true;
    }
}
