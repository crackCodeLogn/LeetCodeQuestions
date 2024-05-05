package leetcode.contest.weekly.w396_202405;

public class Q3138_M_MinimumLengthOfAnagramConcatenation {

    private static int getGcd(int a, int b) {
        if (a == 0) return b;
        return getGcd(b % a, a);
    }

    public static void main(String[] args) {
        Q3138_M_MinimumLengthOfAnagramConcatenation q3138MMinimumLengthOfAnagramConcatenation = new Q3138_M_MinimumLengthOfAnagramConcatenation();
        System.out.println(q3138MMinimumLengthOfAnagramConcatenation.minAnagramLength("abba")); // 2
        System.out.println(q3138MMinimumLengthOfAnagramConcatenation.minAnagramLength("cdef")); // 4
        System.out.println(q3138MMinimumLengthOfAnagramConcatenation.minAnagramLength("jjj")); // 1
        System.out.println(q3138MMinimumLengthOfAnagramConcatenation.minAnagramLength("abbaab")); // 2
        System.out.println(q3138MMinimumLengthOfAnagramConcatenation.minAnagramLength("oionssonoi")); // 5
        System.out.println(q3138MMinimumLengthOfAnagramConcatenation.minAnagramLength("lbuorourlb")); // 5
        System.out.println(q3138MMinimumLengthOfAnagramConcatenation.minAnagramLength("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); // 1
        System.out.println(q3138MMinimumLengthOfAnagramConcatenation.minAnagramLength("abcabca")); // ?

    }

    public int minAnagramLength(String s) { // AC, solved post contest
        int[] data = new int[26];
        for (int i = 0; i < s.length(); i++) data[s.charAt(i) - 'a']++;
        int min = 0;
        int sum = 0;
        for (int i = 0; i < 26; i++)
            if (data[i] > 0) {
                min = min == 0 ? data[i] : getGcd(min, data[i]);
                sum += data[i];
            }
        return min == 0 ? s.length() : sum / min;
    }

    public int minAnagramLength2(String s) { // WA, during contest
        int[] data = new int[26];
        for (int i = 0; i < s.length(); i++) data[s.charAt(i) - 'a']++;
        int min = Integer.MAX_VALUE;
        int cnt = 0, sum = 0;
        for (int i = 0; i < 26; i++)
            if (data[i] > 0) {
                min = Math.min(min, data[i]);
                cnt++;
                sum += data[i];
            }
        if (min == 1) return s.length();
        if (cnt == 1) return 1;

        for (int i = 0; i < 26; i++) if (data[i] > 0 && data[i] % min != 0) return s.length();
        return sum / min;
    }
}
