package leetcode.contest.weekly.w384_202402;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-02-11
 */
public class Q100219_M_MaximumPalindromesAfterOperations {
    private int[] counter;
    private List<Integer> evens;
    private List<Integer> odds;

    public static void main(String[] args) {
        Q100219_M_MaximumPalindromesAfterOperations q100219MMaximumPalindromesAfterOperations = new Q100219_M_MaximumPalindromesAfterOperations();
//        System.out.println(q100219MMaximumPalindromesAfterOperations.maxPalindromesAfterOperations(new String[]{"abbb", "ba", "aa"})); // 3
//        System.out.println(q100219MMaximumPalindromesAfterOperations.maxPalindromesAfterOperations(new String[]{"abc", "ab"})); // 2
//        System.out.println(q100219MMaximumPalindromesAfterOperations.maxPalindromesAfterOperations(new String[]{"cd", "ef", "a"})); // 1
//        System.out.println(q100219MMaximumPalindromesAfterOperations.maxPalindromesAfterOperations(new String[]{"a", "a", "caa"})); // 3
//        System.out.println(q100219MMaximumPalindromesAfterOperations.maxPalindromesAfterOperations(new String[]{"fag", "chd", "hhec", "hffee", "dbdh"})); // 4
        System.out.println(q100219MMaximumPalindromesAfterOperations.maxPalindromesAfterOperations(new String[]{"mny", "hf", "cyg", "yailf", "z", "sgq", "x", "tnbo", "xc", "kl", "pj", "d", "mw"})); // 11
    }

    public int maxPalindromesAfterOperations(String[] words) {
        counter = new int[26];
        evens = new ArrayList<>();
        odds = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < words.length; i++) {
            if (isOdd(words[i].length())) odds.add(words[i].length());
            else evens.add(words[i].length());

            for (int j = 0; j < words[i].length(); j++) counter[words[i].charAt(j) - 'a']++;
        }
        Collections.sort(evens);
        Collections.sort(odds);
        //odds.sort(Collections.reverseOrder());

        for (int i = 0; i < evens.size(); i++) cnt += isEvenPossible(evens.get(i)) ? 1 : 0;
        for (int i = 0; i < odds.size(); i++) cnt += isOddPossible(odds.get(i)) ? 1 : 0;
        return cnt;
    }

    private boolean isEvenPossible(int n) {
        int[] local = Arrays.copyOf(counter, counter.length);
        boolean change = true;
        while (change && n > 0) {
            change = false;
            for (int i = 0; i < local.length && n > 0; i++) {
                if (local[i] >= 2) {
                    local[i] -= 2;
                    n -= 2;
                    change = true;
                }
            }
        }
        if (n != 0) {
            return false;
        } else {
            counter = Arrays.copyOf(local, counter.length);
            return true;
        }
    }

    private boolean isOddPossible(int n) {
        int[] local = Arrays.copyOf(counter, counter.length);

        boolean possible = false;
        int oldIndex = 0;
        for (int i = 0; i < local.length; i++) {
            if (isOdd(local[i])) {
                local[i]--;
                n--;
                oldIndex = i;
                possible = true;
                break;
            }
        }
        if (!possible) {
            for (int i = 0; i < local.length; i++) {
                if (local[i] > 0) {
                    local[i]--;
                    n--;
                    oldIndex = i;
                    possible = true;
                    break;
                }
            }
            if (!possible) return false;
        }
        counter = Arrays.copyOf(local, local.length);
        if (n == 0 || isEvenPossible(n)) return true;
        else {
            counter[oldIndex]++;
            return false;
        }
    }

    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }

}
