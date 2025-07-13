package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 7/13/25
 */
public class Q2410_M_MaximumMatchingOfPlayersWithTrainers {

  public static void main(String[] args) {
    Q2410_M_MaximumMatchingOfPlayersWithTrainers q2410MMaximumMatchingOfPlayersWithTrainers =
        new Q2410_M_MaximumMatchingOfPlayersWithTrainers();
    System.out.println(
        q2410MMaximumMatchingOfPlayersWithTrainers.matchPlayersAndTrainers(
            new int[] {4, 7, 9}, new int[] {8, 2, 5, 8}));
    System.out.println(
        q2410MMaximumMatchingOfPlayersWithTrainers.matchPlayersAndTrainers(
            new int[] {1, 1, 1}, new int[] {10}));
  }

  public int matchPlayersAndTrainers(int[] players, int[] trainers) { // 26ms, beats 66.18%
    Arrays.sort(players);
    Arrays.sort(trainers);

    int p1 = 0, p2 = 0, cnt = 0;
    while (p1 < players.length && p2 < trainers.length) {
      while (p2 < trainers.length) {
        if (players[p1] <= trainers[p2]) {
          p2++;
          cnt++;
          break;
        }
        p2++;
      }
      p1++;
    }
    return cnt;
  }
}
