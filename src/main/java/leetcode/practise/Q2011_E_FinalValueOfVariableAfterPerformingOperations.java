package leetcode.practise;

/**
 * @author Vivek
 * @since 10/19/25
 */
public class Q2011_E_FinalValueOfVariableAfterPerformingOperations {
  public static void main(String[] args) {
    Q2011_E_FinalValueOfVariableAfterPerformingOperations
        q2011EFinalValueOfVariableAfterPerformingOperations =
            new Q2011_E_FinalValueOfVariableAfterPerformingOperations();
    System.out.println(
        q2011EFinalValueOfVariableAfterPerformingOperations.finalValueAfterOperations(
            new String[] {"--X", "X++", "X++"}));
    System.out.println(
        q2011EFinalValueOfVariableAfterPerformingOperations.finalValueAfterOperations(
            new String[] {"++X", "++X", "X++"}));
    System.out.println(
        q2011EFinalValueOfVariableAfterPerformingOperations.finalValueAfterOperations(
            new String[] {"X++", "++X", "--X", "X--"}));
  }

  public int finalValueAfterOperations(String[] operations) { // 0ms, beats 100%
    int sum = 0;
    for (String op : operations) sum += op.charAt(1) == '-' ? -1 : 1;
    return sum;
  }
}
