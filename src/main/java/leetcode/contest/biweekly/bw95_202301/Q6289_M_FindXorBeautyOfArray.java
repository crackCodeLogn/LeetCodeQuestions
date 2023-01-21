package leetcode.contest.biweekly.bw95_202301;

/**
 * @author Vivek
 * @since 2023-01-02
 */
public class Q6289_M_FindXorBeautyOfArray {

    public static void main(String[] args) {
        Q6289_M_FindXorBeautyOfArray q6289MFindXorBeautyOfArray = new Q6289_M_FindXorBeautyOfArray();
        System.out.println(q6289MFindXorBeautyOfArray.xorBeauty(new int[]{
                1, 4
        }));
        System.out.println(q6289MFindXorBeautyOfArray.xorBeauty(new int[]{
                15, 45, 20, 2, 34, 35, 5, 44, 32, 30
        }));
    }

    public int xorBeauty(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) xor ^= nums[i];
        return xor;
    }
}