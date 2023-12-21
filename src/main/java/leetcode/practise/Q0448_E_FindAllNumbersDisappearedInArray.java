package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-12-22
 */
public class Q0448_E_FindAllNumbersDisappearedInArray {

    public static void main(String[] args) {
        Q0448_E_FindAllNumbersDisappearedInArray q0448EFindAllNumbersDisappearedInArray = new Q0448_E_FindAllNumbersDisappearedInArray();
        System.out.println(q0448EFindAllNumbersDisappearedInArray.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (nums[v - 1] > 0)
                nums[v - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] > 0) data.add(i + 1);
        return data;
    }
}
