package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-04-17
 */
public class Q3783_E_MirrorDistanceOfAnInteger {

  public static void main(String[] args) {
    Q3783_E_MirrorDistanceOfAnInteger q3783EMirrorDistanceOfAnInteger =
        new Q3783_E_MirrorDistanceOfAnInteger();
    System.out.println(q3783EMirrorDistanceOfAnInteger.mirrorDistance(25));
    System.out.println(q3783EMirrorDistanceOfAnInteger.mirrorDistance(10));
    System.out.println(q3783EMirrorDistanceOfAnInteger.mirrorDistance(7));
  }

  public int mirrorDistance(int n) { // 1ms, beats 100%
    int n2 = n, n3 = 0;
    while (n2 > 0) {
      n3 = n3 * 10 + n2 % 10;
      n2 /= 10;
    }
    return Math.abs(n - n3);
  }
}
