package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-25
 */
public class Q0091_M_DecodeWays {
    public static void main(String[] args) {
        Q0091_M_DecodeWays q0091MDecodeWays = new Q0091_M_DecodeWays();
        System.out.println(q0091MDecodeWays.numDecodings("117"));
        System.out.println(q0091MDecodeWays.numDecodings("11101"));
        System.out.println(q0091MDecodeWays.numDecodings("237"));
        System.out.println(q0091MDecodeWays.numDecodings("227"));
        System.out.println(q0091MDecodeWays.numDecodings("226"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] data = new int[s.length()];
        data[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            int val = Integer.parseInt(s.substring(i, i + 2));
            if (val > 26) {
                data[i] = data[i + 1]; //effectively the 2 char long cannot be a char, so we need to consider the character independently, thus +0
            } else if (i == n - 2) {
                data[i] = data[i + 1] + 1; //if val <=26 and 2nd last char, then you could have 2 choices -> either the standalone or the one with the last one.
                //think about example: 117
            } else { //val <=26 and i is not the second last char - most of the usual case then
                data[i] = data[i + 1] + data[i + 2];
            }
        }
        return data[0];
    }
}
