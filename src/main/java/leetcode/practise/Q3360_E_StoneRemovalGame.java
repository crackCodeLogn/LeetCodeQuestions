package leetcode.practise;

public class Q3360_E_StoneRemovalGame {

  public boolean canAliceWin(int n) { // 0ms, beats 100%
    if (n < 10) return false;
    boolean alice = true;
    int diff = 10;
    while (true) {
      if (n < diff) {
        return !alice;
      }
      n -= diff;
      diff--;
      alice = !alice;
    }
  }

  public static void main(String[] args) {
    Q3360_E_StoneRemovalGame q3360EStoneRemovalGame = new Q3360_E_StoneRemovalGame();
    System.out.println(q3360EStoneRemovalGame.canAliceWin(50));
    System.out.println(q3360EStoneRemovalGame.canAliceWin(12));
    System.out.println(q3360EStoneRemovalGame.canAliceWin(10));
    System.out.println(q3360EStoneRemovalGame.canAliceWin(1));
  }
}
