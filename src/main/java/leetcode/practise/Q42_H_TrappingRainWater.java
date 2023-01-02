package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-01-02
 */
public class Q42_H_TrappingRainWater {

    public static void main(String[] args) {
        Q42_H_TrappingRainWater q42HTrappingRainWater = new Q42_H_TrappingRainWater();
        System.out.println(q42HTrappingRainWater.trap(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int l1 = height[n - 1];
        int l2 = height[n - 2];
        int lastHigh = 0;
        List<Integer> heights = new ArrayList<>();
        if (l2 >= l1) { //upward or eq
            lastHigh = l2;
            heights.add(lastHigh);
        } else { //lower
            lastHigh = l1;
            heights.add(lastHigh);
            heights.add(l1);
        }
        for (int i = n - 3; i >= 0; i--) {
            if (height[i] > height[i + 1]) {

            } else if (height[i] == height[i + 1]) {

            } else {

            }
        }

        return 0;
    }
}
