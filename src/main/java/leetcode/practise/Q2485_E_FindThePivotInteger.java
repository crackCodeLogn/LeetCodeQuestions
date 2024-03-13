package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-13
 */
public class Q2485_E_FindThePivotInteger {

    public static void main(String[] args) {
        Q2485_E_FindThePivotInteger q2485EFindThePivotInteger = new Q2485_E_FindThePivotInteger();
        System.out.println(q2485EFindThePivotInteger.pivotInteger(8)); // 6
        System.out.println(q2485EFindThePivotInteger.pivotInteger(1)); // 1
        System.out.println(q2485EFindThePivotInteger.pivotInteger(4)); // -1
    }

    public int pivotInteger(int n) { // 0ms
        if (n == 1) return 1;
        if (n <= 4) return -1;

        int sum = n * (n + 1) / 2;
        if (Math.ceil(Math.sqrt(sum)) == Math.floor(Math.sqrt(sum))) return (int) Math.sqrt(sum);
        return -1;
    }

    public int pivotInteger2(int n) { // 1ms
        if (n == 1) return 1;
        if (n <= 4) return -1;

        int sum = n * (n + 1) / 2, left = 1;
        sum--;
        for (int i = 2; i < n; i++) {
            sum -= i;
            if (left == sum) return i;
            left += i;
        }
        return -1;
    }
}
