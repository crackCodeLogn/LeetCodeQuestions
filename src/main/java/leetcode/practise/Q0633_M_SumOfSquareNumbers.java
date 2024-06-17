package leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Q0633_M_SumOfSquareNumbers {
    private static final TreeSet<Integer> squares = new TreeSet<>();
    private static final List<Integer> squares2 = new ArrayList<>(50000);

    public static void main(String[] args) {
        Q0633_M_SumOfSquareNumbers q0633MSumOfSquareNumbers = new Q0633_M_SumOfSquareNumbers();
        System.out.println(q0633MSumOfSquareNumbers.judgeSquareSum(5)); // true
        System.out.println(q0633MSumOfSquareNumbers.judgeSquareSum(3)); // false
        System.out.println(q0633MSumOfSquareNumbers.judgeSquareSum(8)); // true
        System.out.println(q0633MSumOfSquareNumbers.judgeSquareSum(2147483600)); // true
    }

    public boolean judgeSquareSum2(int c) { // 80ms
        if (squares.isEmpty()) {
            int upper = (int) Math.sqrt(Integer.MAX_VALUE);
            for (int i = 0; i <= upper; i++) squares.add(i * i);
        }
        for (int n1 : squares) {
            if (c < n1) break;
            if (squares.contains(c - n1)) return true;
        }
        return false;
    }

    public boolean judgeSquareSum3(int c) { // 81ms
        if (squares2.isEmpty()) {
            int upper = (int) Math.sqrt(Integer.MAX_VALUE);
            for (int i = 0; i <= upper; i++) squares2.add(i * i);
        }
        for (int n1 : squares2) {
            if (c < n1) break;
            if (Collections.binarySearch(squares2, c - n1) >= 0) return true;
        }
        return false;
    }

    public boolean judgeSquareSum(int c) { // 4ms
        long lb = 0, ub = (long) Math.sqrt(c);
        while (lb <= ub) {
            long sum = lb * lb + ub * ub;
            if (sum == c) return true;
            else if (c > sum) lb++;
            else ub--;
        }
        return false;
    }
}
