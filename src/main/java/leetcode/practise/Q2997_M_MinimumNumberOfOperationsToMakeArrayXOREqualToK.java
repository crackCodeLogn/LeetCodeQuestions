package leetcode.practise;

public class Q2997_M_MinimumNumberOfOperationsToMakeArrayXOREqualToK {

    public static void main(String[] args) {
        Q2997_M_MinimumNumberOfOperationsToMakeArrayXOREqualToK q2997MMinimumNumberOfOperationsToMakeArrayXOREqualToK = new Q2997_M_MinimumNumberOfOperationsToMakeArrayXOREqualToK();
        System.out.println(q2997MMinimumNumberOfOperationsToMakeArrayXOREqualToK.minOperations(new int[]{2, 1, 3, 4}, 1)); // 2
        System.out.println(q2997MMinimumNumberOfOperationsToMakeArrayXOREqualToK.minOperations(new int[]{2, 0, 2, 0}, 0)); // 0
    }

    public int minOperations(int[] nums, int k) { // 1ms
        int data = 0;
        for (int num : nums) data ^= num;

        int cnt = 0;
        while (data > 0 && k > 0) {
            if ((data & 1) != (k & 1)) cnt++;
            data >>= 1;
            k >>= 1;
        }
        while (k > 0) {
            if ((k & 1) == 1) cnt++;
            k >>= 1;
        }
        while (data > 0) {
            if ((data & 1) == 1) cnt++;
            data >>= 1;
        }
        return cnt;
    }

    public int minOperations2(int[] nums, int k) { // 2ms
        int data = 0;
        for (int num : nums) data ^= num;

        int cnt = 0;
        String s1 = Integer.toBinaryString(data), s2 = Integer.toBinaryString(k);
        if (s2.length() < s1.length()) {
            String x = s1;
            s1 = s2;
            s2 = x;
        }
        StringBuilder s11 = new StringBuilder(s1);
        while (s11.length() != s2.length()) s11.insert(0, '0');
        for (int i = 0; i < s11.length(); i++) if (s11.charAt(i) != s2.charAt(i)) cnt++;
        return cnt;
    }
}
