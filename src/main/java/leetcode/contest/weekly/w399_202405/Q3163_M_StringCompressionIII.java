package leetcode.contest.weekly.w399_202405;

/**
 * @author Vivek
 * @since 2024-05-26
 */
public class Q3163_M_StringCompressionIII {

    public static void main(String[] args) {
        Q3163_M_StringCompressionIII q3163MStringCompressionIII = new Q3163_M_StringCompressionIII();
        System.out.println(q3163MStringCompressionIII.compressedString("abcde"));
        System.out.println(q3163MStringCompressionIII.compressedString("aaaaaaaaaaaaaabb"));
    }

    public String compressedString(String word) {
        StringBuilder data = new StringBuilder();
        int ptr = 0, n = word.length();
        while (ptr < n) {
            int k = 1;
            while (k <= 9 && ptr + k < n && word.charAt(ptr) == word.charAt(ptr + k)) k++;
            if (k == 10) k--;
            data.append(k).append(word.charAt(ptr));
            ptr += k;
        }

        return data.toString();
    }
}
