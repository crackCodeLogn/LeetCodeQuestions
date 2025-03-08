package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-03-07
 */
public class Q2379_E_MinimumRecolorsToGetKConsecutiveBlackBlocks {

  public static void main(String[] args) {
    Q2379_E_MinimumRecolorsToGetKConsecutiveBlackBlocks
        q2379EMinimumRecolorsToGetKConsecutiveBlackBlocks =
            new Q2379_E_MinimumRecolorsToGetKConsecutiveBlackBlocks();
    System.out.println(
        q2379EMinimumRecolorsToGetKConsecutiveBlackBlocks.minimumRecolors("WWWWB", 4));
    System.out.println(
        q2379EMinimumRecolorsToGetKConsecutiveBlackBlocks.minimumRecolors("WWWWBBBBB", 4));
    System.out.println(
        q2379EMinimumRecolorsToGetKConsecutiveBlackBlocks.minimumRecolors("WBBWWBBWBW", 7));
    System.out.println(
        q2379EMinimumRecolorsToGetKConsecutiveBlackBlocks.minimumRecolors("WBWBBBW", 2));
  }

  public int minimumRecolors(String blocks, int k) { // 1ms, beats 92.10%
    int cnt = 0, min;
    int i;
    for (i = 0; i < k; i++) if (blocks.charAt(i) == 'W') cnt++;
    if (cnt == 0) return 0;
    min = cnt;
    for (i = 1; i <= blocks.length() - k; i++) {
      if (blocks.charAt(i - 1) == 'W') cnt--;
      if (blocks.charAt(i + k - 1) == 'W') cnt++;
      min = Math.min(min, cnt);
    }
    return min;
  }
}
