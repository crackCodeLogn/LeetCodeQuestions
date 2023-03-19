package leetcode.contest.weekly.w337_202303;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-03-19
 */
public class Q6319_E_NumberOfEvenAndOddBits {

    public static void main(String[] args) {
        Q6319_E_NumberOfEvenAndOddBits q6319ENumberOfEvenAndOddBits = new Q6319_E_NumberOfEvenAndOddBits();
        Arrays.stream(q6319ENumberOfEvenAndOddBits.evenOddBit(2)).forEach(System.out::println);
        Arrays.stream(q6319ENumberOfEvenAndOddBits.evenOddBit(17)).forEach(System.out::println);
    }

    private boolean isOdd(int i) {
        return (i & 1) == 1;
    }

    public int[] evenOddBit(int n) {
        String val = Integer.toBinaryString(n);
        System.out.println(val);
        int[] data = new int[2];
        int c0 = 0, c1 = 0;
        for (int i = val.length() - 1, j = 0; i >= 0; i--, j++) {
            if (val.charAt(i) == '1') {
                if (isOdd(j)) c1++;
                else c0++;
            }
        }
        data[0] = c0;
        data[1] = c1;
        return data;
    }
}
