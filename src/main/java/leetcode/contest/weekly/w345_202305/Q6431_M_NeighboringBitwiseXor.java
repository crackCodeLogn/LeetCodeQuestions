package leetcode.contest.weekly.w345_202305;

public class Q6431_M_NeighboringBitwiseXor {

    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        if (n == 1) {
            return derived[0] == 0;
        }
        if (n == 2) {
            return derived[0] == derived[1];
        }
        boolean[] data = new boolean[n];
        data[0] = true;
        data[1] = derived[0] != 1;

        for (int i = 2; i < n; i++) {
            if (derived[i - 1] == 1)
                data[i] = !data[i - 1];
            else
                data[i] = data[i - 1];
        }
        return ((data[0] ^ data[n - 1]) ? 1 : 0) == derived[n - 1];
    }

    public static void main(String[] args) {
        Q6431_M_NeighboringBitwiseXor q6341MNeighboringBitwiseXor = new Q6431_M_NeighboringBitwiseXor();
        System.out.println(q6341MNeighboringBitwiseXor.doesValidArrayExist(new int[]{
                1, 1, 0
        }));
        System.out.println(q6341MNeighboringBitwiseXor.doesValidArrayExist(new int[]{
                0, 0, 1
        }));
        System.out.println(q6341MNeighboringBitwiseXor.doesValidArrayExist(new int[]{
                0, 1, 1
        }));
        System.out.println(q6341MNeighboringBitwiseXor.doesValidArrayExist(new int[]{
                1, 1, 1
        }));
    }
}
