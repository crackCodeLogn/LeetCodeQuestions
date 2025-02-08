package leetcode.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2025-02-07
 */
public class Q2349_M_DesignANumberContainerSystem {

  class NumberContainers { // 85ms, beats 44.52%
    private final Map<Integer, TreeSet<Integer>> numberContainers;
    private final Map<Integer, Integer> indexNumbers;

    public NumberContainers() {
      numberContainers = new HashMap<>();
      indexNumbers = new HashMap<>();
    }

    public void change(int index, int number) {
      if (!indexNumbers.containsKey(index)) {
        numberContainers.compute(number, (k, v) -> v == null ? new TreeSet<>() : v).add(index);
        indexNumbers.put(index, number);
      } else {
        Integer prevNum = indexNumbers.put(index, number);
        if (prevNum != null && numberContainers.get(prevNum).contains(index)) {
          numberContainers.get(prevNum).remove(index);
          if (numberContainers.get(prevNum).isEmpty()) numberContainers.remove(prevNum);
          numberContainers.compute(number, (k, v) -> v == null ? new TreeSet<>() : v).add(index);
        }
      }
    }

    public int find(int number) {
      return numberContainers.containsKey(number) ? numberContainers.get(number).first() : -1;
    }
  }
}
