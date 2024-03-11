package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-03-11
 */
public class Q0791_M_CustomSortString {

    private static final Map<Character, Integer> orderMap = new HashMap<>();

    public static void main(String[] args) {
        Q0791_M_CustomSortString q0791MCustomSortString = new Q0791_M_CustomSortString();
        System.out.println(q0791MCustomSortString.customSortString("cba", "abcd")); // cbad
        System.out.println(q0791MCustomSortString.customSortString("bcafg", "abcd")); // bcad
    }

    public String customSortString(String order, String s) { // 0ms
        int[] cnt = new int[26];

        char[] val = new char[s.length()];
        int k = 0;
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < order.length(); i++) {
            int index = order.charAt(i) - 'a';
            while (cnt[index]-- > 0) val[k++] = (char) (index + 'a');
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i]-- > 0) val[k++] = (char) (i + 'a');
        }
        return new String(val);
    }

    public String customSortString3(String order, String s) { // 1ms
        int[] cnt = new int[26];

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < order.length(); i++) {
            int index = order.charAt(i) - 'a';
            while (cnt[index]-- > 0) res.append((char) (index + 'a'));
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i]-- > 0) res.append((char) (i + 'a'));
        }
        return res.toString();
    }

    public String customSortString2(String order, String s) { // 7ms
        orderMap.clear();

        for (int i = 0; i < order.length(); i++) orderMap.put(order.charAt(i), i);
        List<Character> tmp = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) tmp.add(s.charAt(i));
        tmp.sort(Comparator.comparingInt(this::getOrder));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < tmp.size(); i++) res.append(tmp.get(i));
        return res.toString();
    }

    private int getOrder(char ch) {
        return orderMap.getOrDefault(ch, -1);
    }
}
