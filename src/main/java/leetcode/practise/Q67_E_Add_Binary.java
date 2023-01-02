package leetcode.practise;

/**
 * @author Vivek
 * @since 31/10/22
 */
public class Q67_E_Add_Binary {

    public static void main(String[] args) {
        Q67_E_Add_Binary obj = new Q67_E_Add_Binary();
        //System.out.println(obj.addBinary("11", "1"));
        System.out.println(obj.addBinary(
                "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011")
        );
    }

    public String addBinary(String a, String b) {
        int limit = Math.max(a.length(), b.length());
        for (int i = limit - a.length(); i > 0; i--) a = "0" + a;
        for (int i = limit - b.length(); i > 0; i--) b = "0" + b;
        System.out.println(a);
        System.out.println(b);

        int carry = 0;
        StringBuilder result = new StringBuilder("");
        for (int i = a.length() - 1; i >= 0; i--) {
            int sum = a.charAt(i) - 48 + b.charAt(i) - 48 + carry;
            char ch = '0';
            carry = 1;
            if (sum <= 1) {
                carry = 0;
                ch = sum == 1 ? '1' : '0';
            } else if (sum == 3) {
                ch = '1';
            }
            result = result.append(ch);
        }
        if (carry > 0) result.append('1');
        return result.reverse().toString();
    }
}
