package leetcode.practise;

/**
 * @author Vivek
 * @since 24/10/22
 */
public class Q27_E_Remove_Element {

    public static void main(String[] args) {
        Q27_E_Remove_Element object = new Q27_E_Remove_Element();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(object.removeElement(nums, 2));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int inplace = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && inplace == -1) {
                inplace = i;
            } else if (nums[i] == val) {

            } else if (inplace > -1) {
                nums[inplace++] = nums[i];
            }
        }
        return inplace == -1 ? nums.length : inplace;
    }
}
