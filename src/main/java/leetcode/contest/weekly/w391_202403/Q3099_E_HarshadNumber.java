package leetcode.contest.weekly.w391_202403;

/**
 * @author Vivek
 * @since 2024-03-31
 */
public class Q3099_E_HarshadNumber {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0, x2 = x;
        while (x2 > 0) {
            sum += x2 % 10;
            x2 /= 10;
        }
        return x % sum == 0 ? sum : -1;
    }

}
