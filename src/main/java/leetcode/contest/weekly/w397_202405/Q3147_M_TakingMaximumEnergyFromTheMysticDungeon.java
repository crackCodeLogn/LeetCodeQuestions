package leetcode.contest.weekly.w397_202405;

public class Q3147_M_TakingMaximumEnergyFromTheMysticDungeon {

    public static void main(String[] args) {
        Q3147_M_TakingMaximumEnergyFromTheMysticDungeon q3147MTakingMaximumEnergyFromTheMysticDungeon = new Q3147_M_TakingMaximumEnergyFromTheMysticDungeon();
        System.out.println(q3147MTakingMaximumEnergyFromTheMysticDungeon.maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3)); // 3
        System.out.println(q3147MTakingMaximumEnergyFromTheMysticDungeon.maximumEnergy(new int[]{-2, -3, -1}, 2)); // -1
    }

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] data = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            data[i] = energy[i];
            if (i + k < n) data[i] += data[i + k];
            max = Math.max(max, data[i]);
        }
        return max;
    }
}
