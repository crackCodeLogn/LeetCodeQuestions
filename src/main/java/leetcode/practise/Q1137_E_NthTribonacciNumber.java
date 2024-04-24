package leetcode.practise;

public class Q1137_E_NthTribonacciNumber {
    private static final int[] data = new int[38];

    public int tribonacci(int n) {
        if (data[37] == 0) {
            data[0] = 0;
            data[1] = 1;
            data[2] = 1;
            for (int i = 3; i < data.length; i++) data[i] = data[i - 3] + data[i - 2] + data[i - 1];
        }
        return data[n];
    }
}
