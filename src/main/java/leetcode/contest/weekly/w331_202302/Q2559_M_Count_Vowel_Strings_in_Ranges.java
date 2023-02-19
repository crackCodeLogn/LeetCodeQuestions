package leetcode.contest.weekly.w331_202302;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2023-02-05
 * WA
 */
public class Q2559_M_Count_Vowel_Strings_in_Ranges {

    /*private final Set<Character> set = new HashSet<>();

    private void add() {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }*/

    private static final Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Q2559_M_Count_Vowel_Strings_in_Ranges q2559MCountVowelStringsinRanges = new Q2559_M_Count_Vowel_Strings_in_Ranges();
/*        Arrays.stream(q2.vowelStrings(new String[]{
                "aba", "bcb", "ece", "aa", "e"
        }, new int[][]{
                {0, 2},
                {1, 4},
                {1, 1}
        })).forEach(System.out::println);*/
        Arrays.stream(q2559MCountVowelStringsinRanges.vowelStrings(new String[]{
                "a", "e", "i"
        }, new int[][]{
                {0, 2},
                {0, 1},
                {2, 2}
        })).forEach(System.out::println);
    }

    private boolean isOne(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private int process(int start, int end, boolean[] slots) {
        if (start == end) return slots[start] ? 1 : 0;
        if (start + 1 == end) return process(start, start, slots) + process(end, end, slots);
        String key = start + "-" + end;
        Integer value = map.get(key);
        if (value != null) return value;

        int val = process(start, start + 1, slots);
        map.put(start + "-" + (start + 1), val);
        int val2 = process(start + 2, end, slots);
        map.put((start + 2) + "-" + end, val2);
        return val + val2;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        map.clear();
        boolean[] slots = new boolean[words.length];
        for (int i = 0; i < slots.length; i++) if (isOne(words[i].charAt(0)) && isOne(words[i].charAt(words[i].length() - 1))) slots[i] = true;

        int[] data = new int[queries.length];
        int val = 0;
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
//            int cnt = 0;
//            for (int j = start; j <= end; j++) cnt += slots[j] ? 1 : 0;
            //data[val++] = cnt;
            data[i] = process(start, end, slots);
            map.put(start + "-" + end, data[i]);
        }
        return data;
    }
}
