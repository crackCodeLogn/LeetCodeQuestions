package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-01-31
 */
public class Q0739_M_DailyTemperatures {

    public static void main(String[] args) {
        Q0739_M_DailyTemperatures q0739MDailyTemperatures = new Q0739_M_DailyTemperatures();
        int[] arr = q0739MDailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}); //1,1,4,2,1,1,0,0
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("---");
        arr = q0739MDailyTemperatures.dailyTemperatures(new int[]{30, 40, 50, 60}); //1,1,1,0
        Arrays.stream(arr).forEach(System.out::println);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] temp = new int[101];
        int[] result = new int[temperatures.length];
        result[n - 1] = 0;
        temp[temperatures[n - 1]] = n - 1;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int higherIndex = Integer.MAX_VALUE;
            for (int j = temperatures[i] + 1; j <= 100; j++) {
                if (temp[j] > 0 && temp[j] < higherIndex) {
                    higherIndex = temp[j];
                }
            }
            temp[temperatures[i]] = i;
            result[i] = higherIndex != Integer.MAX_VALUE ? higherIndex - i : 0;
        }
        return result;
    }
}
