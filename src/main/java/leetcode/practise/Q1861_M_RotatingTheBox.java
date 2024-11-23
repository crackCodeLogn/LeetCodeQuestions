package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-11-23
 */
public class Q1861_M_RotatingTheBox {
  public static void main(String[] args) {
    Q1861_M_RotatingTheBox q1861MRotatingTheBox = new Q1861_M_RotatingTheBox();
    System.out.println(
        Arrays.deepToString(q1861MRotatingTheBox.rotateTheBox(new char[][] {{'#', '.', '#'}})));
    System.out.println(
        Arrays.deepToString(
            q1861MRotatingTheBox.rotateTheBox(
                new char[][] {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}})));
    System.out.println(
        Arrays.deepToString(
            q1861MRotatingTheBox.rotateTheBox(
                new char[][] {
                  {'#', '#', '*', '.', '*', '.'},
                  {'#', '#', '#', '*', '.', '.'},
                  {'#', '#', '#', '.', '#', '.'}
                })));
  }

  public char[][] rotateTheBox(char[][] box) {
    int n = box.length, m = box[0].length;
    char[][] data = new char[m][n];
    for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) data[j][n - i - 1] = box[i][j];

    for (int j = 0; j < n; j++) {
      int lastPlace = m - 1;
      for (int i = m - 1; i >= 0; i--) {
        if (data[i][j] == '#' && lastPlace >= 0) {
          data[lastPlace][j] = data[i][j];
          if (lastPlace != i) data[i][j] = '.';
          lastPlace--;
        } else if (data[i][j] == '*' || data[i][j] == '#') lastPlace = i - 1;
      }
    }
    return data;
  }
}
