package leetcode.practise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2025-05-30
 */
public class Q2359_M_FindClosestNodeToGivenTwoNodes {
  private static final int MAX = 1000_000;

  public static void main(String[] args) {
    Q2359_M_FindClosestNodeToGivenTwoNodes q2359MFindClosestNodeToGivenTwoNodes =
        new Q2359_M_FindClosestNodeToGivenTwoNodes();
    List<Integer> data = new ArrayList<>(MAX);
    try (BufferedReader reader =
        new BufferedReader(new FileReader("src/main/java/leetcode/practise/Q2359-data.0.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] split = line.split(",");
        Arrays.stream(split).forEach(s -> data.add(Integer.parseInt(s.strip())));
      }
    } catch (Exception ignored) {
    }
    int[] arrData = new int[data.size()];
    for (int i = 0; i < data.size(); i++) arrData[i] = data.get(i);

    System.out.println(
        q2359MFindClosestNodeToGivenTwoNodes.closestMeetingNode(arrData, 24238, 347));

    System.out.println(
        q2359MFindClosestNodeToGivenTwoNodes.closestMeetingNode(
            new int[] {4, 4, 8, -1, 9, 8, 4, 4, 1, 1}, 5, 6));
    System.out.println(
        q2359MFindClosestNodeToGivenTwoNodes.closestMeetingNode(new int[] {2, 2, 3, -1}, 0, 1));
    System.out.println(
        q2359MFindClosestNodeToGivenTwoNodes.closestMeetingNode(new int[] {1, 2, -1}, 0, 2));
  }

  public int closestMeetingNode(int[] edges, int node1, int node2) { // 328ms, beats 5.23%
    Map<Integer, Node> nodeMap = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      int src = i, dest = edges[i];
      nodeMap.putIfAbsent(src, new Node(src));
      if (dest != -1) {
        nodeMap.putIfAbsent(dest, new Node(dest));
        nodeMap.get(src).addEdge(dest);
      }
    }
    bfs(node1, nodeMap, 0);
    bfs(node2, nodeMap, 1);

    int minDistance = MAX;
    TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
    for (int i = 0; i < nodeMap.size(); i++) {
      Node node = nodeMap.get(i);
      int maxx = Math.max(node.distanceFromNodes[0], node.distanceFromNodes[1]);
      if (maxx >= MAX) continue;
      if (maxx < minDistance) {
        minDistance = maxx;
        map.compute(minDistance, (k, v) -> v == null ? new PriorityQueue<>() : v).offer(i);
      }
    }
    return map.isEmpty() ? -1 : map.firstEntry().getValue().poll();
  }

  private void bfs(int nodeIndex, Map<Integer, Node> nodeMap, int idx) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(nodeIndex);
    nodeMap.get(nodeIndex).distanceFromNodes[idx] = 0;
    Set<Integer> visited = new HashSet<>();
    int level = 1;
    while (!queue.isEmpty()) {
      List<Integer> hold = new ArrayList<>();
      while (!queue.isEmpty()) {
        int node = queue.poll();
        visited.add(node);
        for (Integer dest : nodeMap.get(node).getConnectedNodes()) {
          Node destee = nodeMap.get(dest);
          destee.distanceFromNodes[idx] = Math.min(destee.distanceFromNodes[idx], level);
          if (!visited.contains(dest)) hold.add(dest);
        }
      }
      level++;
      queue.addAll(hold);
    }
  }

  private static class Node {
    int value;
    List<Integer> connected = new ArrayList<>();
    int[] distanceFromNodes = new int[2];

    public Node(int value) {
      this.value = value;
      Arrays.fill(distanceFromNodes, MAX);
    }

    @Override
    public String toString() {
      return String.format("%d %s %s", value, connected, Arrays.toString(distanceFromNodes));
    }

    public void addEdge(int dest) {
      connected.add(dest);
    }

    public List<Integer> getConnectedNodes() {
      return connected;
    }
  }
}
