package leetcode.contest.weekly.w329_202301;

/**
 * @author Vivek
 * @since 2023-01-22
 * INTERESTING ONE
 * s[i] s[j] ops translate to: s[i] = s[i] | s[j], s[j] = s[i] ^ s[j]
 * 0 0 => 0 0
 * 0 1 => 1 1
 * 1 0 => 1 1
 * 1 1 => 1 0
 */
public class Q6298_M_ApplyBitwiseOperationsToMakeStringsEqual {

    public static void main(String[] args) {
        Q6298_M_ApplyBitwiseOperationsToMakeStringsEqual q6298MApplyBitwiseOperationsToMakeStringsEqual = new Q6298_M_ApplyBitwiseOperationsToMakeStringsEqual();
        System.out.println(q6298MApplyBitwiseOperationsToMakeStringsEqual.makeStringsEqual("1010", "0110"));
        System.out.println(q6298MApplyBitwiseOperationsToMakeStringsEqual.makeStringsEqual("11", "00"));
    }

    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) return true;
        boolean allZeroes = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                allZeroes = false;
                break;
            }
        }
        if (allZeroes) return false;
        allZeroes = true;
        for (int i = 0; i < s.length(); i++) {
            if (target.charAt(i) == '1') {
                allZeroes = false;
                break;
            }
        }
        return !allZeroes;
    }
}
