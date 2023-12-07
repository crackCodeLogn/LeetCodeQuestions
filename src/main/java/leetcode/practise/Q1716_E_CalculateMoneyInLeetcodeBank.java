package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-07
 */
public class Q1716_E_CalculateMoneyInLeetcodeBank {

    public static void main(String[] args) {
        Q1716_E_CalculateMoneyInLeetcodeBank q1716ECalculateMoneyInLeetcodeBank = new Q1716_E_CalculateMoneyInLeetcodeBank();
        System.out.println(q1716ECalculateMoneyInLeetcodeBank.totalMoney(4)); //10
        System.out.println(q1716ECalculateMoneyInLeetcodeBank.totalMoney(8)); //30
        System.out.println(q1716ECalculateMoneyInLeetcodeBank.totalMoney(10)); //37
        System.out.println(q1716ECalculateMoneyInLeetcodeBank.totalMoney(20)); //96
        System.out.println(q1716ECalculateMoneyInLeetcodeBank.totalMoney(26)); //135
    }

    public int totalMoney(int n) {
        if (n <= 7) {
            return n * (n + 1) / 2;
        }
        int m = n - 1;
        int r = m / 7, p = m % 7 + 1;
        int l = 28 * r + 7 * (r - 1) * r / 2;
        return l + (r + 1) * p + (p * (p - 1) / 2);
    }
}
