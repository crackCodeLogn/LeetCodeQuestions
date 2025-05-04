package leetcode.contest.weekly.w448_202505;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-05-03
 */
public class Q3537_M_FillASpecialGrid {

  private final int[] moveX = {0, +1, 0};
  private final int[] moveY = {+1, 0, -1};
  private int[][] data;
  private int counter;

  public static void main(String[] args) {
    Q3537_M_FillASpecialGrid q3537MFillASpecialGrid = new Q3537_M_FillASpecialGrid();
    System.out.println(Arrays.deepToString(q3537MFillASpecialGrid.specialGrid(0)));
    System.out.println(Arrays.deepToString(q3537MFillASpecialGrid.specialGrid(1)));
    System.out.println(Arrays.deepToString(q3537MFillASpecialGrid.specialGrid(2)));
    System.out.println(Arrays.deepToString(q3537MFillASpecialGrid.specialGrid(3)));

    System.out.println(Arrays.deepToString(q3537MFillASpecialGrid.specialGrid(4)));
  }

  public int[][] specialGrid(int N) {
    if (N == 0) return new int[][] {{0}};
    if (N == 1) return new int[][] {{3, 0}, {2, 1}};

    counter = (int) Math.pow(2, 2 * N);
    int n = (int) Math.pow(2, N);
    data = new int[n][n];

    int majSteps = n / 2;
    compute(0, 0, majSteps);
    /*List<int[]> moves = new ArrayList<>();
    moves.add(new int[] {0, 0});
    for (int i = 0; i < 3; i++) {
      int[] lastMove = moves.get(moves.size() - 1);
      int ny = lastMove[0] + majSteps * moveY[i];
      int nx = lastMove[1] + majSteps * moveX[i];
      moves.add(new int[] {ny, nx});
    }
    majSteps /= 2;
    for (int[] move : moves) {
      List<int[]> internalMoves = new ArrayList<>();
      internalMoves.add(new int[] {move[0], move[1]});
      for (int i = 0; i < 3; i++) {
        int[] lastMove = internalMoves.get(internalMoves.size() - 1);
        int ny = lastMove[0] + majSteps * moveY[i];
        int nx = lastMove[1] + majSteps * moveX[i];
        internalMoves.add(new int[] {ny, nx});
      }

      for (int[] internalMove : internalMoves) {
        compute1(internalMove[0], internalMove[1], majSteps);
      }
    }*/

    return data;
  }

  private void compute(int y, int x, int majSteps) {
    if (majSteps == 1) {
      compute0(y, x);
      return;
    }
    List<int[]> moves = new ArrayList<>();
    moves.add(new int[] {y, x});
    for (int i = 0; i < 3; i++) {
      int[] lastMove = moves.get(moves.size() - 1);
      int ny = lastMove[0] + majSteps * moveY[i];
      int nx = lastMove[1] + majSteps * moveX[i];
      moves.add(new int[] {ny, nx});
    }
    majSteps /= 2;
    for (int[] move : moves) {
      compute(move[0], move[1], majSteps);
    }
  }

  private void compute0(int y, int x) {
    data[y][x] = --counter;
    data[y + 1][x] = --counter;
    data[y + 1][x + 1] = --counter;
    data[y][x + 1] = --counter;
  }

  private void compute1(int y, int x, int steps) {
    for (int j = x; j < x + steps; j++) {
      for (int i = y; i < y + steps; i++) {
        data[i][j] = --counter;
      }
    }
  }
}
