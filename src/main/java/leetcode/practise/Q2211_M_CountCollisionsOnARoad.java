package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2025-12-03
 */
public class Q2211_M_CountCollisionsOnARoad {
  public static void main(String[] args) {
    Q2211_M_CountCollisionsOnARoad q2211MCountCollisionsOnARoad =
        new Q2211_M_CountCollisionsOnARoad();
    System.out.println(
        q2211MCountCollisionsOnARoad.countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR")); // 20
    System.out.println(q2211MCountCollisionsOnARoad.countCollisions("RLRSLL"));
    System.out.println(q2211MCountCollisionsOnARoad.countCollisions("LLRR"));
    System.out.println(q2211MCountCollisionsOnARoad.countCollisions("R"));
  }

  public int countCollisions(String directions) { // 133ms, beats 11.29%
    Stack<Character> stack = new Stack<>();
    int cnt = 0;

    for (int i = 0; i < directions.length(); i++) {
      char ch = directions.charAt(i);
      if (stack.isEmpty()) stack.push(ch);
      else {
        char top = stack.peek();
        if (top == ch) { // LL RR SS
          stack.push(ch);
        } else {
          if (top == 'L') {
            stack.push(ch);
          } else if (top == 'S') {
            if (ch == 'R') stack.push(ch);
            else { // L
              cnt++;
              stack.push('S');
            }
          } else { // R
            if (ch == 'S') {
              cnt++;
              stack.pop();
              stack.push(ch);
            } else { // L
              cnt += 2;
              stack.pop(); // pop R out
              stack.push('S');
            }
          }
        }
      }
    }
    if (!stack.isEmpty()) {
      while (!stack.isEmpty() && stack.peek() == 'R') stack.pop();
      while (!stack.isEmpty()) {
        if (stack.pop() == 'R') cnt++;
      }
    }
    return cnt;
  }
}
