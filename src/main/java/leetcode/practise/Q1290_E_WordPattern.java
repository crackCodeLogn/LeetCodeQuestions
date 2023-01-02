package leetcode.practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-01-02
 */
public class Q1290_E_WordPattern {

    public static void main(String[] args) {
        Q1290_E_WordPattern q290EWordPattern = new Q1290_E_WordPattern();
        System.out.println(q290EWordPattern.wordPattern("abba", "dog cat cat dog"));
        System.out.println(q290EWordPattern.wordPattern("abba", "dog cat cat fish"));
        System.out.println(q290EWordPattern.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(q290EWordPattern.wordPattern("abba", "dog dog dog dog"));
        System.out.println(q290EWordPattern.wordPattern("aaa", "aa aa aa aa"));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> data = new HashMap<>();
        Set<String> values = new HashSet<>();
        String[] splits = s.split("\\s+");
        if (pattern.length() != splits.length) return false;
        int i = 0;
        for (String split : splits) {
            char ch1 = pattern.charAt(i++);
            if (data.containsKey(ch1) && !split.equals(data.get(ch1))) return false;
            else if (!data.containsKey(ch1)) {
                if (values.contains(split)) return false;
                values.add(split);
                data.put(ch1, split);
            }
        }
        return true;
    }
}
