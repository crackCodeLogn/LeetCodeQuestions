package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-11-25
 */
public class Q2924_M_FindChampionII {

  public static void main(String[] args) {
    Q2924_M_FindChampionII q2924MFindChampionII = new Q2924_M_FindChampionII();
    System.out.println(q2924MFindChampionII.findChampion(3, new int[][] {{0, 1}, {1, 2}}));
    System.out.println(q2924MFindChampionII.findChampion(4, new int[][] {{0, 2}, {1, 3}, {1, 2}}));
  }

  public int findChampion(int n, int[][] edges) {
    int[] nodes = new int[n];
    for (int[] edge : edges) {
      int dest = edge[1];
      nodes[dest]++;
    }
    int c0 = -1;
    for (int i = 0; i < n; i++)
      if (nodes[i] == 0) {
        if (c0 == -1) c0 = i;
        else return -1;
      }
    return c0;
  }
}
