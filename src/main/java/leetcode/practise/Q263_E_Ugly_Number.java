package leetcode.practise;

/**
 * @author Vivek
 * @since 24/10/22
 */
public class Q263_E_Ugly_Number {

    public static void main(String[] args) {
        Q263_E_Ugly_Number obj = new Q263_E_Ugly_Number();
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