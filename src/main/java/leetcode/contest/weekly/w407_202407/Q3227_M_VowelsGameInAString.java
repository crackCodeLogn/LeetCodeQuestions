package leetcode.contest.weekly.w407_202407;

/**
 * @author Vivek
 * @since 2024-07-21
 */
public class Q3227_M_VowelsGameInAString {

    public static void main(String[] args) {
        Q3227_M_VowelsGameInAString q3227MVowelsGameInAString = new Q3227_M_VowelsGameInAString();
        System.out.println(q3227MVowelsGameInAString.doesAliceWin("leetcoder"));
        System.out.println(q3227MVowelsGameInAString.doesAliceWin("bbcd"));

    }

    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        }
        return false;
    }
}
