package leetcode.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 9/10/25
 */
public class Q2785_M_SortVowelsInAString {

  public static void main(String[] args) {
    Q2785_M_SortVowelsInAString q2785MSortVowelsInAString = new Q2785_M_SortVowelsInAString();
    System.out.println(q2785MSortVowelsInAString.sortVowels("lEetcOde"));
    System.out.println(q2785MSortVowelsInAString.sortVowels("lYmpH"));
  }

  public String sortVowels(String s) { // 74ms, beats 24.65%
    StringBuilder data = new StringBuilder(s);
    List<Integer> queue = new ArrayList<>(s.length());
    PriorityQueue<Character> priorityQueue = new PriorityQueue<>();
    for (int i = 0; i < data.length(); i++) {
      char ch = data.charAt(i);
      if (isVowel(ch)) {
        queue.add(i);
        priorityQueue.add(ch);
      }
    }
    for (int index : queue) data.setCharAt(index, priorityQueue.poll());
    return data.toString();
  }

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E'
        || ch == 'I' || ch == 'O' || ch == 'U';
  }
}
