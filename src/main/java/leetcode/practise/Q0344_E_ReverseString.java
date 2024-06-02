package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-06-02
 */
public class Q0344_E_ReverseString {

    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char tmp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = tmp;
        }
    }
}
