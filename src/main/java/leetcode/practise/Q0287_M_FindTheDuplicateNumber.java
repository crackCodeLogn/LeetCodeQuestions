package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-24
 */
public class Q0287_M_FindTheDuplicateNumber {

    public static void main(String[] args) {
        Q0287_M_FindTheDuplicateNumber q0287MFindTheDuplicateNumber = new Q0287_M_FindTheDuplicateNumber();
        System.out.println(q0287MFindTheDuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2})); // 2
        System.out.println(q0287MFindTheDuplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2})); // 3
        System.out.println(q0287MFindTheDuplicateNumber.findDuplicate(new int[]{3, 3, 3, 3, 3})); // 3
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
