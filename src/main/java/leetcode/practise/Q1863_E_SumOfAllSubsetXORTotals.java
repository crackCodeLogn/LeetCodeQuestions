package leetcode.practise;

public class Q1863_E_SumOfAllSubsetXORTotals {
    private int[] nums;

    public static void main(String[] args) {
        Q1863_E_SumOfAllSubsetXORTotals q1863ESumOfAllSubsetXORTotals = new Q1863_E_SumOfAllSubsetXORTotals();
        System.out.println(q1863ESumOfAllSubsetXORTotals.subsetXORSum(new int[]{1, 3})); // 6
        System.out.println(q1863ESumOfAllSubsetXORTotals.subsetXORSum(new int[]{5, 1, 6})); // 28
        System.out.println(q1863ESumOfAllSubsetXORTotals.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8})); // 480
    }

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        return compute(0, 0);
    }

    private int compute(int i, int sum) {
        if (i >= nums.length) return sum;
        return compute(i + 1, sum ^ nums[i]) + compute(i + 1, sum);
    }
}
