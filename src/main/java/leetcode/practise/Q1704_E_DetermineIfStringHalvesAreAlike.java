package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-12
 */
public class Q1704_E_DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        boolean[] status = new boolean[130];
        status['a'] = true;
        status['A'] = true;
        status['e'] = true;
        status['E'] = true;
        status['i'] = true;
        status['I'] = true;
        status['o'] = true;
        status['O'] = true;
        status['u'] = true;
        status['U'] = true;
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (status[s.charAt(i)]) cnt1++;
            if (status[s.charAt(j)]) cnt2++;
        }
        return cnt1 == cnt2;
    }
}
