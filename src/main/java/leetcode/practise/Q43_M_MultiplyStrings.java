package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-01-02
 */
public class Q43_M_MultiplyStrings {

    public static void main(String[] args) {
        Q43_M_MultiplyStrings q43MMultiplyStrings = new Q43_M_MultiplyStrings();
        System.out.println(q43MMultiplyStrings.multiply("123", "456"));
        System.out.println(q43MMultiplyStrings.multiply("9", "9"));
        System.out.println(q43MMultiplyStrings.multiply("9133", "0"));
    }

    public String multiply(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String buff = num1;
            num1 = num2;
            num2 = buff;
        }
        List<Integer> num11 = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; i--) {
            num11.add(num1.charAt(i) - '0');
        }
        List<List<Integer>> data = new ArrayList<>();
        for (int j = num2.length() - 1, cnt = 0; j >= 0; j--, cnt++) {
            List<Integer> internal = new ArrayList<>();
            int carry = 0;
            int ch2 = num2.charAt(j) - '0';
            for (int v = 1; v <= cnt; v++) internal.add(0);
            for (int i = 0; i < num11.size(); i++) {
                int ch1 = num11.get(i);
                int sum = carry + ch1 * ch2;
                carry = sum / 10;
                sum %= 10;
                internal.add(sum);
            }
            if (carry > 0) internal.add(carry);
            data.add(internal);
        }

        int upper = data.get(data.size() - 1).size();
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < upper; i++) {
            int sum = carry;
            for (int j = 0; j < data.size(); j++) {
                List<Integer> internal = data.get(j);
                if (i < internal.size()) sum += internal.get(i);
            }
            carry = sum / 10;
            result.append(sum % 10);
        }
        if (carry > 0) {
            while (carry > 0) {
                result.append(carry % 10);
                carry /= 10;
            }
        }
        result.reverse();
        int i = 0;
        for (; i < result.length() && result.charAt(i) == '0'; i++) ;
        if (i == result.length()) return "0";
        return result.substring(i);
    }
}
