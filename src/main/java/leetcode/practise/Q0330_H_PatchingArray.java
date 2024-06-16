package leetcode.practise;

public class Q0330_H_PatchingArray {
    public static void main(String[] args) {
        Q0330_H_PatchingArray q0330HPatchingArray = new Q0330_H_PatchingArray();
        System.out.println(q0330HPatchingArray.minPatches(new int[]{1, 3}, 6)); // 1
        System.out.println(q0330HPatchingArray.minPatches(new int[]{1, 5, 10}, 20)); // 2
        System.out.println(q0330HPatchingArray.minPatches(new int[]{1, 2, 2}, 5)); // 0
    }

    public int minPatches(int[] nums, int n) {
        int ans = 0;
        int i = 0;
        long miss = 1;

        while (miss <= n)
            if (i < nums.length && nums[i] <= miss) miss += nums[i++];
            else {
                miss += miss;
                ans++;
            }

        return ans;
    }
}
