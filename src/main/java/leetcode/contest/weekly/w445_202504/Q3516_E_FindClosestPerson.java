package leetcode.contest.weekly.w445_202504;

/**
 * @author Vivek
 * @since 2025-04-12
 */
public class Q3516_E_FindClosestPerson {

  public static void main(String[] args) {
    Q3516_E_FindClosestPerson q3516EFindClosestPerson = new Q3516_E_FindClosestPerson();
    System.out.println(q3516EFindClosestPerson.findClosest(2, 7, 4));
    System.out.println(q3516EFindClosestPerson.findClosest(2, 5, 6));
    System.out.println(q3516EFindClosestPerson.findClosest(1, 5, 3));
    System.out.println(q3516EFindClosestPerson.findClosest(19, 20, 19));
    System.out.println(q3516EFindClosestPerson.findClosest(1, 1, 1));
  }

  public int findClosest(int x, int y, int z) {
    if (x == z && y == z) return 0;
    if (x == z) return 1;
    if (y == z) return 2;

    while (true) {
      if (x < z) x++;
      else x--;
      if (y < z) y++;
      else y--;
      if (x == z && y == z) return 0;
      if (x == z) return 1;
      if (y == z) return 2;
    }
  }
}
