package leetcode.practise.grind75;

/**
 * @author Vivek
 * @since 2023-12-26
 */
public class Q0704_E_BinarySearch {

    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] data, int target, int lb, int ub) {
        if (lb > ub) return -1;
        int mid = lb + (ub - lb) / 2;
        if (data[mid] == target) return mid;
        if (target > data[mid]) lb = mid + 1;
        else ub = mid - 1;
        return helper(data, target, lb, ub);
    }
}
