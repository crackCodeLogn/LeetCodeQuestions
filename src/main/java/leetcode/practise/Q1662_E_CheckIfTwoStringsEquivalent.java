package leetcode.practise;

/**
 * @author Vivek
 * @since 25/10/22
 */
public class Q1662_E_CheckIfTwoStringsEquivalent {

    public static void main(String[] args) {
        Q1662_E_CheckIfTwoStringsEquivalent obj = new Q1662_E_CheckIfTwoStringsEquivalent();
        System.out.println(obj.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bcd"}));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s11 = new StringBuilder();
        for (String s : word1) s11.append(s);
        String s1 = s11.toString();
        int i = 0;
        for (String s : word2) {
            int j = 0;
            for (; j < s.length() && i < s1.length(); j++) {
                if (s.charAt(j) != s1.charAt(i++)) return false;
            }
            if (j != s.length()) return false;
        }
        return i == s1.length();
    }
}
