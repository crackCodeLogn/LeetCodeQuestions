package leetcode.practise;

import java.util.*;

public class Q3607_M_PowerGridMaintenance {
    Map<Integer, Node> nodeMap = new HashMap<>();
    Map<Integer, TreeSet<Integer>> colorStationsMap = new HashMap<>();
    Map<Integer, TreeSet<Integer>> colorOperationalMap = new HashMap<>();
    Map<Integer, Integer> stationColorMap = new HashMap<>();

    public int[] processQueries(int c, int[][] connections, int[][] queries) { // 442ms, beats 5.02%
        List<Integer> result = new ArrayList<>();
        int seq = 1;
        nodeMap.clear();
        colorStationsMap.clear();
        colorOperationalMap.clear();
        stationColorMap.clear();


        for (int i = 1; i <= c; i++) nodeMap.put(i, new Node(i));

        for (int[] connection : connections) {
            int src = connection[0], dest = connection[1];
            nodeMap.get(src).addStation(dest);
            nodeMap.get(dest).addStation(src);
        }

        bfs(1, seq);
        for (int i=2;i<=c;i++) if (!nodeMap.get(i).isColored()) bfs(i, ++seq);

        for (int[] query : queries) {
            int mode = query[0], x =  query[1];
            if (mode == 2) {
                nodeMap.get(x).turnOff();
                colorOperationalMap.get(nodeMap.get(x).getColor()).remove(x);
            } else {
                if (nodeMap.get(x).isOperational()) result.add(x);
                else {
                    TreeSet<Integer> operationals = colorOperationalMap.get(nodeMap.get(x).getColor());
                    result.add(operationals.isEmpty() ? -1 : operationals.first());
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) res[i] = result.get(i);
        return res;
    }

    private void bfs(int src, int colorSeq) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            Node curNode = nodeMap.get(cur);
            if (!curNode.isColored()) {
                curNode.setColor(colorSeq);
                queue.addAll(curNode.getConnectedStations());

                if (!colorStationsMap.containsKey(colorSeq)) colorStationsMap.put(colorSeq, new TreeSet<>());
                colorStationsMap.get(colorSeq).add(cur);
                // colorStationsMap.compute(colorSeq, (k,v) -> v == null ? new TreeSet<>() : v).add(cur); // these bumped the 442 ms to 477 ms

                if (!colorOperationalMap.containsKey(colorSeq)) colorOperationalMap.put(colorSeq, new TreeSet<>());
                colorOperationalMap.get(colorSeq).add(cur);
                // colorOperationalMap.compute(colorSeq, (k,v) -> v == null ? new TreeSet<>() : v).add(cur);

                stationColorMap.put(cur, colorSeq);
            }
        }
    }

    private final class Node {
        private final int station;
        private final Set<Integer> connectedStations;
        private boolean operational;
        private int color;

        public Node(int station) {
            this.station = station;
            this.connectedStations = new HashSet<>();
            color = -1;
            operational = true;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public boolean isOperational() {
            return operational;
        }

        public void turnOff() {
            operational = false;
        }

        public boolean isColored() {
            return color != -1;
        }

        public void addStation(int station) {
            connectedStations.add(station);
        }

        public Set<Integer> getConnectedStations() {
            return connectedStations;
        }

        public boolean isStationConnected(int station) {
            return connectedStations.contains(station);
        }
    }
}
