package leetcode.contest.weekly.w383_202402;

/**
 * @author Vivek
 * @since 2024-02-04
 */
public class Q100204_M_MinimumTimeToRevertWordToInitialStateI {

    public static void main(String[] args) {
        Q100204_M_MinimumTimeToRevertWordToInitialStateI q100204MMinimumTimeToRevertWordToInitialStateI = new Q100204_M_MinimumTimeToRevertWordToInitialStateI();
        System.out.println(q100204MMinimumTimeToRevertWordToInitialStateI.minimumTimeToInitialState("abacaba", 3)); // 2
        System.out.println(q100204MMinimumTimeToRevertWordToInitialStateI.minimumTimeToInitialState("abacaba", 4)); // 1
        System.out.println(q100204MMinimumTimeToRevertWordToInitialStateI.minimumTimeToInitialState("abcbabcd", 2)); // 4
        System.out.println(q100204MMinimumTimeToRevertWordToInitialStateI.minimumTimeToInitialState("aab", 2)); // 4
    }

    public int minimumTimeToInitialState(String word, int k) {
        String src = word;
        int cnt = 0;
        while (!word.isEmpty()) {
            if (k >= word.length()) {
                cnt++;
                break;
            }
            word = word.substring(k);
            cnt++;
            if (word.isEmpty() || src.startsWith(word)) {
                break;
            }
        }
        return cnt;
    }
}
