package leetcode.practise;

import com.google.common.collect.Lists;

import java.util.*;

public class Q0140_H_WordBreakII {

    public static void main(String[] args) {
        Q0140_H_WordBreakII q0140HWordBreakII = new Q0140_H_WordBreakII();
        System.out.println(q0140HWordBreakII.wordBreak("catsanddog", Lists.newArrayList("cat", "cats", "and", "sand", "dog")));
        System.out.println(q0140HWordBreakII.wordBreak("pineapplepenapple", Lists.newArrayList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(q0140HWordBreakII.wordBreak("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat")));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> mem = new HashMap<>();
        return wordBreak(s, wordSet, mem);
    }

    private List<String> wordBreak(String s, Set<String> wordSet, Map<String, List<String>> mem) {
        if (mem.containsKey(s)) return mem.get(s);

        List<String> ans = new ArrayList<>();
        for (int i = 1; i < s.length(); ++i) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (wordSet.contains(prefix))
                for (String word : wordBreak(suffix, wordSet, mem)) ans.add(prefix + " " + word);
        }

        if (wordSet.contains(s)) ans.add(s);
        mem.put(s, ans);
        return ans;
    }
}
