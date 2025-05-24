package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-05-23
 */
public class Q2942_E_FindWordsContainingCharacter {

  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> data = new ArrayList<>();
    for (int i = 0; i < words.length; i++) if (words[i].indexOf(x) != -1) data.add(i);
    return data;
  }
}
