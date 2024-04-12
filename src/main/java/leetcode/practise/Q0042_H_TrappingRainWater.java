package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-01-02
 */
public class Q0042_H_TrappingRainWater {

    public static void main(String[] args) {
        Q0042_H_TrappingRainWater q42HTrappingRainWater = new Q0042_H_TrappingRainWater();
        System.out.println(q42HTrappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 9
        System.out.println(q42HTrappingRainWater.trap(new int[]{4, 2, 0, 3, 2, 5})); // 6
    }

    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int[] l = new int[n];
        int[] r = new int[n];

        for (int i = 0; i < n; i++) l[i] = i == 0 ? height[i] : Math.max(height[i], l[i - 1]);
        for (int i = n - 1; i >= 0; i--) r[i] = i == n - 1 ? height[i] : Math.max(height[i], r[i + 1]);
        for (int i = 0; i < n; i++) res += Math.min(l[i], r[i]) - height[i];

        return res;
    }
}
