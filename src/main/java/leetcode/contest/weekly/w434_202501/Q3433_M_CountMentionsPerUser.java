package leetcode.contest.weekly.w434_202501;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-01-25
 */
public class Q3433_M_CountMentionsPerUser {

  public static void main(String[] args) {
    Q3433_M_CountMentionsPerUser q3433MCountMentionsPerUser = new Q3433_M_CountMentionsPerUser();
    List<List<String>> testData = new ArrayList<>();
    // [["MESSAGE","1","ALL"],["OFFLINE","66","1"],["MESSAGE","66","HERE"],["OFFLINE","5","1"]]©leetcode
    testData.add(Lists.newArrayList("MESSAGE", "1", "ALL"));
    testData.add(Lists.newArrayList("OFFLINE", "66", "1"));
    testData.add(Lists.newArrayList("MESSAGE", "66", "HERE"));
    testData.add(Lists.newArrayList("OFFLINE", "5", "1"));
    System.out.println(Arrays.toString(q3433MCountMentionsPerUser.countMentions(3, testData)));

    testData.clear();
    // [["MESSAGE","2","HERE"],["OFFLINE","2","1"],["OFFLINE","1","0"],["MESSAGE","61","HERE"]]
    testData.add(Lists.newArrayList("MESSAGE", "2", "HERE"));
    testData.add(Lists.newArrayList("OFFLINE", "2", "1"));
    testData.add(Lists.newArrayList("OFFLINE", "1", "0"));
    testData.add(Lists.newArrayList("MESSAGE", "61", "HERE"));
    System.out.println(Arrays.toString(q3433MCountMentionsPerUser.countMentions(3, testData)));
  }

  public int[] countMentions(int numberOfUsers, List<List<String>> events) {
    int[] mentions = new int[numberOfUsers];
    boolean[] active = new boolean[numberOfUsers];
    Arrays.fill(active, true);
    Set<Pair> offlineUsers = new HashSet<>();
    List<Event> records =
        events.stream()
            .map(event -> new Event(event.get(0), Integer.parseInt(event.get(1)), event.get(2)))
            .sorted()
            .toList();

    for (Event event : records) {
      String data = event.data;
      int time = event.time;

      List<Pair> nowAliveUsers =
          offlineUsers.stream().filter(pair -> time >= pair.offlineTime() + 60).toList();
      for (Pair u : nowAliveUsers) {
        offlineUsers.remove(u);
        active[u.id] = true;
      }

      if (event.type.equals("OFFLINE")) {
        int id = Integer.parseInt(data);
        active[id] = false;
        offlineUsers.add(new Pair(id, time));
      } else {

        if ("HERE".equals(data)) {
          for (int i = 0; i < numberOfUsers; i++) if (active[i]) mentions[i]++;
        } else if ("ALL".equals(data)) {
          for (int i = 0; i < numberOfUsers; i++) mentions[i]++;
        } else {
          String[] parts = data.split(" ");
          for (String part : parts) {
            int id = Integer.parseInt(part.substring(2));
            mentions[id]++;
          }
        }
      }
    }

    return mentions;
  }

  private record Event(String type, int time, String data) implements Comparable<Event> {
    @Override
    public int compareTo(Event o) {
      if (time == o.time) return o.type.compareTo(type);
      return time - o.time;
    }
  }

  private record Pair(int id, int offlineTime) {}
}
