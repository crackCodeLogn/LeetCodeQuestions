package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-10-16
 */
public class Q0670_M_MaximumSwap {

  public static void main(String[] args) {
    Q0670_M_MaximumSwap q0670MMaximumSwap = new Q0670_M_MaximumSwap();
    System.out.println(q0670MMaximumSwap.maximumSwap(2736));
    System.out.println(q0670MMaximumSwap.maximumSwap(9973));
  }

  public int maximumSwap(int num) {
    char[] s = Integer.toString(num).toCharArray();
    int[] lastIndex = new int[10]; // {digit: last index}

    for (int i = 0; i < s.length; ++i) lastIndex[s[i] - '0'] = i;

    for (int i = 0; i < s.length; ++i)
      for (int d = 9; d > s[i] - '0'; --d)
        if (lastIndex[d] > i) {
          s[lastIndex[d]] = s[i];
          s[i] = (char) ('0' + d);
          return Integer.parseInt(new String(s));
        }

    return num;
  }
}
