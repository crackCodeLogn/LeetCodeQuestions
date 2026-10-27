package leetcode.practise;

import java.util.Arrays;

public class Q3963_E_CreateGridWithExactlyOnePath {
  public String[] createGrid(int m, int n) { // 4ms, beats 24.03%
    String[] data = new String[m];
    boolean[][] mat = new boolean[m][n];
    for (int i = 0; i < m; i++) mat[i][0] = true;
    for (int j = 0; j < n; j++) mat[m - 1][j] = true;
    for (int i = 0; i < m; i++) {
      StringBuilder build = new StringBuilder();
      for (int j = 0; j < n; j++) build.append(mat[i][j] ? '.' : '#');
      data[i] = build.toString();
    }
    return data;
  }

  public static void main(String[] args) {
    Q3963_E_CreateGridWithExactlyOnePath q3963ECreateGridWithExactlyOnePath =
        new Q3963_E_CreateGridWithExactlyOnePath();
    System.out.println(Arrays.toString(q3963ECreateGridWithExactlyOnePath.createGrid(2, 3)));
    System.out.println(Arrays.toString(q3963ECreateGridWithExactlyOnePath.createGrid(3, 3)));
    System.out.println(Arrays.toString(q3963ECreateGridWithExactlyOnePath.createGrid(1, 4)));
    System.out.println(Arrays.toString(q3963ECreateGridWithExactlyOnePath.createGrid(1, 1)));
  }
}
