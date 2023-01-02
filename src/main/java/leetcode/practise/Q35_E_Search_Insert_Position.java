package leetcode.practise;

/**
 * @author Vivek
 * @since 24/10/22
 */
public class Q35_E_Search_Insert_Position {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        Q35_E_Search_Insert_Position obj = new Q35_E_Search_Insert_Position();
        System.out.println(obj.searchInsert(nums, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int lb = 0, ub = nums.length - 1;
        int index = -1;
        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (mid > 0 && nums[mid] > target && nums[mid - 1] < target) {
                return mid;
            }
            if (mid < nums.length - 1 && nums[mid] < target && nums[mid + 1] > target) {
                return mid + 1;
            }
            if (nums[mid] < target) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }
        if (nums[0] > target) index = 0;
        if (nums[nums.length - 1] < target) index = nums.length;
        return index;
    }
}
