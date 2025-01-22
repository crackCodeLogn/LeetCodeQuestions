package leetcode.practise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2025-01-21
 */
public class Q1765_M_MapOfHighestPeak {

  private static final int[] X_4W = {0, 1, 0, -1};
  private static final int[] Y_4W = {1, 0, -1, 0};
  private int n, m;
  private int[][] data;

  public static void main(String[] args) {
    Q1765_M_MapOfHighestPeak q1765MMapOfHighestPeak = new Q1765_M_MapOfHighestPeak();
    System.out.println(
        Arrays.deepToString(
            q1765MMapOfHighestPeak.highestPeak(
                new int[][] {
                  {0, 0, 1},
                  {1, 0, 0},
                  {0, 0, 0},
                })));
    System.out.println(
        Arrays.deepToString(
            q1765MMapOfHighestPeak.highestPeak(
                new int[][] {
                  {0, 1},
                  {0, 0},
                })));
  }

  public int[][] highestPeak(int[][] isWater) {
    this.n = isWater.length;
    this.m = isWater[0].length;
    data = new int[n][m];

    Queue<Pair> queue = new LinkedList<>();
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        data[i][j] = -1;
        if (isWater[i][j] == 1) {
          queue.add(new Pair(i, j));
          data[i][j] = 0;
        }
      }

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int x = pair.i, y = pair.j;
      for (int k = 0; k < 4; k++) {
        int nx = x + X_4W[k];
        int ny = y + Y_4W[k];
        if (!isValid(nx, ny) || data[nx][ny] != -1) continue;
        data[nx][ny] = data[x][y] + 1;
        queue.add(new Pair(nx, ny));
      }
    }

    return data;
  }

  public int[][] highestPeak2(int[][] isWater) {
    this.n = isWater.length;
    this.m = isWater[0].length;
    data = new int[n][m];

    Queue<Pair2> queue = new LinkedList<>();
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        data[i][j] = -1;
        if (isWater[i][j] == 1) {
          queue.add(new Pair2(i, j, 0));
          data[i][j] = 0;
        }
      }

    while (!queue.isEmpty()) {
      Pair2 pair = queue.poll();
      boolean[][] visited = new boolean[n][m];
      compute2(pair.i, pair.j, visited);
    }

    return data;
  }

  private void compute2(int i, int j, boolean[][] visited) {
    Queue<Pair2> queue = new LinkedList<>();
    queue.add(new Pair2(i, j, 0));
    while (!queue.isEmpty()) {
      Pair2 pair = queue.poll();
      int x = pair.i;
      int y = pair.j;
      int level = pair.level;
      if (visited[x][y]) continue;
      visited[x][y] = true;
      level++;

      for (int k = 0; k < 4; k++) {
        int nx = x + X_4W[k];
        int ny = y + Y_4W[k];
        if (isValid(nx, ny)
            && !visited[nx][ny]
            && data[nx][ny] != 0
            && (data[nx][ny] == -1 || Math.abs(data[x][y] - data[nx][ny]) >= 1)) {
          data[nx][ny] = level;
          queue.add(new Pair2(nx, ny, level));
        }
      }
    }
  }

  private boolean isValid(int i, int j) {
    return i >= 0 && i < n && j >= 0 && j < m;
  }

  private record Pair2(int i, int j, int level) {}

  private record Pair(int i, int j) {}
}
