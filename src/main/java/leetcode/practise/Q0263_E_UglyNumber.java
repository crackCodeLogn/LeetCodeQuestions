package leetcode.practise;

/**
 * @author Vivek
 * @since 24/10/22
 */
public class Q0263_E_UglyNumber {

    public static void main(String[] args) {
        Q0263_E_UglyNumber obj = new Q0263_E_UglyNumber();
        System.out.println(obj.isUgly(6));
    }

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
}