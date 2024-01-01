package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-01-01
 */
public class Q0455_E_AssignCookies {

    public static void main(String[] args) {
        Q0455_E_AssignCookies q0455EAssignCookies = new Q0455_E_AssignCookies();
        System.out.println(q0455EAssignCookies.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1})); // 1
        System.out.println(q0455EAssignCookies.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3})); // 2
        System.out.println(q0455EAssignCookies.findContentChildren(new int[]{100, 20}, new int[]{1, 2, 3})); // 0
        System.out.println(q0455EAssignCookies.findContentChildren(new int[]{1, 2, 3}, new int[]{3})); // 1
    }

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;
        for (int i = 0; i < g.length; i++) {
            if (s[j] < g[i]) {
                i--;
            }
            j++;
            if (j >= s.length) {
                return i + 1;
            }
        }
        return g.length;
    }
}
