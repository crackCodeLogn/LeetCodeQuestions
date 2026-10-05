package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2026-10-04
 */
public class Q0856_M_ScoreOfParentheses {
  public int scoreOfParentheses(String s) { // 1ms, beats 61.96%
    Stack<Integer> stack = new Stack<>();
    int data = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') stack.push(0);
      else { // )
        if (stack.peek() == 0) {
          stack.pop();
          stack.push(1);
          continue;
        }

        int v = stack.pop();
        while (!stack.isEmpty() && stack.peek() != 0) v += stack.pop();
        stack.pop(); // 0 ~ (
        stack.push(v * 2);
      }
    }
    while (!stack.isEmpty()) data += stack.pop();
    return data;
  }

  public int scoreOfParentheses2(String s) { // 3ms, beats 0.35%
    s = s.replaceAll("\\(\\)", "1");
    Stack<Integer> stack = new Stack<>();
    int data = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') stack.push(0);
      else if (ch == '1') stack.push(1);
      else { // )
        int v = stack.pop();
        while (!stack.isEmpty() && stack.peek() != 0) v += stack.pop();
        stack.pop(); // 0 ~ (
        stack.push(v * 2);
      }
    }
    while (!stack.isEmpty()) data += stack.pop();
    return data;
  }

  public static void main(String[] args) {
    Q0856_M_ScoreOfParentheses q0856MScoreOfParentheses = new Q0856_M_ScoreOfParentheses();
    System.out.println(q0856MScoreOfParentheses.scoreOfParentheses("()"));
    System.out.println(q0856MScoreOfParentheses.scoreOfParentheses("(())"));
    System.out.println(q0856MScoreOfParentheses.scoreOfParentheses("()()"));
    System.out.println(q0856MScoreOfParentheses.scoreOfParentheses("(()((()())()))"));
  }
}
