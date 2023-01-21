package leetcode.contest.weekly.w327_202301;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2023-01-08
 * UNSOLVED
 */
public class Q6284_M_MakeNumberOfDistinctCharactersEqual {

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q6284_M_MakeNumberOfDistinctCharactersEqual q6284MMakeNumberOfDistinctCharactersEqual = new Q6284_M_MakeNumberOfDistinctCharactersEqual();
        System.out.println(q6284MMakeNumberOfDistinctCharactersEqual.isItPossible("ac", "b")); //f
        System.out.println(q6284MMakeNumberOfDistinctCharactersEqual.isItPossible("abcc", "aab")); //t
        System.out.println(q6284MMakeNumberOfDistinctCharactersEqual.isItPossible("abcde", "fghij")); //t
        System.out.println(q6284MMakeNumberOfDistinctCharactersEqual.isItPossible("ab", "abcc")); //f
        System.out.println(q6284MMakeNumberOfDistinctCharactersEqual.isItPossible("ab", "abc")); //t
        System.out.println(q6284MMakeNumberOfDistinctCharactersEqual.isItPossible("a", "bb")); //t
    }

    public boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            augmentCount(m1, ch);
        }
        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            augmentCount(m2, ch);
        }
        //if (m1.keySet().size() == m2.keySet().size()) return true;
        if (Math.abs(m1.keySet().size() - m2.keySet().size()) > 2) return false;
        //if (m1.keySet().size() >= m2.keySet().size()) {
        for (Character ch1 : m1.keySet()) {
            for (Character ch2 : m2.keySet()) {
                if (ch1 != ch2) {
                    int t1 = m1.keySet().size(), t2 = m2.keySet().size();
                    if (m1.get(ch1) == 1) {
                        t1--;
                    }
                    if (!m1.containsKey(ch2)) {
                        t1++;
                    }
                    if (m2.get(ch2) == 1) {
                        t2--;
                    }
                    if (!m2.containsKey(ch1)) {
                        t2++;
                    }
                    if (t1 == t2) return true;
                }
            }

//                if (!m2.containsKey(ch1)) {
//                    if (m1.get(ch1) > 1) return true;
//                }
        }
//        } else {
//            for (Character ch2 : m2.keySet()) {
//                if (!m1.containsKey(ch2)) {
//                    if (m2.get(ch2) > 1) return true;
//                }
//            }
//        }
        return false;
    }
}
