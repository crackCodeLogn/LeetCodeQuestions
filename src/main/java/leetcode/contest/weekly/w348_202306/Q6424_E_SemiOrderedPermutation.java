package leetcode.contest.weekly.w348_202306;

/**
 * @author Vivek
 * @since 2023-06-04
 */
public class Q6424_E_SemiOrderedPermutation {

    public static void main(String[] args) {
        Q6424_E_SemiOrderedPermutation q6424ESemiOrderedPermutation = new Q6424_E_SemiOrderedPermutation();
        System.out.println(q6424ESemiOrderedPermutation.semiOrderedPermutation(new int[]{
                2, 4, 1, 3
        }));
        System.out.println(q6424ESemiOrderedPermutation.semiOrderedPermutation(new int[]{
                2, 1, 4, 3
        }));
        System.out.println(q6424ESemiOrderedPermutation.semiOrderedPermutation(new int[]{
                1, 3, 4, 2, 5
        }));
        System.out.println(q6424ESemiOrderedPermutation.semiOrderedPermutation(new int[]{
                3, 2, 1
        }));
    }

    public int semiOrderedPermutation(int[] nums) {
        if (nums[0] == 1 && nums[nums.length - 1] == nums.length) return 0;
        int cnt = 0;
        if (nums[0] != 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    for (int j = i - 1; j >= 0; j--, i--) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        cnt++;
                    }
                    break;
                }
            }
        }
        if (nums[nums.length - 1] != nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums.length) {
                    for (int j = i + 1; j < nums.length; j++, i++) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        cnt++;
                    }
                    break;
                }
            }
        }
        return cnt;
    }
}
