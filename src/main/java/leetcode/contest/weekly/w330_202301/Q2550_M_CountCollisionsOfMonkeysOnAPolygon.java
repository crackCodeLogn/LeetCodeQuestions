package leetcode.contest.weekly.w330_202301;

/**
 * @author Vivek
 * @since 2023-01-29
 */
public class Q2550_M_CountCollisionsOfMonkeysOnAPolygon {

    private static final int MOD = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        Q2550_M_CountCollisionsOfMonkeysOnAPolygon q2550MCountCollisionsOfMonkeysOnAPolygon = new Q2550_M_CountCollisionsOfMonkeysOnAPolygon();
        //System.out.println(q2.monkeyMove(4));
        System.out.println(q2550MCountCollisionsOfMonkeysOnAPolygon.monkeyMove(500000003));
    }

    public int monkeyMove(int n) {
        long value = 1;
        /*for (int i = 1; i < n; i++) {
            value = (value << 1) % MOD;
        }*/
        long n2 = n - 1, v = 2;
        while (n2 > 0) {
            //System.out.println(n2 + " " + value + " " + v);
            if ((n2 & 1) == 1) {
                value = (value * v) % MOD;
            }
            v = (v * v) % MOD;
            n2 = n2 >> 1;
        }
        value--;
        value = (value << 1) % MOD;
        return (int) value;
    }
}
