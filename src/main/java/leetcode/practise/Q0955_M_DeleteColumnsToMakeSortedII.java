package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-12-20
 */
public class Q0955_M_DeleteColumnsToMakeSortedII {

  /*  private char[][] data;
  private Set<Integer> delCols;

  private void work(int j, List<Integer> targets) {
    if (targets.isEmpty() || j >= data[0].length) return;

    boolean exit = true;
    boolean failed = false;
    Map<Character, Set<Integer>> map = new HashMap<>();

    for (int i = 1; i < targets.size(); i++) {
      if (data[targets.get(i)][j] < data[targets.get(i - 1)][j]) {
        delCols.add(j);
        exit = false;
        failed = true;
        break;
      } else if (data[targets.get(i)][j] == data[targets.get(i - 1)][j]) {
        if (!map.containsKey(data[targets.get(i)][j]))
          map.put(data[targets.get(i)][j], new TreeSet<>());
        map.get(data[targets.get(i)][j]).add(targets.get(i - 1));
        map.get(data[targets.get(i)][j]).add(targets.get(i));
        exit = false;
      }
    }
    if (exit) return; // lexico found
    if (!failed) { // equal chars, narrow down / update search area
      map.forEach(
          (c, set) -> {
            List<Integer> list = new ArrayList<>(set);
            work(j + 1, list);
          });
    } else work(j + 1, targets);
  }

  public int minDeletionSize(String[] strs) {
    data = new char[strs.length][strs[0].length()];
    delCols = new HashSet<>();
    for (int i = 0; i < strs.length; i++)
      for (int j = 0; j < strs[i].length(); j++) data[i][j] = strs[i].charAt(j);

    List<Integer> targets = new ArrayList<>();
    for (int i = 0; i < strs.length; i++) targets.add(i);
    work(0, targets);

    return delCols.size();
  }*/

  public static void main(String[] args) {
    Q0955_M_DeleteColumnsToMakeSortedII q0955MDeleteColumnsToMakeSortedII =
        new Q0955_M_DeleteColumnsToMakeSortedII();

    System.out.println(
        q0955MDeleteColumnsToMakeSortedII.minDeletionSize(
            new String[] {"vdy", "vei", "zvc", "zld"})); // 2
    System.out.println(
        q0955MDeleteColumnsToMakeSortedII.minDeletionSize(
            new String[] {"abx", "agz", "bgc", "bfc"})); // 1
    System.out.println(
        q0955MDeleteColumnsToMakeSortedII.minDeletionSize(new String[] {"abc", "abc", "bad"})); // 0
    System.out.println(
        q0955MDeleteColumnsToMakeSortedII.minDeletionSize(new String[] {"ca", "bb", "ac"})); // 1
    System.out.println(
        q0955MDeleteColumnsToMakeSortedII.minDeletionSize(new String[] {"xc", "yb", "za"})); // 0
    System.out.println(
        q0955MDeleteColumnsToMakeSortedII.minDeletionSize(new String[] {"zyx", "wvu", "tsr"})); // 3
  }

  public int minDeletionSize(String[] strs) { // 1ms, beats 78.08%
    char[][] data = new char[strs.length][strs[0].length()];
    for (int i = 0; i < strs.length; i++)
      for (int j = 0; j < strs[i].length(); j++) data[i][j] = strs[i].charAt(j);
    boolean[] sorted = new boolean[strs.length - 1];
    int cnt = 0;

    for (int j = 0; j < data[0].length; j++) {
      int i;
      for (i = 0; i < data.length - 1; i++) {
        if (!sorted[i] && data[i][j] > data[i + 1][j]) {
          cnt++;
          break;
        }
      }
      if (i + 1 == data.length) {
        for (i = 0; i < data.length - 1; i++) {
          sorted[i] = sorted[i] || data[i][j] < data[i + 1][j];
        }
      }
    }
    return cnt;
  }
}
