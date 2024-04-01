package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-04-01
 */
public class Q0053_E_LengthOfLastWord {

    public static void main(String[] args) {
        Q0053_E_LengthOfLastWord q0053ELengthOfLastWord = new Q0053_E_LengthOfLastWord();
        System.out.println(q0053ELengthOfLastWord.lengthOfLastWord("Hello World")); // 5
        System.out.println(q0053ELengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(q0053ELengthOfLastWord.lengthOfLastWord("luffy is still joyboy")); // 6
    }

    public int lengthOfLastWord(String s) {
        int cnt = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && flag) break;
            else if (s.charAt(i) != ' ') {
                flag = true;
                cnt++;
            }
        }
        return cnt;
    }
}
