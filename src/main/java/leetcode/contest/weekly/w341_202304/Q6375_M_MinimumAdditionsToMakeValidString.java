package leetcode.contest.weekly.w341_202304;

/**
 * @author Vivek
 * @since 2023-04-16
 */
public class Q6375_M_MinimumAdditionsToMakeValidString {


    public static void main(String[] args) {
        Q6375_M_MinimumAdditionsToMakeValidString q6375MMinimumAdditionsToMakeValidString = new Q6375_M_MinimumAdditionsToMakeValidString();
        System.out.println(q6375MMinimumAdditionsToMakeValidString.addMinimum("b"));
        System.out.println(q6375MMinimumAdditionsToMakeValidString.addMinimum("aaa"));
        System.out.println(q6375MMinimumAdditionsToMakeValidString.addMinimum("abc"));
    }

    public int addMinimum(String word) {
        StringBuilder data = new StringBuilder(word);
        int cnt = 0;
        char ch0 = word.charAt(0);
        if (ch0 != 'a') {
            if (ch0 == 'b') cnt++;
            else cnt += 2;
        }

        outer:
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch == 'a') {
                if (i + 1 == data.length()) {
                    cnt += 2;
                    break;
                }
                if (data.charAt(i + 1) == 'a') cnt += 2;
                else if (data.charAt(i + 1) == 'b') continue;
                else cnt++;
            } else if (ch == 'b') {
                if (i + 1 == data.length()) {
                    cnt++;
                    break;
                }
                if (data.charAt(i + 1) == 'a') cnt++;
                else if (data.charAt(i + 1) == 'c') continue;
                else cnt += 2;
            } else {
                if (i + 1 == data.length()) {
                    break;
                }
                if (data.charAt(i + 1) == 'a') continue;
                else if (data.charAt(i + 1) == 'b') cnt++;
                else cnt += 2;
            }
        }
        return cnt;
    }
}
