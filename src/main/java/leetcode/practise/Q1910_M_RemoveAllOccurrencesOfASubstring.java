package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2025-02-10
 */
public class Q1910_M_RemoveAllOccurrencesOfASubstring {

  public static void main(String[] args) {
    Q1910_M_RemoveAllOccurrencesOfASubstring q1910MRemoveAllOccurrencesOfASubstring =
        new Q1910_M_RemoveAllOccurrencesOfASubstring();
    System.out.println(
        q1910MRemoveAllOccurrencesOfASubstring.removeOccurrences("daabcbaabcbc", "abc"));
    System.out.println(
        q1910MRemoveAllOccurrencesOfASubstring.removeOccurrences("axxxxyyyyb", "xy"));
  }

  public String removeOccurrences(String s, String part) { // 13ms, beats 9.71%
    Stack<Character> stack = new Stack<>();
    int plen = part.length();
    for (int i = 0; i < s.length(); i++) {
      stack.push(s.charAt(i));
      if (stack.size() >= plen) {
        Stack<Character> tempStack = new Stack<>();
        int k = plen - 1;
        while (!stack.empty() && k >= 0) {
          Character c = stack.pop();
          tempStack.push(c);
          if (c != part.charAt(k)) {
            break;
          }
          k--;
        }
        if (k != -1) while (!tempStack.empty()) stack.push(tempStack.pop());
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.empty()) sb.append(stack.pop());
    return sb.reverse().toString();
  }
}
