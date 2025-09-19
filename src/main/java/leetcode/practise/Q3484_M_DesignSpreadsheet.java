package leetcode.practise;

/**
 * @author Vivek
 * @since 9/18/25
 */
public class Q3484_M_DesignSpreadsheet {
  public class Spreadsheet { // 111ms, beats 84.86%

    private final int[][] data;

    public Spreadsheet(int rows) {
      data = new int[rows + 1][26];
    }

    public void setCell(String cell, int value) {
      Pair pair = getRowColPair(cell);
      data[pair.row()][pair.col()] = value;
    }

    public void resetCell(String cell) {
      Pair pair = getRowColPair(cell);
      data[pair.row()][pair.col()] = 0;
    }

    public int getValue(String formula) {
      String operand1 = formula.substring(1, formula.indexOf('+'));
      String operand2 = formula.substring(formula.indexOf('+') + 1);
      Pair pair;
      int op1 =
          (pair = getRowColPair(operand1)) != null
              ? data[pair.row()][pair.col()]
              : Integer.parseInt(operand1);
      int op2 =
          (pair = getRowColPair(operand2)) != null
              ? data[pair.row()][pair.col()]
              : Integer.parseInt(operand2);
      return op1 + op2;
    }

    private Pair getRowColPair(String cell) {
      if (cell.charAt(0) <= '9') return null;
      return new Pair(Integer.parseInt(cell.substring(1)), cell.charAt(0) - 'A');
    }

    private record Pair(int row, int col) {}
  }
}
