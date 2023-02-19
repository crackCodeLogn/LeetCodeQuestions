package leetcode.contest.weekly.w333_202302;

/**
 * @author Vivek
 * @since 2023-02-19
 */
public class Q6364_M_Count_the_Number_of_Square_Free_Subsets {

    private final int[] POWER2 = new int[4];
    private final int MOD = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        Q6364_M_Count_the_Number_of_Square_Free_Subsets q6364MCounttheNumberofSquareFreeSubsets = new Q6364_M_Count_the_Number_of_Square_Free_Subsets();
        System.out.println(q6364MCounttheNumberofSquareFreeSubsets.squareFreeSubsets(new int[]{
                3, 4, 4, 5
        }));
        System.out.println(q6364MCounttheNumberofSquareFreeSubsets.squareFreeSubsets(new int[]{
                3, 8, 8, 5
        }));
        System.out.println(q6364MCounttheNumberofSquareFreeSubsets.squareFreeSubsets(new int[]{
                1
        }));
    }

    private void prep() {
        for (int i = 2, j = 0; i <= 5; i++) {
            POWER2[j++] = i * i;
        }
    }

    public int squareFreeSubsets(int[] nums) {
        prep();
        int ops = 0, val = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < POWER2.length; j++)
                if (nums[i] % POWER2[j] == 0) {
                    val--;
                    break;
                }
        }
        long vali = 2L;
        for (int i = 1; i < val; i++) {
            vali = (vali << 1) % MOD;
        }
        vali -= 1;
        return (int) vali;
    }
}
