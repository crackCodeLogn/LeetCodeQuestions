package leetcode.contest.weekly.w393_202404;

public class Q3114_E_LatestTimeYouCanObtainAfterReplacingCharacters {

    public String findLatestTime(String s) {
        char[] chars = s.toCharArray();

        if (chars[0] == '?' && chars[1] == '?') {
            chars[0] = '1';
            chars[1] = '1';
        } else if (chars[0] != '?' && chars[1] == '?') {
            chars[1] = chars[0] == '0' ? '9' : '1';
        } else if (chars[0] == '?' && chars[1] != '?') {
            chars[0] = chars[1] <= '1' ? '1' : '0';
        }

        if (chars[3] == '?') chars[3] = '5';
        if (chars[4] == '?') chars[4] = '9';

        return new String(chars);
    }

    public static void main(String[] args) {
        Q3114_E_LatestTimeYouCanObtainAfterReplacingCharacters q3114ELatestTimeYouCanObtainAfterReplacingCharacters = new Q3114_E_LatestTimeYouCanObtainAfterReplacingCharacters();
        System.out.println(q3114ELatestTimeYouCanObtainAfterReplacingCharacters.findLatestTime("0?:5?"));
        System.out.println(q3114ELatestTimeYouCanObtainAfterReplacingCharacters.findLatestTime("0?:??"));
        System.out.println(q3114ELatestTimeYouCanObtainAfterReplacingCharacters.findLatestTime("08:33"));
        System.out.println(q3114ELatestTimeYouCanObtainAfterReplacingCharacters.findLatestTime("?3:12"));
    }
}
