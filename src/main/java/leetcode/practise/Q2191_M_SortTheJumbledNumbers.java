package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-07-24
 */
public class Q2191_M_SortTheJumbledNumbers {

    public static void main(String[] args) {
        Q2191_M_SortTheJumbledNumbers q2191MSortTheJumbledNumbers = new Q2191_M_SortTheJumbledNumbers();
        System.out.println(Arrays.toString(q2191MSortTheJumbledNumbers.sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{991, 338, 38})));
        System.out.println(Arrays.toString(q2191MSortTheJumbledNumbers.sortJumbled(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{789, 456, 123})));
        System.out.println(Arrays.toString(q2191MSortTheJumbledNumbers.sortJumbled(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{0, 999999999})));
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] revMap = new int[10];
        for (int i = 0; i < mapping.length; i++) revMap[mapping[i]] = i;

        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (int num : nums) {
            String converted = getValue(num, mapping);
            List<String> list = map.computeIfAbsent(Integer.parseInt(converted), k -> new ArrayList<>());
            list.add(converted);
        }

        int k = 0;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet())
            for (String mapped : entry.getValue()) nums[k++] = getValue(mapped, revMap);
        return nums;
    }

    private String getValue(int val, int[] map) {
        if (val == 0) return String.valueOf(map[0]);

        StringBuilder data = new StringBuilder();
        while (val > 0) {
            data.append(map[val % 10]);
            val /= 10;
        }
        return data.reverse().toString();
    }

    private int getValue(String val, int[] map) {
        int data = 0;
        for (int i = 0; i < val.length(); i++) data = (data * 10) + map[val.charAt(i) - '0'];
        return data;
    }
}
