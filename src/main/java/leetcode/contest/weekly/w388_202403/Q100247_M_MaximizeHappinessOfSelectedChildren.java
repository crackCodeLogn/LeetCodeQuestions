package leetcode.contest.weekly.w388_202403;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-03-10
 */
public class Q100247_M_MaximizeHappinessOfSelectedChildren {

    public static void main(String[] args) {
        Q100247_M_MaximizeHappinessOfSelectedChildren q100247MMaximizeHappinessOfSelectedChildren = new Q100247_M_MaximizeHappinessOfSelectedChildren();
        System.out.println(q100247MMaximizeHappinessOfSelectedChildren.maximumHappinessSum(new int[]{1, 2, 3}, 2));
        System.out.println(q100247MMaximizeHappinessOfSelectedChildren.maximumHappinessSum(new int[]{1, 1, 1, 1}, 2));
        System.out.println(q100247MMaximizeHappinessOfSelectedChildren.maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
        System.out.println(q100247MMaximizeHappinessOfSelectedChildren.maximumHappinessSum(new int[]{2, 3, 4, 5}, 4));
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long cnt = 0;
        for (int i = happiness.length - 1, counter = 0; i >= 0 && k > 0; i--, k--, counter++) {
            happiness[i] = Math.max(0, happiness[i] - counter);
            if (happiness[i] == 0) return cnt;
            cnt += happiness[i];
        }
        return cnt;
    }
}
