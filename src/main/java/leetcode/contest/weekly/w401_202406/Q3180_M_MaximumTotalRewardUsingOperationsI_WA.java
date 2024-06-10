package leetcode.contest.weekly.w401_202406;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-06-09
 */
public class Q3180_M_MaximumTotalRewardUsingOperationsI_WA {
    private Map<String, Integer> data;
    private int[] rewardValues;

    public static int maxTotalReward(int[] rewardValues) {
        List<Integer> list = new ArrayList<>();
        for (int v : rewardValues) list.add(v);
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < rewardValues.length; i++) rewardValues[i] = list.get(i);
        // Arrays.sort(rewardValues);  // Sort descending
        int totalReward = 0;
        int marked = 0;
        for (int reward : rewardValues) {
            if (marked < rewardValues.length - 1 && reward > totalReward) {
                totalReward += reward;
                marked++;
            }
        }
        return totalReward;
    }

    public static void main(String[] args) {
        Q3180_M_MaximumTotalRewardUsingOperationsI_WA q3180MMaximumTotalRewardUsingOperationsIWA = new Q3180_M_MaximumTotalRewardUsingOperationsI_WA();
        System.out.println(maxTotalReward(new int[]{1, 1, 3, 3})); // 4
        System.out.println(maxTotalReward(new int[]{1, 6, 4, 3, 2})); // 11
        System.out.println(maxTotalReward(new int[]{14, 3, 8, 2, 4, 5, 19})); // 37
    }

    public int maxTotalReward2(int[] rewardValues) {
        Arrays.sort(rewardValues);
        this.rewardValues = rewardValues;
        data = new HashMap<>();

        return compute(0, 0);
    }

    private int compute(int i, int reward) {
        if (i >= rewardValues.length) return reward;
        String key = String.format("%d,%d", i, reward);
        if (data.containsKey(key)) return data.get(key);
        //System.out.printf("%d %d\n", i, reward);

        int v1 = 0;
        if (rewardValues[i] > reward) {
            v1 = compute(i + 1, reward + rewardValues[i]);
        }
        int v2 = compute(i + 1, reward);
        int v = Math.max(v1, v2);
        //System.out.printf("\t\t> %d %d %d\n", v, v1, v2);
        data.put(key, v);
        return v;
    }
}
