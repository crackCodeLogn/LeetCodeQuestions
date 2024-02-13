package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-02-13
 */
public class Q2108_E_FindFirstPalindromicStringInTheArray {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length() / 2; i++)
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    flag = false;
                    break;
                }
            if (flag) return word;
        }
        return "";
    }
}
