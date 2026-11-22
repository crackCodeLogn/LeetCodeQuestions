package leetcode.practise;

public class Q2124_E_CheckIfAllAsAppearsBeforeAllBs {
  public boolean checkString(String s) { // 1ms, beats 54.57%
    boolean aFound = false, bFound = false;
    int aPos = 0, bPos = s.length() - 1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') {
        aFound = true;
        aPos = i; // last occurrence
      } else {
        if (!bFound) bPos = i; // first occurrence
        bFound = true;
      }
    }
    if (aFound && bFound) return aPos < bPos;
    return true;
  }

  public static void main(String[] args) {
    Q2124_E_CheckIfAllAsAppearsBeforeAllBs q2124ECheckIfAllAsAppearsBeforeAllBs =
        new Q2124_E_CheckIfAllAsAppearsBeforeAllBs();
    System.out.println(q2124ECheckIfAllAsAppearsBeforeAllBs.checkString("aaabbb"));
    System.out.println(q2124ECheckIfAllAsAppearsBeforeAllBs.checkString("abab"));
    System.out.println(q2124ECheckIfAllAsAppearsBeforeAllBs.checkString("bbb"));
    System.out.println(q2124ECheckIfAllAsAppearsBeforeAllBs.checkString("aaa"));
  }
}
