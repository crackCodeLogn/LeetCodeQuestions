package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-13
 */
public class Q1347_M_MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public static void main(String[] args) {
        Q1347_M_MinimumNumberOfStepsToMakeTwoStringsAnagram q1347MMinimumNumberOfStepsToMakeTwoStringsAnagram = new Q1347_M_MinimumNumberOfStepsToMakeTwoStringsAnagram();
        System.out.println(q1347MMinimumNumberOfStepsToMakeTwoStringsAnagram.minSteps("bab", "aba")); // 1
        System.out.println(q1347MMinimumNumberOfStepsToMakeTwoStringsAnagram.minSteps("leetcode", "practice")); // 5
        System.out.println(q1347MMinimumNumberOfStepsToMakeTwoStringsAnagram.minSteps("gctcxyuluxjuxnsvmomavutrrfb", "qijrjrhqqjxjtprybrzpyfyqtzf")); //18
    }

    public int minSteps(String s, String t) {
        int[] cnt1 = new int[27];
        int[] cnt2 = new int[27];
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) cnt1[s.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++) cnt2[t.charAt(i) - 'a']++;
        for (int i = 0; i < 27; i++) {
            cnt2[i] -= cnt1[i];
            if (cnt2[i] != 0) cnt += Math.abs(cnt2[i]);
        }
        return cnt >> 1;
    }

}
