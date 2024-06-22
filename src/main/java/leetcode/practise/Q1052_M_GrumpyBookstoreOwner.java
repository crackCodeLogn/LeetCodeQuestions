package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-06-22
 */
public class Q1052_M_GrumpyBookstoreOwner {

    public static void main(String[] args) {
        Q1052_M_GrumpyBookstoreOwner q1052MGrumpyBookstoreOwner = new Q1052_M_GrumpyBookstoreOwner();
        System.out.println(q1052MGrumpyBookstoreOwner.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3)); // 16
        System.out.println(q1052MGrumpyBookstoreOwner.maxSatisfied(new int[]{1}, new int[]{0}, 1)); // 1
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0;
        int madeSatisfied = 0;
        int windowSatisfied = 0;

        for (int i = 0; i < customers.length; ++i) {
            if (grumpy[i] == 0)
                satisfied += customers[i];
            else
                windowSatisfied += customers[i];
            if (i >= X && grumpy[i - X] == 1)
                windowSatisfied -= customers[i - X];
            madeSatisfied = Math.max(madeSatisfied, windowSatisfied);
        }

        return satisfied + madeSatisfied;
    }
}
