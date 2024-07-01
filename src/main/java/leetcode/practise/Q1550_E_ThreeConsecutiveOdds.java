package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-07-01
 */
public class Q1550_E_ThreeConsecutiveOdds {

    public static void main(String[] args) {
        Q1550_E_ThreeConsecutiveOdds q1550EThreeConsecutiveOdds = new Q1550_E_ThreeConsecutiveOdds();
        System.out.println(q1550EThreeConsecutiveOdds.threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        System.out.println(q1550EThreeConsecutiveOdds.threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
        System.out.println(q1550EThreeConsecutiveOdds.threeConsecutiveOdds(new int[]{1, 3, 5}));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++)
            if (isOdd(arr[i]) && isOdd(arr[i + 1]) && isOdd(arr[i + 2])) return true;
        return false;
    }

    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
