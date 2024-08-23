package leetcode.contest.weekly.w410_202408;

/**
 * @author Vivek
 * @since 2024-08-21
 */
public class Q0476_E_NumberComplement {

    public static void main(String[] args) {
        Q0476_E_NumberComplement q0476ENumberComplement = new Q0476_E_NumberComplement();
        System.out.println(q0476ENumberComplement.findComplement(5));
        System.out.println(q0476ENumberComplement.findComplement(1));
        System.out.println(q0476ENumberComplement.findComplement(2));
    }

    public int findComplement(int num) {
        for (long i = 1; i <= num; i <<= 1) num ^= i;
        return num;
    }
}
