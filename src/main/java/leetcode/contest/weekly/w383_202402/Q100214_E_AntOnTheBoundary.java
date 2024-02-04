package leetcode.contest.weekly.w383_202402;

/**
 * @author Vivek
 * @since 2024-02-04
 */
public class Q100214_E_AntOnTheBoundary {

    public static void main(String[] args) {
        Q100214_E_AntOnTheBoundary q100214EAntOnTheBoundary = new Q100214_E_AntOnTheBoundary();
        System.out.println(q100214EAntOnTheBoundary.returnToBoundaryCount(new int[]{1})); //0
    }

    public int returnToBoundaryCount(int[] nums) {
        int cnt = 0, n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == 0) cnt++;
        }
        return cnt;
    }
}
