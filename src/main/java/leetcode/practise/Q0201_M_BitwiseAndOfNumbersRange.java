package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-02-21
 */
public class Q0201_M_BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        Q0201_M_BitwiseAndOfNumbersRange q0201MBitwiseAndOfNumbersRange = new Q0201_M_BitwiseAndOfNumbersRange();
        System.out.println(q0201MBitwiseAndOfNumbersRange.rangeBitwiseAnd(5, 7)); // 4
        System.out.println(q0201MBitwiseAndOfNumbersRange.rangeBitwiseAnd(0, 0)); // 0
        System.out.println(q0201MBitwiseAndOfNumbersRange.rangeBitwiseAnd(1, 2147483647)); // 0
        System.out.println(q0201MBitwiseAndOfNumbersRange.rangeBitwiseAnd(2147483646, 2147483647)); // 2147483646
        System.out.println(q0201MBitwiseAndOfNumbersRange.rangeBitwiseAnd(1073741824, 2147483647)); // 2147483646
    }

    public int rangeBitwiseAnd(int left, int right) {
        int and = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            and++;
        }
        return left << and;
    }
}
