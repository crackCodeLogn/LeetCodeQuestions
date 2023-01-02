package leetcode.practise;

/**
 * @author Vivek
 * @since 24/10/22
 */
public class Q26_E_Remove_Duplicates_Sorted_Array {

    public static void main(String[] args) {
        Q26_E_Remove_Duplicates_Sorted_Array object = new Q26_E_Remove_Duplicates_Sorted_Array();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(object.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int last = nums[0], inplace = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                nums[i] = -1;
            } else {
                last = nums[i];
                nums[inplace++] = nums[i];
            }
        }
        return inplace;
    }
}