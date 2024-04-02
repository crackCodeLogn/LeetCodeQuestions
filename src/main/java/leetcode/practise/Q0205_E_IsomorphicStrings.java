package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 24/10/22
 */
public class Q0205_E_IsomorphicStrings {

    public static void main(String[] args) {
        Q0205_E_IsomorphicStrings obj = new Q0205_E_IsomorphicStrings();
        System.out.println(obj.isIsomorphic("egg", "add")); // true
        System.out.println(obj.isIsomorphic("foo", "bar")); // false
        System.out.println(obj.isIsomorphic("paper", "title")); // true
        System.out.println(obj.isIsomorphic("badc", "baba")); // false
    }

    public boolean isIsomorphic(String s, String t) { // 6 ms
        char[] data = new char[512]; // reducing this to 128 has the same time effect
        char[] data2 = new char[512];
        for (int i = 0; i < s.length(); i++) {
            if (data[s.charAt(i)] == '\0' && data2[t.charAt(i)] == '\0') {
                data[s.charAt(i)] = t.charAt(i);
                data2[t.charAt(i)] = data[s.charAt(i)];
            } else if (t.charAt(i) != data[s.charAt(i)]) return false;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) { // 15ms
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
