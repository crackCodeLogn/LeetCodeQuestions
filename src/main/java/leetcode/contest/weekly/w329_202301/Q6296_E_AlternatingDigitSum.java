package leetcode.contest.weekly.w329_202301;

/**
 * @author Vivek
 * @since 2023-01-22
 */
public class Q6296_E_AlternatingDigitSum {

    public static void main(String[] args) {
        Q6296_E_AlternatingDigitSum q6296EAlternatingDigitSum = new Q6296_E_AlternatingDigitSum();
        System.out.println(q6296EAlternatingDigitSum.alternateDigitSum(886996));
    }

    public int alternateDigitSum(int n) {
        int sum = 0;
        boolean flag = true;
        String data = String.valueOf(n);
        for (int i = 0; i < data.length(); i++) {
            int val = data.charAt(i) - 48;
            sum += flag ? val : val * -1;
            flag = !flag;
        }
        return sum;
    }
}