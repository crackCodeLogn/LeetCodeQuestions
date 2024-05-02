package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

public class Q2441_E_LargestPositiveIntegerThaExistsWithItsNegative {

    public int findMaxK(int[] nums) { // 6ms
        Set<Integer> data = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            if (data.contains(-num) && Math.abs(num) > res) res = Math.abs(num);
            data.add(num);
        }
        return res;
    }
}
