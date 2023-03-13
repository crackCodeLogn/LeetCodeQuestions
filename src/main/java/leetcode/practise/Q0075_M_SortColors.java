package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-03-14
 */
public class Q0075_M_SortColors {

    private void reorient(int[] data, int limit, int target, int total) {
        for (int i = limit - 1; i >= limit - total; i--) {
            int j = 0;
            if (data[i] != target) {
                for (; j < limit; j++) {
                    if (data[j] == target) {
                        data[j] = data[i];
                        data[i] = target;
                        break;
                    }
                }
            }
        }
    }

    public void sortColors(int[] nums) {
        int r = 0, b = 0, w = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) r++;
            else if (nums[i] == 1) b++;
            else w++;
        }
        reorient(nums, nums.length, 2, w);
        reorient(nums, nums.length - w, 1, b);
        reorient(nums, nums.length - w - b, 0, r);
    }
}
