package leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-01-14
 */
public class Q1657_M_DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        Q1657_M_DetermineIfTwoStringsAreClose q1657MDetermineIfTwoStringsAreClose = new Q1657_M_DetermineIfTwoStringsAreClose();
        System.out.println(q1657MDetermineIfTwoStringsAreClose.closeStrings("abc", "bca")); //true
        System.out.println(q1657MDetermineIfTwoStringsAreClose.closeStrings("a", "aa")); //false
        System.out.println(q1657MDetermineIfTwoStringsAreClose.closeStrings("aa", "aa")); //true
        System.out.println(q1657MDetermineIfTwoStringsAreClose.closeStrings("cabbba", "abbccc")); //true
        System.out.println(q1657MDetermineIfTwoStringsAreClose.closeStrings("uau", "ssx")); //false
        System.out.println(q1657MDetermineIfTwoStringsAreClose.closeStrings(
                "aaabbbbccddeeeeefffff",
                "aaaaabbcccdddeeeeffff")); //false
        System.out.println(q1657MDetermineIfTwoStringsAreClose.closeStrings(
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
        )); //true
    }

    public boolean closeStrings(String word1, String word2) {
        if (word2.length() != word1.length()) return false;

        int[] cnt1 = new int[27];
        int[] cnt2 = new int[27];
        for (int i = 0; i < word1.length(); i++) cnt1[word1.charAt(i) - 'a']++;
        for (int i = 0; i < word1.length(); i++) cnt2[word2.charAt(i) - 'a']++;
        List<Integer> calc1 = new ArrayList<>(27);
        List<Integer> calc2 = new ArrayList<>(27);
        for (int i = 0; i < 27; i++) {
            if (cnt1[i] > 0 && cnt2[i] == 0 || cnt1[i] == 0 && cnt2[i] > 0) return false;
            if (cnt1[i] > 0) calc1.add(cnt1[i]);
            if (cnt2[i] > 0) calc2.add(cnt2[i]);
        }
        Collections.sort(calc1);
        Collections.sort(calc2);
        for (int i = 0; i < calc1.size(); i++) if (!calc1.get(i).equals(calc2.get(i))) return false;
        return true;
/*
        int i = 0;
        for (; i < 27 && cnt1[i] == 0; i++) ;
        int cnt = cnt1[i++];
        for (; i < 27; i++) if (cnt1[i] > 0) cnt ^= cnt1[i];
        for (i = 0; i < 27; i++) if (cnt2[i] > 0) cnt ^= cnt2[i];
        return cnt == 0;*/
    }
}
