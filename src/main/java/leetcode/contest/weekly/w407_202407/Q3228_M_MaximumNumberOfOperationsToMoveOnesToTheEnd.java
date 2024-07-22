package leetcode.contest.weekly.w407_202407;

/**
 * @author Vivek
 * @since 2024-07-21
 */
public class Q3228_M_MaximumNumberOfOperationsToMoveOnesToTheEnd {

    public static void main(String[] args) {
        Q3228_M_MaximumNumberOfOperationsToMoveOnesToTheEnd q3228MMaximumNumberOfOperationsToMoveOnesToTheEnd = new Q3228_M_MaximumNumberOfOperationsToMoveOnesToTheEnd();
        System.out.println(q3228MMaximumNumberOfOperationsToMoveOnesToTheEnd.maxOperations("1001101")); // 4
        System.out.println(q3228MMaximumNumberOfOperationsToMoveOnesToTheEnd.maxOperations("00111")); // 0
        System.out.println(q3228MMaximumNumberOfOperationsToMoveOnesToTheEnd.maxOperations("001110100")); // 3
        System.out.println(q3228MMaximumNumberOfOperationsToMoveOnesToTheEnd.maxOperations("0000")); // 0
        System.out.println(q3228MMaximumNumberOfOperationsToMoveOnesToTheEnd.maxOperations("11111")); // 0
    }

    public int maxOperations(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start++) == '0') ;
        if (start == s.length()) return 0;
        start--;
        s = s.substring(start);
        int n = s.length();

        boolean any = false;
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '0') {
                any = true;
                break;
            }
        if (!any) return 0;

        int sum = 0, cnt = 1, i = 1;
        boolean flag = false;

        while (i <= s.length()) {
            if (i == s.length()) { // reached end
                return sum + (s.charAt(i - 1) == '0' ? cnt : 0);
            }
            char ch = s.charAt(i);
            cnt++;
            if (ch == '0') {
                flag = true;
                cnt--;
            } else if (flag) { // encountered stopping point
                flag = false;
                sum += cnt - 1;
            }
            i++;
        }
        return sum;
    }
}
