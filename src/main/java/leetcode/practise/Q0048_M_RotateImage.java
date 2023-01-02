package leetcode.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vivek
 * @since 2023-01-02
 */
public class Q0048_M_RotateImage {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        Q0048_M_RotateImage q0048MRotateImage = new Q0048_M_RotateImage();
        int[][] matrix;
        matrix = q0048MRotateImage.process("[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]");
        //matrix = q0048MRotateImage.process("[1,2,3],[4,5,6],[7,8,9]");
        //matrix = q0048MRotateImage.process("[1,2],[3,4]");
        //matrix = q0048MRotateImage.process("[3]");
        q0048MRotateImage.rotate(matrix);
        printMatrix(matrix, matrix.length, matrix.length);
        out.flush();
        out.close();
        in.close();
    }

    private static void printMatrix(int[][] data, int rows, int columns) {
        for (int i = -1; ++i < rows; ) {
            for (int j = -1; ++j < columns; ) out.print(data[i][j] + " ");
            out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return;

        List<Integer> buffer = new ArrayList<>();
        int iL = 0;
        while (n > 1) {
            List<Integer> first = new ArrayList<>(n);
            List<Integer> second = new ArrayList<>(n);
            List<Integer> third = new ArrayList<>(n);
            List<Integer> fourth = new ArrayList<>(n);

            for (int j = iL; j < n; j++) first.add(matrix[iL][j]);
            for (int j = iL; j < n; j++) second.add(matrix[j][n - 1]);
            for (int j = n - 1; j >= iL; j--) third.add(matrix[n - 1][j]);
            for (int j = n - 1; j >= iL; j--) fourth.add(matrix[j][iL]);

//            System.out.println(first);
//            System.out.println(second);
//            System.out.println(third);
//            System.out.println(fourth);
//            System.out.println("----");

            int i = 0;
            buffer = second;
            for (int j = iL; j < n; j++) matrix[j][n - 1] = first.get(i++);
            i = 0;
            for (int j = iL; j < n; j++) matrix[iL][j] = fourth.get(i++);
            i = 0;
            for (int j = n - 1; j >= iL; j--) matrix[j][iL] = third.get(i++);
            i = 0;
            for (int j = n - 1; j >= iL; j--) matrix[n - 1][j] = buffer.get(i++);

            n--;
            iL++;
        }
    }

    private int[][] process(String input) {
        List<String> splits = Arrays.stream(input.split("],"))
                .map(val -> val.replaceAll("\\[", "")
                        .replaceAll("]", ""))
                .collect(Collectors.toList());
        int n = splits.get(0).split(",").length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] val = splits.get(i).split(",");
            for (int j = 0; j < n; j++) matrix[i][j] = Integer.parseInt(val[j]);
        }
        //printMatrix(matrix, n, n);
        return matrix;
    }
}