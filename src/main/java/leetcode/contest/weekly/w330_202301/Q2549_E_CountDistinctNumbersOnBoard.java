package leetcode.contest.weekly.w330_202301;

/**
 * @author Vivek
 * @since 2023-01-29
 */
public class Q2549_E_CountDistinctNumbersOnBoard {

    public static void main(String[] args) {
        Q2549_E_CountDistinctNumbersOnBoard q2549ECountDistinctNumbersOnBoard = new Q2549_E_CountDistinctNumbersOnBoard();
        System.out.println(q2549ECountDistinctNumbersOnBoard.distinctIntegers(5));
    }

    public int distinctIntegers(int n) {
        if (n <= 2) return 1;
        return n - 1;
    }
}