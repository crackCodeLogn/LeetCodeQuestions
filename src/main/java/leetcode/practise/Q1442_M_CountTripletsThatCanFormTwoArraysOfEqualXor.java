package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-05-31
 */
public class Q1442_M_CountTripletsThatCanFormTwoArraysOfEqualXor {

    public static void main(String[] args) {
        Q1442_M_CountTripletsThatCanFormTwoArraysOfEqualXor q1442MCountTripletsThatCanFormTwoArraysOfEqualXor = new Q1442_M_CountTripletsThatCanFormTwoArraysOfEqualXor();
        System.out.println(q1442MCountTripletsThatCanFormTwoArraysOfEqualXor.countTriplets(new int[]{2, 3, 1, 6, 7})); // 4
        System.out.println(q1442MCountTripletsThatCanFormTwoArraysOfEqualXor.countTriplets(new int[]{1, 1, 1, 1, 1})); // 10
    }

    public int countTriplets(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int[] xors = new int[n + 1];
        int prefix = 0;

        for (int i = 0; i < n; i++) {
            prefix ^= arr[i];
            xors[i + 1] = prefix;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int xors_i = xors[j] ^ xors[i];
                for (int k = j; k < n; k++) {
                    int xors_k = xors[k + 1] ^ xors[j];
                    if (xors_i == xors_k) {
                        ans += 1;
                    }
                }
            }
        }

        return ans;
    }
}
