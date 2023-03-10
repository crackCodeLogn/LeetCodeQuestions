package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 31/10/22
 */
public class Q0066_E_PlusOne {

    public static void main(String[] args) {
        Q0066_E_PlusOne obj = new Q0066_E_PlusOne();
        Arrays.stream(obj.plusOne(new int[]{1, 2, 3})).forEach(System.out::println);
        Arrays.stream(obj.plusOne(new int[]{9})).forEach(System.out::println);
    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        int[] data = new int[digits.length + 1];
        for (int i = data.length - 2; i >= 0; i--) {
            int sum = carry + digits[i];
            carry = 0;
            if (sum == 10) carry = 1;
            data[i + 1] = sum % 10;
        }
        if (carry == 1) {
            data[0] = 1;
            return data;
        }
        return Arrays.copyOfRange(data, 1, data.length);
    }
}