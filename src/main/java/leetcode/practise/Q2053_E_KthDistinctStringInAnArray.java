package leetcode.practise;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-08-05
 */
public class Q2053_E_KthDistinctStringInAnArray {

    public static void main(String[] args) {
        Q2053_E_KthDistinctStringInAnArray q2053EKthDistinctStringInAnArray = new Q2053_E_KthDistinctStringInAnArray();
        System.out.println(q2053EKthDistinctStringInAnArray.kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2)); // "a"
        System.out.println(q2053EKthDistinctStringInAnArray.kthDistinct(new String[]{"aaa", "aa", "a"}, 1)); // "aaa"
        System.out.println(q2053EKthDistinctStringInAnArray.kthDistinct(new String[]{"a", "b", "a"}, 3)); // ""
    }

    public String kthDistinct(String[] arr, int k) { // 6ms
        LinkedHashSet<String> set = new LinkedHashSet<>();
        Set<String> set1 = new LinkedHashSet<>();
        for (String s : arr) {
            if (!set.contains(s)) set.add(s);
            else set1.add(s);
        }
        set.removeAll(set1);
        if (set.size() < k) return "";

        for (String s : set) if (--k == 0) return s;
        return "";
    }

    public String kthDistinct2(String[] arr, int k) { //12ms
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            if (!set.contains(s)) {
                set.add(s);
                stack.push(s);
            } else {
                stack.remove(s);
            }
        }
        if (stack.size() < k) return "";
        while (stack.size() != k) stack.pop();
        return stack.pop();
    }
}
