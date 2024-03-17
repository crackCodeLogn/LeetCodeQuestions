package leetcode.contest.weekly.w389_202403;

/**
 * @author Vivek
 * @since 2024-03-17
 */
public class Q3084_M_CountSubstringsStartingAndEndingWithGivenCharacter {

    public static void main(String[] args) {
        Q3084_M_CountSubstringsStartingAndEndingWithGivenCharacter q3084MCountSubstringsStartingAndEndingWithGivenCharacter = new Q3084_M_CountSubstringsStartingAndEndingWithGivenCharacter();
        System.out.println(q3084MCountSubstringsStartingAndEndingWithGivenCharacter.countSubstrings("abada", 'a'));
        System.out.println(q3084MCountSubstringsStartingAndEndingWithGivenCharacter.countSubstrings("zzz", 'z'));
    }

    public long countSubstrings(String s, char c) {
        long answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == c) answer++;
        }
        return answer * (answer + 1) / 2;
    }
}
