package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-01
 */
public class Q2864_E_MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        int c0 = 0, c1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') c1++;
            else c0++;
        }
        StringBuilder data = new StringBuilder();
        while (c1-- > 1) data.append("1");
        while (c0-- > 0) data.append("0");
        data.append("1");
        return data.toString();
    }
}
