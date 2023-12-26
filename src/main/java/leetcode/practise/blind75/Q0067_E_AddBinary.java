package leetcode.practise.blind75;

/**
 * @author Vivek
 * @since 2023-12-26
 */
public class Q0067_E_AddBinary {

    public static void main(String[] args) {
        Q0067_E_AddBinary q0067EAddBinary = new Q0067_E_AddBinary();
        System.out.println(q0067EAddBinary.addBinary("1010", "1011")); //10101
        System.out.println(q0067EAddBinary.addBinary("1111", "1111")); //11110
        System.out.println(q0067EAddBinary.addBinary("100", "110010")); //110110
    }

    public String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        //a is always the longer one now
        StringBuilder data = new StringBuilder();
        char rem = '0';
        int i, j;
        for (j = b.length() - 1, i = a.length() - 1; j >= 0; j--, i--) {
            String op = getSum(b.charAt(j), a.charAt(i), rem);
            rem = op.length() > 1 ? '1' : '0';
            data.append(op.charAt(op.length() - 1));
        }
        for (; i >= 0; i--) {
            String op = getSum(a.charAt(i), '0', rem);
            rem = op.length() > 1 ? '1' : '0';
            data.append(op.charAt(op.length() - 1));
        }
        if (rem == '1') data.append("1");

        return data.reverse().toString();
    }

    private String getSum(char ch1, char ch2, char rem) {
        int sum = (ch1 - '0') + (ch2 - '0') + rem - '0';
        if (sum == 1) return "1";
        else if (sum == 0) return "0";
        else if (sum == 2) return "10";
        return "11";
    }
}
