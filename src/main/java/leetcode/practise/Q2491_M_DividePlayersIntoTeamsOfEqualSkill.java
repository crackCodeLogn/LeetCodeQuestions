package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-10-03
 */
public class Q2491_M_DividePlayersIntoTeamsOfEqualSkill {

  public static void main(String[] args) {
    Q2491_M_DividePlayersIntoTeamsOfEqualSkill q2491MDividePlayersIntoTeamsOfEqualSkill =
        new Q2491_M_DividePlayersIntoTeamsOfEqualSkill();
    System.out.println(
        q2491MDividePlayersIntoTeamsOfEqualSkill.dividePlayers(new int[] {3, 2, 5, 1, 3, 4}));
    System.out.println(q2491MDividePlayersIntoTeamsOfEqualSkill.dividePlayers(new int[] {3, 4}));
    System.out.println(
        q2491MDividePlayersIntoTeamsOfEqualSkill.dividePlayers(new int[] {1, 1, 2, 3}));
  }

  public long dividePlayers(int[] skill) {
    int n = skill.length;
    Arrays.sort(skill);
    long target = skill[0] + skill[n - 1];
    long result = (long) skill[0] * skill[n - 1];

    for (int i = 1, j = n - 2; i < n - 1 && i < j; i++, j--) {
      if (skill[i] + skill[j] != target) return -1;
      result += (long) skill[i] * skill[j];
    }
    return result;
  }
}
