package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-09-29
 */
public class Q1381_M_DesignAStackWithIncrementOperation {
  class CustomStack {

    private final int[] data;
    private int top;

    public CustomStack(int maxSize) {
      data = new int[maxSize];
      top = -1;
    }

    public void push(int x) {
      if (top == data.length - 1) return;
      data[++top] = x;
    }

    public int pop() {
      if (top == -1) return -1;
      return data[top--];
    }

    public void increment(int k, int val) {
      for (int i = 0; i <= Math.min(k - 1, top); i++) data[i] += val;
    }
  }
}
