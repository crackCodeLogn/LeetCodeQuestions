package leetcode.contest.weekly.w419_202410;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-10-12
 */
public class Q3318_E_FindXSumOfAllKLongSubarraysI {

  public static void main(String[] args) {
    Q3318_E_FindXSumOfAllKLongSubarraysI q3318EFindXSumOfAllKLongSubarraysI = new Q3318_E_FindXSumOfAllKLongSubarraysI();
    System.out.println(Arrays.toString(q3318EFindXSumOfAllKLongSubarraysI.findXSum(new int[] {1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)));
    System.out.println(Arrays.toString(q3318EFindXSumOfAllKLongSubarraysI.findXSum(new int[] {3, 8, 7, 8, 7, 5}, 2, 2)));
  }

  public int[] findXSum(int[] nums, int k, int x) {
    int n = nums.length, v = 0;
    int[] data = new int[n - k + 1];

    for (int i = 0; i + k - 1 < n; i++) {
      Map<Integer, Node> map = new HashMap<>();
      for (int j = i; j <= i + k - 1 && j < n; j++) {
        if (map.containsKey(nums[j])) {
          map.get(nums[j]).bump();
        } else {
          map.put(nums[j], new Node(nums[j]));
        }
      }
      List<Node> nodeList = new ArrayList<>(map.values());
      Collections.sort(nodeList);

      for (int m = nodeList.size() - 1, p = x; m >= 0 && p > 0; m--, p--) {
        data[v] += nodeList.get(m).getCount() * nodeList.get(m).getNum();
      }
      v++;
    }

    return data;
  }

  private static final class Node implements Comparable<Node> {
    private final int num;
    private int count;

    public Node(int num) {
      this.num = num;
      this.count = 1;
    }

    @Override
    public String toString() {
      return num + " " + count;
    }

    public void bump() {
      count++;
    }

    public int getNum() {
      return num;
    }

    public int getCount() {
      return count;
    }

    @Override
    public int compareTo(Node o) {
      if (this.count != o.count) return this.count - o.count;
      return this.num - o.num;
    }
  }
}
