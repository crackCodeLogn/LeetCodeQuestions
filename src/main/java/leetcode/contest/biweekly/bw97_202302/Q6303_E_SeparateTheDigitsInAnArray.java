package leetcode.contest.biweekly.bw97_202302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-02-04
 */
public class Q6303_E_SeparateTheDigitsInAnArray {

    public static void main(String[] args) {
        Q6303_E_SeparateTheDigitsInAnArray q6303ESeparateTheDigitsInAnArray = new Q6303_E_SeparateTheDigitsInAnArray();
        Arrays.stream(q6303ESeparateTheDigitsInAnArray.separateDigits(new int[]{
                13, 25, 83, 77
        })).forEach(System.out::println);
    }

    public int[] separateDigits(int[] nums) {
        List<Integer> data = new ArrayList<>(100000);
        for (int i = 0; i < nums.length; i++) {
            String s1 = String.valueOf(nums[i]);
            for (int j = 0; j < s1.length(); j++) {
                data.add(s1.charAt(j) - 48);
            }
        }
        int[] data2 = new int[data.size()];
        for (int i = 0; i < data.size(); i++) data2[i] = data.get(i);
        return data2;
    }
}
