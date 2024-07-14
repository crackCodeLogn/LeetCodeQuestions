package leetcode.contest.weekly.w406_202407;

/**
 * @author Vivek
 * @since 2024-07-14
 */
public class Q3216_E_LexicographicallySmallestStringAfterASwap {

    public static void main(String[] args) {
        Q3216_E_LexicographicallySmallestStringAfterASwap q3216ELexicographicallySmallestStringAfterASwap = new Q3216_E_LexicographicallySmallestStringAfterASwap();
        System.out.println(q3216ELexicographicallySmallestStringAfterASwap.getSmallestString("45320"));
        System.out.println(q3216ELexicographicallySmallestStringAfterASwap.getSmallestString("001"));
    }

    public String getSmallestString(String s) { // 2ms
        StringBuilder data = new StringBuilder(s);
        String res = s;
        for (int i = 0; i < data.length() - 1; i++) {
            if (sameParity(s.charAt(i), s.charAt(i + 1)) &&
                    s.charAt(i + 1) < s.charAt(i)) {
                char c1 = s.charAt(i), c2 = s.charAt(i + 1);
                data.setCharAt(i, c2);
                data.setCharAt(i + 1, c1);
                if (data.toString().compareTo(res) < 0) {
                    res = data.toString();
                    break;
                }
                data.setCharAt(i, c1);
                data.setCharAt(i + 1, c2);
            }
        }

        return res;
    }

    public String getSmallestString2(String s) { // 2ms
        StringBuilder data = new StringBuilder(s);
        String res = s;
        for (int i = 0; i < data.length() - 1; i++) {
            if (sameParity(s.charAt(i), s.charAt(i + 1)) &&
                    s.charAt(i + 1) < s.charAt(i)) {
                char c1 = s.charAt(i), c2 = s.charAt(i + 1);
                data.setCharAt(i, c2);
                data.setCharAt(i + 1, c1);
                if (data.toString().compareTo(res) < 0) {
                    res = data.toString();
                }
                data.setCharAt(i, c1);
                data.setCharAt(i + 1, c2);
            }
        }

        return res;
    }

    private boolean sameParity(char c1, char c2) {
        return ((c1 ^ c2) & 1) == 0;
    }
}
