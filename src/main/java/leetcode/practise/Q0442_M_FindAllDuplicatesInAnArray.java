package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-03-25
 */
public class Q0442_M_FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        Q0442_M_FindAllDuplicatesInAnArray q0442MFindAllDuplicatesInAnArray = new Q0442_M_FindAllDuplicatesInAnArray();
        System.out.println(q0442MFindAllDuplicatesInAnArray.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})); // 2,3
        System.out.println(q0442MFindAllDuplicatesInAnArray.findDuplicates(new int[]{1, 1, 2})); // 1
        System.out.println(q0442MFindAllDuplicatesInAnArray.findDuplicates(new int[]{1})); //
        System.out.println(q0442MFindAllDuplicatesInAnArray.findDuplicates(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7})); // 10, 1
    }

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int target = nums[Math.abs(nums[i]) - 1];
            if (target < 0) result.add(Math.abs(nums[i]));
            else nums[Math.abs(nums[i]) - 1] *= -1;
        }
        return result;
    }
}
