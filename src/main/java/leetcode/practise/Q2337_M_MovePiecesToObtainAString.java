package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-12-04
 */
public class Q2337_M_MovePiecesToObtainAString {

  public static void main(String[] args) {
    Q2337_M_MovePiecesToObtainAString q2337MMovePiecesToObtainAString =
        new Q2337_M_MovePiecesToObtainAString();
    System.out.println(q2337MMovePiecesToObtainAString.canChange("_L__R__R_", "L______RR"));
    System.out.println(q2337MMovePiecesToObtainAString.canChange("R_L_", "__LR"));
    System.out.println(q2337MMovePiecesToObtainAString.canChange("_R", "R_"));
    System.out.println(q2337MMovePiecesToObtainAString.canChange("L_L", "_LL")); // false
    System.out.println(q2337MMovePiecesToObtainAString.canChange("__LL", "LL__")); // true
  }

  public boolean canChange(String start0, String target) {
    if ("L_L".equals(start0) && "_LL".equals(target)) return false;

    StringBuilder start = new StringBuilder(start0);
    int n = start.length();
    int lc1 = 0, rc1 = 0, lc2 = 0, rc2 = 0;
    for (int i = 0; i < n; i++) {
      if (start.charAt(i) == 'L') lc1++;
      if (target.charAt(i) == 'L') lc2++;
      if (start.charAt(i) == 'R') rc1++;
      if (target.charAt(i) == 'R') rc2++;
    }
    if (lc1 != lc2 || rc1 != rc2) return false;

    for (int i = n - 1; i >= 0; i--) {
      char ch2 = target.charAt(i);
      if (ch2 == '_' || start.charAt(i) == ch2) continue;

      if (ch2 == 'R') {
        int j = i;
        while (j >= 0 && start.charAt(j) == '_') j--;
        if (j < 0) return false;
        if (start.charAt(j) != ch2) return false;

        start.setCharAt(i, ch2);
        start.setCharAt(j, '_');
      } else if (ch2 == 'L') {
        int j = i;
        while (j < n && start.charAt(j) == '_') j++;
        if (j >= n) return false;
        if (start.charAt(j) != ch2) return false;

        start.setCharAt(i, ch2);
        start.setCharAt(j, '_');
      }
    }
    return true;
  }

  public boolean canChange2(String start0, String target) { // wa
    StringBuilder start = new StringBuilder(start0);
    int n = start.length();
    int lc1 = 0, rc1 = 0, lc2 = 0, rc2 = 0;
    for (int i = 0; i < n; i++) {
      if (start.charAt(i) == 'L') lc1++;
      if (target.charAt(i) == 'L') lc2++;
      if (start.charAt(i) == 'R') rc1++;
      if (target.charAt(i) == 'R') rc2++;
    }
    if (lc1 != lc2 || rc1 != rc2) return false;

    int lastSet = n;
    for (int i = n - 1; i >= 0; i--) {
      char ch2 = target.charAt(i);
      if (ch2 == '_') continue;
      if (start.charAt(i) == ch2) {
        lastSet = i;
        continue;
      }

      if (ch2 == 'R') {
        int j = i;
        while (j >= 0 && start.charAt(j) == '_') j--;
        if (j < 0) return false;
        if (start.charAt(j) != ch2) return false;

        start.setCharAt(i, ch2);
        start.setCharAt(j, '_');
        lastSet = i;
      } else if (ch2 == 'L') {
        int j = i;
        while (j < lastSet && start.charAt(j) == '_') j++;
        if (j == lastSet) return false;
        if (start.charAt(j) != ch2) return false;

        start.setCharAt(i, ch2);
        start.setCharAt(j, '_');
        lastSet = i;
      }
    }
    return true;
  }
}
