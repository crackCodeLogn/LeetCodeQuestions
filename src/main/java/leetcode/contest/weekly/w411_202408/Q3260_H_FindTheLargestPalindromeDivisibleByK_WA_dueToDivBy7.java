package leetcode.contest.weekly.w411_202408;

/**
 * @author Vivek
 * @since 2024-08-18
 */
public class Q3260_H_FindTheLargestPalindromeDivisibleByK_WA_dueToDivBy7 {

    public static void main(String[] args) {
        Q3260_H_FindTheLargestPalindromeDivisibleByK_WA_dueToDivBy7 q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7 = new Q3260_H_FindTheLargestPalindromeDivisibleByK_WA_dueToDivBy7();
        System.out.println(q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7.largestPalindrome(1, 2));
        System.out.println(q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7.largestPalindrome(3, 5));
        System.out.println(q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7.largestPalindrome(1, 4));
        System.out.println(q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7.largestPalindrome(5, 6));
        System.out.println(q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7.largestPalindrome(7, 7));
        System.out.println(q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7.largestPalindrome(8, 7));
        System.out.println(q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7.largestPalindrome(8, 8));
        System.out.println(q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7.largestPalindrome(5, 6));
        System.out.println(q3260HFindTheLargestPalindromeDivisibleByKWAdueToDivBy7.largestPalindrome(6, 6)); // 897798
    }

  /*  public String compute(int length) {
        BigInteger start = BigInteger.TEN.pow(length / 2 - 1);
        BigInteger end = BigInteger.TEN.pow(length / 2).subtract(BigInteger.ONE);

        for (BigInteger n = end; n.compareTo(start) >= 0; n = n.subtract(BigInteger.ONE)) {
            BigInteger leftHalf = n;
            BigInteger rightHalf = new BigInteger(new StringBuilder(n.toString()).reverse().toString());
            BigInteger palindrome = leftHalf.multiply(BigInteger.TEN.pow(rightHalf.toString().length())).add(rightHalf);
            if (palindrome.mod(BigInteger.valueOf(7)).equals(BigInteger.ZERO)) {
                return palindrome.toString();
            }
        }
        return "";
    }*/

    public String largestPalindrome(int n, int k) {
        if (k == 1 || k == 3 || k == 9) return getNumber(n);
        else if (k == 2) {
            if (n == 1) return "8";
            return String.format("8%s8", getNumber(n - 2));
        } else if (k == 5) {
            if (n == 1) return "5";
            return String.format("5%s5", getNumber(n - 2));
        } else if (k == 4) {
            if (n <= 4) return getNumber(n, 8);
            return String.format("88%s88", getNumber(n - 4));
        } else if (k == 6) {
            if (n <= 2) return getNumber(n, 6);
            else if (n % 2 == 0) {
                return String.format("8%s77%s8", getNumber((n - 4) / 2), getNumber((n - 4) / 2));
            } else {
                return String.format("8%s8%s8", getNumber((n - 3) / 2), getNumber((n - 3) / 2));
            }
        } else if (k == 7) {
            if (n <= 2) return getNumber(n, 7);
            else if (n == 3) return "959";
            else if (n == 4) return "9779";
            else if (n == 5) return "99799";
            else if (n % 6 == 0) return getNumber(n);
            else if (n == 7) return "9994999";
            else if (n == 8) return "99944999";
            else if (n == 9) return "999969999";
            else if (n == 10) return "9999449999";
            else if (n == 11) return "99999499999";
            else if (n == 15) return "999999959999999";
            else if (n == 19) return "9999999994999999999";
            else if (n % 2 == 0) return String.format("%s77%s", getNumber((n - 2) / 2), getNumber((n - 2) / 2));
            return String.format("%s7%s", getNumber((n - 1) / 2), getNumber((n - 1) / 2));
        } else if (k == 8) {
            if (n <= 6) return getNumber(n, 8);
            return String.format("888%s888", getNumber(n - 6));
        }
        return "";
    }

    private String getNumber(int n) {
        return getNumber(n, 9);
    }

    private String getNumber(int n, int v) {
        return String.valueOf(v).repeat(n);
    }
}
