package leetcode.contest.weekly.w383_202402;

/**
 * @author Vivek
 * @since 2024-02-04
 */
public class Q100189_M_FindTheGridOfRegionAverage {

    private static final int[] X = {-1, +1, 0, 0};
    private static final int[] Y = {0, 0, -1, +1};
    private int n;
    private int m;
    private int threshold;
    private Cell[][] data;
    private int[][] image;

    public static void main(String[] args) {
        Q100189_M_FindTheGridOfRegionAverage q100189MFindTheGridOfRegionAverage = new Q100189_M_FindTheGridOfRegionAverage();
        int[][] ans;
        ans = q100189MFindTheGridOfRegionAverage.resultGrid(new int[][]{
                {5, 6, 7, 10}, {8, 9, 10, 10}, {11, 12, 13, 10}
        }, 3);
        printMatrix(ans);

        ans = q100189MFindTheGridOfRegionAverage.resultGrid(new int[][]{
                {10, 20, 30}, {15, 25, 35}, {20, 30, 40}, {25, 35, 45}
        }, 12);
        printMatrix(ans);

        ans = q100189MFindTheGridOfRegionAverage.resultGrid(new int[][]{
                {5, 6, 7}, {8, 9, 10}, {11, 12, 13}
        }, 1);
        printMatrix(ans);


        ans = q100189MFindTheGridOfRegionAverage.resultGrid(new int[][]{
                {1, 1, 4, 1}, {10, 8, 13, 17}, {2, 12, 1, 16}
        }, 14); //[[5,5,5,1],[5,5,5,17],[5,5,5,16]]
        printMatrix(ans);

    }

    private static void printMatrix(int[][] data) {
        for (int i = -1; ++i < data.length; ) {
            for (int j = -1; ++j < data[0].length; ) System.out.print(data[i][j] + " ");
            System.out.println();
        }
    }

    public int[][] resultGrid(int[][] image, int threshold) {
        this.threshold = threshold;
        this.n = image.length;
        this.m = image[0].length;
        this.data = new Cell[n][m];
        this.image = image;
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isEligible(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = data[i][j] == null ? image[i][j] : data[i][j].getAvg();
            }
        }
        return result;
    }

    private boolean reject(int i, int j, int tx, int ty, int boundI, int boundJ) {
        if (tx < boundI || ty < boundJ || tx >= boundI + 3 || ty >= boundJ + 3)
            return false;
        return Math.abs(image[tx][ty] - image[i][j]) > threshold;
    }

    private boolean isEligible(int si, int sj) {
        if (si + 3 > n || sj + 3 > m) return false;
        int avg = 0, tx, ty;
        for (int i = si; i < si + 3; i++) {
            for (int j = sj; j < sj + 3; j++) {
                for (int k = 0; k < 4; k++) {
                    if (reject(i, j, i + X[k], j + Y[k], si, sj)) return false;
                }
            }
        }
        /*if (reject(i, j, i, j + 1)) return false;
        if (reject(i, j, i + 1, j)) return false;
        if (reject(i, j + 2, i, j + 1)) return false;
        if (reject(i, j + 2, i + 1, j + 2)) return false;

        if (reject(i + 2, j, i + 1, j)) return false;
        if (reject(i + 2, j, i + 2, j + 1)) return false;
        if (reject(i + 2, j + 2, i + 1, j + 2)) return false;
        if (reject(i + 2, j + 2, i + 2, j + 1)) return false;

        for (int k = 0; k < 4; k++) {
            if (reject(i + 1, j + 1, i + 1 + X[k], j + 1 + Y[k])) return false;
        }*/
        int i = si, j = sj;
        for (int a = i; a < i + 3; a++) {
            for (int b = j; b < j + 3; b++) {
                avg += image[a][b];
            }
        }
        avg /= 9;
        for (int a = i; a < i + 3; a++) {
            for (int b = j; b < j + 3; b++) {
                if (data[a][b] == null) data[a][b] = new Cell(avg);
                else data[a][b].add(avg);
            }
        }
        return true;
    }

    private static class Cell {
        private int sum = 0;
        private int cnt = 0;

        public Cell(int sum) {
            this.sum = sum;
            this.cnt = 1;
        }

        public void add(int sum) {
            this.sum += sum;
            this.cnt++;
        }

        public int getAvg() {
            return sum / cnt;
        }
    }

}
