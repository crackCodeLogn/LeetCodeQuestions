package leetcode.contest.weekly.w396_202405;

public class Q3136_E_ValidWord {

    private static final String VOWEL = "aeiou";

    public static void main(String[] args) {
        Q3136_E_ValidWord q3136EValidWord = new Q3136_E_ValidWord();
        System.out.println(q3136EValidWord.isValid("234Adas"));
        System.out.println(q3136EValidWord.isValid("b3"));
        System.out.println(q3136EValidWord.isValid("a3$e"));
    }

    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        boolean flag2 = false, flag3 = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i), ch2 = Character.toLowerCase(ch);
            if (VOWEL.indexOf(ch2) > -1) flag2 = true;
            else if (Character.isAlphabetic(ch2)) flag3 = true;
            else if (!Character.isDigit(ch)) return false;
        }
        return flag2 && flag3;
    }
}
