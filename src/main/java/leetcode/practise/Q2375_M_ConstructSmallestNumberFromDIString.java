package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2025-02-17
 */
public class Q2375_M_ConstructSmallestNumberFromDIString {

  public static void main(String[] args) {
    Q2375_M_ConstructSmallestNumberFromDIString q2375MConstructSmallestNumberFromDIString =
        new Q2375_M_ConstructSmallestNumberFromDIString();
    System.out.println(q2375MConstructSmallestNumberFromDIString.smallestNumber("IIIDIDDD"));
    System.out.println(q2375MConstructSmallestNumberFromDIString.smallestNumber("DDD"));
  }

  public String smallestNumber(String pattern) { // 1ms, beats 75.25%
    if (pattern.equals("I")) return "12";
    if (pattern.equals("D")) return "21";

    StringBuilder data = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    stack.push(1);

    for (char ch : pattern.toCharArray()) {
      int max = stack.peek();
      if (ch == 'I')
        while (!stack.isEmpty()) {
          int top = stack.pop();
          max = Math.max(max, top);
          data.append(top);
        }
      stack.push(max + 1);
    }

    while (!stack.isEmpty()) data.append(stack.pop());
    return data.toString();
  }
}
