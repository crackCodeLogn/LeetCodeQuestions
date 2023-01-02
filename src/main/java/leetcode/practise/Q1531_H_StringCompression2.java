package leetcode.practise;

/**
 * @author Vivek
 * @since 16/10/22
 * <p>
 * INC
 */
public class Q1531_H_StringCompression2 {

    public static void main(String[] args) {
        Q1531_H_StringCompression2 object = new Q1531_H_StringCompression2();
        System.out.println(object.getCompressed("aaabcccd"));
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        String compressed = getCompressed(s);

        return -1;
    }

    private String getCompressed(String s) {
        StringBuilder data = new StringBuilder();
        char ch = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) cnt++;
            else {
                data.append(ch);
                if (cnt > 1) data.append(cnt);
                ch = s.charAt(i);
                cnt = 1;
            }
        }
        data.append(ch);
        if (cnt > 1) data.append(cnt);
        return data.toString();
    }
}