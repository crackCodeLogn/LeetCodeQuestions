package leetcode.contest.weekly.w400_202406;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2024-06-02
 */
public class Q3170_M_LexicographicallyMinimumStringAfterRemovingStars {

    public static void main(String[] args) {
        Q3170_M_LexicographicallyMinimumStringAfterRemovingStars q3170MLexicographicallyMinimumStringAfterRemovingStars = new Q3170_M_LexicographicallyMinimumStringAfterRemovingStars();
        System.out.println(q3170MLexicographicallyMinimumStringAfterRemovingStars.clearStars("aaba*"));
        System.out.println(q3170MLexicographicallyMinimumStringAfterRemovingStars.clearStars("abc"));
        System.out.println(q3170MLexicographicallyMinimumStringAfterRemovingStars.clearStars("d*d*"));
    }

    public String clearStars(String s) {
        int lastIndex = s.indexOf("*");
        if (lastIndex == -1) return s;
        StringBuilder data = new StringBuilder(s);

        TreeMap<Character, TreeSet<Integer>> map = new TreeMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) map.put(ch, new TreeSet<>());
        map.put('*', new TreeSet<>());
        for (int i = 0; i < data.length(); i++) map.get(s.charAt(i)).add(i);

        for (int starIndex : map.get('*')) {
            data.setCharAt(starIndex, '\0');
            Integer target = null;
            char c = '\0';
            for (Character ch : map.keySet()) {
                if (ch == '*') continue;
                target = map.get(ch).floor(starIndex);
                c = ch;
                if (target != null) break;
            }
            map.get(c).remove(target);
            data.setCharAt(target, '\0');
        }

        return data.toString().replaceAll("\0", "");
    }
}
