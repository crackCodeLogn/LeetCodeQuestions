package leetcode.contest.weekly.w345_202305;

public class Q6433_M_MaximumNumberOfMovesInGrid {
    private static final int[] DIR = {-1, 0, +1};

    public int maxMoves(int[][] grid) {
        int max = 0;
        int[][] data = new int[grid.length][grid[0].length];
        for (int j = grid[0].length - 2; j >= 0; j--) {
            for (int i = 0; i < grid.length; i++) {
                for (int k = 0; k < DIR.length; k++) {
                    try {
                        int target = grid[i + DIR[k]][j + 1];
                        if (target > grid[i][j]) {
                            data[i][j] = Math.max(data[i][j], 1 + data[i + DIR[k]][j + 1]);
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, data[i][0]);
        }
        return max;
    }

    public static void main(String[] args) {
        Q6433_M_MaximumNumberOfMovesInGrid q6433MMaximumNumberOfMovesInGrid = new Q6433_M_MaximumNumberOfMovesInGrid();
        /*System.out.println(q3.maxMoves(new int[][]{
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        }));
        System.out.println(q3.maxMoves(new int[][]{
                {3, 2, 4},
                {2, 1, 9},
                {1, 1, 7}
        }));*/
        System.out.println(q6433MMaximumNumberOfMovesInGrid.maxMoves(new int[][]{
                {65, 200, 263, 220, 91, 183, 2, 187, 175, 61, 225, 120, 39},
                {111, 242, 294, 31, 241, 90, 145, 25, 262, 214, 145, 71, 294},
                {152, 25, 240, 69, 279, 238, 222, 9, 137, 277, 8, 143, 143},
                {189, 31, 86, 250, 20, 63, 188, 209, 75, 22, 127, 272, 110},
                {122, 94, 298, 25, 90, 169, 68, 3, 208, 274, 202, 135, 275},
                {205, 20, 171, 90, 70, 272, 280, 138, 142, 151, 80, 122, 130},
                {284, 272, 271, 269, 265, 134, 185, 243, 247, 50, 283, 20, 232},
                {266, 236, 265, 234, 249, 62, 98, 130, 122, 226, 285, 168, 204},
                {231, 24, 256, 101, 142, 28, 268, 82, 111, 63, 115, 13, 144},
                {277, 277, 31, 144, 49, 132, 28, 138, 133, 29, 286, 45, 93},
                {163, 96, 25, 9, 3, 159, 148, 59, 25, 81, 233, 127, 12},
                {127, 38, 31, 209, 300, 256, 15, 43, 74, 64, 73, 141, 200}
        }));
    }
}
