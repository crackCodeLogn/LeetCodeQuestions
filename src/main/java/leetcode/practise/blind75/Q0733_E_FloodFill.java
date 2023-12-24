package leetcode.practise.blind75;

/**
 * @author Vivek
 * @since 2023-12-24
 */
public class Q0733_E_FloodFill {
    int[] x = {0, 0, +1, -1};
    int[] y = {-1, +1, 0, 0};

    public static void main(String[] args) {
        Q0733_E_FloodFill q0733EFloodFill = new Q0733_E_FloodFill();
        int[][] data = q0733EFloodFill.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        System.out.println(data);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        floodFillHelper(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public int[][] floodFillHelper(int[][] image, int sr, int sc, int color, int srcColor) {
        int n = image.length, m = image[0].length;
        if (sr < 0 || sr >= n || sc < 0 || sc >= m) return image;

        if (srcColor == image[sr][sc])
            image[sr][sc] = color;
        else return image;
        for (int k = 0; k < 4; k++) {
            //if (srcColor == image[sr + x[k]][sc + y[k]])
            floodFillHelper(image, sr + x[k], sc + y[k], color, srcColor);
        }
        return image;
    }
}
