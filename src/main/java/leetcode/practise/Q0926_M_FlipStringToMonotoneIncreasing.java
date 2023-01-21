package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-01-17
 * <p>
 * INCOMPLETE
 */
public class Q0926_M_FlipStringToMonotoneIncreasing {

    public static void main(String[] args) {
        //System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111111111111".length());
        //System.out.println(Long.parseLong("11111111111111111111111111111111111111111111111111111111111111111111111111111111", 2));
        //System.out.println(Long.parseLong("11111111111111111111111111111111111111111111", 2));

        Q0926_M_FlipStringToMonotoneIncreasing q0926MFlipStringToMonotoneIncreasing = new Q0926_M_FlipStringToMonotoneIncreasing();
        System.out.println(q0926MFlipStringToMonotoneIncreasing.minFlipsMonoIncr("00110"));
        System.out.println(q0926MFlipStringToMonotoneIncreasing.minFlipsMonoIncr("010110"));
        System.out.println(q0926MFlipStringToMonotoneIncreasing.minFlipsMonoIncr("00011000"));
        System.out.println(q0926MFlipStringToMonotoneIncreasing.minFlipsMonoIncr("011100"));
        System.out.println(q0926MFlipStringToMonotoneIncreasing.minFlipsMonoIncr("0101100011")); //actual: 4, expected: 3

    }

    public int minFlipsMonoIncr(String s) {
        if (s.length() == 1) return 0;
        int c0 = 0;
        int c1 = 0;
        int i = 0;
        int[] c00 = new int[s.length()];
        int[] c11 = new int[s.length()];
        //for (; i < s.length() && s.charAt(i) == '0'; i++) ;
        if (s.charAt(0) == '0') {
            c0 = 0;
            c00[0] = 1;
        } else {
            c1 = 0;
            c11[0] = 1;
        }
        for (i = 1; i < s.length(); i++) {
            c00[i] = c00[i - 1];
            c11[i] = c11[i - 1];
            if (s.charAt(i) == '0') {
                c0++;
                c00[i]++;
            } else {
                c1++;
                c11[i]++;
            }
        }
        int sum = c1 + c0, min = Integer.MAX_VALUE;
        for (i = 0; i < s.length(); i++) {
            c00[i] = c0 - c00[i];

        }
        return Math.min(c0, c1);
    }
}
