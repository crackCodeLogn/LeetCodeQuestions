package leetcode.practise;

public class Q1208_M_GetEqualSubstringsWithinBudget {

    public static void main(String[] args) {
        Q1208_M_GetEqualSubstringsWithinBudget q1208MGetEqualSubstringsWithinBudget = new Q1208_M_GetEqualSubstringsWithinBudget();
        System.out.println(q1208MGetEqualSubstringsWithinBudget.equalSubstring("abcd", "bcdf", 3));
        System.out.println(q1208MGetEqualSubstringsWithinBudget.equalSubstring("abcd", "cdef", 3));
        System.out.println(q1208MGetEqualSubstringsWithinBudget.equalSubstring("abcd", "acde", 0));
        System.out.println(q1208MGetEqualSubstringsWithinBudget.equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
    }

    public int equalSubstring(String s, String t, int maxCost) { // 5ms - beats 97%
        int cost = 0, maxLength = 0, n = s.length();
        int[] delta = new int[n];
        for (int i = 0; i < n; i++) delta[i] = Math.abs(t.charAt(i) - s.charAt(i));
        int run = 0;
        for (int i = 0, j = 0; i < n; ) {
            while (j < n && cost + delta[j] <= maxCost) {
                cost += delta[j];
                run++;
                j++;
            }
            maxLength = Math.max(maxLength, run);
            if (j == n) {
                return maxLength;
            }
            cost -= delta[i];
            run--;
            i++;
        }

        return maxLength;
    }
}
