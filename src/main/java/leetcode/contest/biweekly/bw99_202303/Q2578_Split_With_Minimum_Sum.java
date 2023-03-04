package leetcode.contest.biweekly.bw99_202303;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-03-05
 */
public class Q2578_Split_With_Minimum_Sum {

    public static void main(String[] args) {
        Q2578_Split_With_Minimum_Sum q2578SplitWithMinimumSum = new Q2578_Split_With_Minimum_Sum();
        System.out.println(q2578SplitWithMinimumSum.splitNum(4325));
    }

    public int splitNum(int num) {
        String data = num + "";
        int[] digits = new int[data.length()];
        for (int i = 0; i < data.length(); i++) {
            digits[i] = (int) data.charAt(i) - 48;
        }
        Arrays.sort(digits);
        long sum1 = 0, sum2 = 0;
        boolean flag = true;
        for (int i = 0; i < data.length(); i++) {
            if (flag) sum1 = (sum1 * 10) + digits[i];
            else sum2 = (sum2 * 10) + digits[i];
            flag = !flag;
        }
        return (int) (sum1 + sum2);
    }
}
