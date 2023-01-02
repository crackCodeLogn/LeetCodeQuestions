package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-01-02
 */
public class Q520_E_DetectCapital {
    public static void main(String[] args) {
        Q520_E_DetectCapital q520EDetectCapital = new Q520_E_DetectCapital();
        System.out.println(q520EDetectCapital.detectCapitalUse("g"));
        System.out.println(q520EDetectCapital.detectCapitalUse("mL"));
        System.out.println(q520EDetectCapital.detectCapitalUse("GOOG"));
        System.out.println(q520EDetectCapital.detectCapitalUse("LEET"));
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        boolean firstChar = Character.isUpperCase(word.charAt(0));
        int caps = 0;
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                caps++;
            }
        }
        return firstChar ? (caps == 0 ? true : caps == word.length() - 1) : (caps == 0);
    }
}
