package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-21
 */
public class Q0198_M_HouseRobber {
    private int[] nums;
    private int[] data;

    public static void main(String[] args) {
        Q0198_M_HouseRobber q0198MHouseRobber = new Q0198_M_HouseRobber();
        System.out.println(q0198MHouseRobber.rob(new int[]{1, 2, 3, 1}));
        System.out.println(q0198MHouseRobber.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(q0198MHouseRobber.rob(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public int rob(int[] nums) {
        this.nums = nums;
        this.data = new int[nums.length];
        boolean isAllZero = true;
        for (int n : nums)
            if (n != 0) {
                isAllZero = false;
                break;
            }
        if (isAllZero) return 0;
        return compute(0);
    }

    private int compute(int i) {
        if (i >= nums.length) return 0;
        if (data[i] > 0) return data[i];
        int v = Math.max(nums[i] + compute(i + 2), compute(i + 1));
        data[i] = v;
        return v;
    }
}
