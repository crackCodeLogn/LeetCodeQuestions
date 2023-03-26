package leetcode.contest.weekly.w338_202303;

/**
 * @author Vivek
 * @since 2023-03-26
 */
public class Q6354_E_KItemsWithTheMaximumSum {

    public static void main(String[] args) {
        Q6354_E_KItemsWithTheMaximumSum q6354EKItemsWithTheMaximumSum = new Q6354_E_KItemsWithTheMaximumSum();
        System.out.println(q6354EKItemsWithTheMaximumSum.kItemsWithMaximumSum(3, 2, 0, 2));
        System.out.println(q6354EKItemsWithTheMaximumSum.kItemsWithMaximumSum(3, 2, 0, 4));
    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        int sum = 0;
        boolean stop = false;
        int k2 = k;
        sum += numOnes;
        k -= numOnes;
        if (k < 0) return k2;
        k -= numZeros;
        if (k < 0) return sum;
        while (k-- > 0) {
            sum--;
        }
        return sum;
    }
}
