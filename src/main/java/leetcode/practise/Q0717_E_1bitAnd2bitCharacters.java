package leetcode.practise;

public class Q0717_E_1bitAnd2bitCharacters {
  public static void main(String[] args) {
    Q0717_E_1bitAnd2bitCharacters q0717E1bitAnd2bitCharacters = new Q0717_E_1bitAnd2bitCharacters();
    System.out.println(q0717E1bitAnd2bitCharacters.isOneBitCharacter(new int[] {1, 0, 0}));
    System.out.println(q0717E1bitAnd2bitCharacters.isOneBitCharacter(new int[] {1, 1, 1, 0}));
    System.out.println(q0717E1bitAnd2bitCharacters.isOneBitCharacter(new int[] {1, 1, 1, 1, 0}));
    System.out.println(q0717E1bitAnd2bitCharacters.isOneBitCharacter(new int[] {1, 0}));
    System.out.println(q0717E1bitAnd2bitCharacters.isOneBitCharacter(new int[] {1, 1, 0}));
  }

  public boolean isOneBitCharacter(int[] bits) { // 1ms, beats 3.06%
    boolean open = false;
    for (int i = 0; i < bits.length - 1; i++) {
      if (bits[i] == 1) open = !open;
      else if (open) open = false;
    }
    return bits[bits.length - 1] == 0 && !open;
  }
}
