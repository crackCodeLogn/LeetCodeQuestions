package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-23
 */
public class Q0125_E_ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            char ch1 = s.charAt(i), ch2 = s.charAt(j);
            if (!(Character.isLetter(ch1) || Character.isDigit(ch1))) {
                j++;
                continue;
            }
            if (!(Character.isLetter(ch2) || Character.isDigit(ch2))) {
                i--;
                continue;
            }
            ch1 = s.charAt(i);
            ch2 = s.charAt(j);
            if (ch1 != ch2)
                return false;
        }
        return true;
    }
}
