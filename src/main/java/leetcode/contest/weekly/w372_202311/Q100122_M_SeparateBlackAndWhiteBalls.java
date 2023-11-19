package leetcode.contest.weekly.w372_202311;

/**
 * @author Vivek
 * @since 2023-11-19
 */
public class Q100122_M_SeparateBlackAndWhiteBalls {

    public static void main(String[] args) {
        Q100122_M_SeparateBlackAndWhiteBalls q100122MSeparateBlackAndWhiteBalls = new Q100122_M_SeparateBlackAndWhiteBalls();
        System.out.println(q100122MSeparateBlackAndWhiteBalls.minimumSteps("0111"));
        System.out.println(q100122MSeparateBlackAndWhiteBalls.minimumSteps("101"));
        System.out.println(q100122MSeparateBlackAndWhiteBalls.minimumSteps("100"));
        System.out.println(q100122MSeparateBlackAndWhiteBalls.minimumSteps("10110011"));
        System.out.println(q100122MSeparateBlackAndWhiteBalls.minimumSteps("110011"));
    }

    public long minimumSteps(String s) {
        long num = 0, cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') cnt++;
            else {
                num += cnt;
            }
        }
        return num;
    }
}
