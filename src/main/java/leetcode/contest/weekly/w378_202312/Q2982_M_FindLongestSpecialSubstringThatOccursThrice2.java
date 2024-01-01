package leetcode.contest.weekly.w378_202312;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-12-31
 */
public class Q2982_M_FindLongestSpecialSubstringThatOccursThrice2 {

    private static final int upper = (int) (5 * 1e5);

    private static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) if (data[i] > 0) System.out.print((i + 1) + ": " + data[i] + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
        Q2982_M_FindLongestSpecialSubstringThatOccursThrice2 q3 = new Q2982_M_FindLongestSpecialSubstringThatOccursThrice2();
//        System.out.println(q3.maximumLength("aaaa")); // 2
//        System.out.println(q3.maximumLength("abcdef")); // -1
//        System.out.println(q3.maximumLength("abcaba")); // 1
//        System.out.println(q3.maximumLength("aaauuuxxxx")); // 2
//        System.out.println(q3.maximumLength("abbxxxxxxxxxxxaauuuxxxxx")); // 9
        System.out.println(q3.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde")); // 2
//        System.out.println(q3.maximumLength("euuuu")); // 2
//        System.out.println(q3.maximumLength("ccc")); // 1
    }

    public int maximumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
//            present.remove(ch);
            int j = i + 1;
            for (; j < s.length() && s.charAt(j) == ch; j++) ;
            int delta = j - i;
            Integer val = map.get(ch);
            if (val == null) map.put(ch, delta);
            else if (delta > val) map.put(ch, val);

            if (m2.containsKey(ch)) m2.put(ch, m2.get(ch) + 1);
            else m2.put(ch, 1);
            i = j;
        }
        System.out.println(map);
        //for (Character ch : present) map.remove(ch); //removing excess

        int max = -1;
        for (char ch : map.keySet()) {
            if (map.get(ch) >= 3) max = Math.max(max, map.get(ch) - 2); //-3+1
        }
        if (max == -1) {
            for (char ch : m2.keySet()) if (m2.get(ch) >= 3) return 1;
        }
        return max;
    }

    public int maximumLength2(String s) {
        Map<Character, int[]> map = new HashMap<>();
        Set<Character> present = new HashSet<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, new int[upper]);
            present.add(ch);
        }


        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            present.remove(ch);
            int j = i + 1;
            for (; j < s.length() && s.charAt(j) == ch; j++) ;
            int delta = j - i, d2 = delta;
            int[] data = map.get(ch);
            for (int k = 1; k <= d2; k++, delta--) data[delta - 1] += k;
            i = j;
        }
        for (Character ch : present) map.remove(ch); //removing excess

        int max = -1;
        for (char ch : map.keySet()) {
            int[] data = map.get(ch);

            if (data[0] < 3) continue;

            for (int i = 0; i < data.length; i++) {
                if (data[i] == 3) {
                    max = Math.max(max, i + 1);
                }
            }
        }
        /*map.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey());
            printArray(entry.getValue());
        });*/
        return max;
    }
}
