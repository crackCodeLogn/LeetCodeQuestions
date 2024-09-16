package leetcode.practise;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-09-15
 */
public class Q0539_M_MinimumTimeDifference {

  public static void main(String[] args) {
    Q0539_M_MinimumTimeDifference q0539MMinimumTimeDifference = new Q0539_M_MinimumTimeDifference();
    System.out.println(
        q0539MMinimumTimeDifference.findMinDifference(Lists.newArrayList("23:59", "00:00")));
    System.out.println(
        q0539MMinimumTimeDifference.findMinDifference(
            Lists.newArrayList("00:00", "23:59", "00:00")));
  }

  public int findMinDifference(List<String> timePoints) { // 9ms
    int[] data = new int[timePoints.size()];
    for (int i = 0; i < timePoints.size(); i++) {
      String point = timePoints.get(i);
      String[] split = point.split(":");
      int hour = Integer.parseInt(split[0]);
      int minute = Integer.parseInt(split[1]);
      data[i] = hour * 60 + minute;
    }
    Arrays.sort(data);
    int minDiff = 1500;
    int i = 0;
    for (; i < data.length - 1; i++) minDiff = Math.min(minDiff, data[i + 1] - data[i]);
    minDiff = Math.min(minDiff, data[0] + 1440 - data[i]);

    return minDiff;
  }

  public int findMinDifference2(List<String> timePoints) { // 19ms
    List<Integer> data =
        timePoints.stream()
            .map(
                point -> {
                  String[] split = point.split(":");
                  int hour = Integer.parseInt(split[0]);
                  int minute = Integer.parseInt(split[1]);
                  return hour * 60 + minute;
                })
            .sorted()
            .toList();
    int minDiff = 1500;
    int i = 0;
    for (; i < data.size() - 1; i++) minDiff = Math.min(minDiff, data.get(i + 1) - data.get(i));
    minDiff = Math.min(minDiff, data.get(0) + 1440 - data.get(i));

    return minDiff;
  }
}
