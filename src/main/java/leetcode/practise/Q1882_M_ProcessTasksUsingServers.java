package leetcode.practise;

import java.util.*;

public class Q1882_M_ProcessTasksUsingServers {
  public int[] assignTasks(int[] servers, int[] tasks) { // 207ms, beats 93.38%
    int[] serverAssigned = new int[tasks.length];
    if (servers.length == 1) { // edge case - post TLE
      Arrays.fill(serverAssigned, 0);
      return serverAssigned;
    }

    List<Server> serverList = new ArrayList<>(servers.length);
    Queue<Task> taskQueue = new LinkedList<>();
    for (int i = 0; i < servers.length; i++) serverList.add(new Server(i, servers[i]));
    for (int i = 0; i < tasks.length; i++) taskQueue.offer(new Task(tasks[i], i));

    PriorityQueue<Server> freePool = new PriorityQueue<>(serverList);
    PriorityQueue<Server> inUsePool =
        new PriorityQueue<>(Comparator.comparingInt(Server::getTimeWhenFree));

    for (int time = 0; !taskQueue.isEmpty(); time++) {
      // check if any in use server has become free at time, and if so, move to free pool
      while (!inUsePool.isEmpty() && inUsePool.peek().timeWhenFree == time) {
        freePool.offer(inUsePool.poll());
      }

      if (freePool.isEmpty()) { // no servers available to process - skip time forward
        time = inUsePool.peek().timeWhenFree - 1;
        continue;
      }
      // loop to clear backlog until free-pool available and tasktime has not caught up time
      while (!freePool.isEmpty()
          && (!taskQueue.isEmpty() && time >= taskQueue.peek().timeOfArrival)) {
        Task task = taskQueue.poll();
        int targetTime = time + task.timeToExecute;
        Server freeServer = freePool.poll();
        freeServer.setTimeWhenFree(targetTime);
        inUsePool.offer(freeServer);
        serverAssigned[task.timeOfArrival] = freeServer.getId();
      }
    }
    return serverAssigned;
  }

  private record Task(int timeToExecute, int timeOfArrival) {}

  private static final class Server implements Comparable<Server> {
    private final int id;
    private final int weight;
    private int timeWhenFree;

    Server(int id, int weight) {
      this.id = id;
      this.weight = weight;
      this.timeWhenFree = 0;
    }

    @Override
    public int compareTo(Server other) {
      if (weight != other.weight) return weight - other.weight;
      return id - other.id;
    }

    public int getId() {
      return id;
    }

    public int getTimeWhenFree() {
      return timeWhenFree;
    }

    public void setTimeWhenFree(int timeWhenFree) {
      this.timeWhenFree = timeWhenFree;
    }
  }

  public static void main(String[] args) {
    Q1882_M_ProcessTasksUsingServers q1882MProcessTasksUsingServers =
        new Q1882_M_ProcessTasksUsingServers();
    System.out.println(
        Arrays.toString(
            q1882MProcessTasksUsingServers.assignTasks(
                new int[] {3, 3, 2}, new int[] {1, 2, 3, 2, 1, 2})));
    System.out.println(
        Arrays.toString(
            q1882MProcessTasksUsingServers.assignTasks(
                new int[] {5, 1, 4, 3, 2}, new int[] {2, 1, 2, 4, 5, 2, 1})));
    // more tc were used to get to target solution, but they on lc site
  }
}
