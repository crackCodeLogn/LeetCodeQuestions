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
        System.out.println(obj.isIsomorphic("badc", "baba"));
        System.out.println(obj.isIsomorphic("egg", "add"));
    }

    public boolean isIsomorphic(String s, String t) {
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
