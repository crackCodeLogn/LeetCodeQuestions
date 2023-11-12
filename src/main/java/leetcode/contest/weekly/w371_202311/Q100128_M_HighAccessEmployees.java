package leetcode.contest.weekly.w371_202311;

import java.util.*;

/**
 * @author Vivek
 * @since 2023-11-12
 */
public class Q100128_M_HighAccessEmployees {

    public static void main(String[] args) {
        Q100128_M_HighAccessEmployees q100128MHighAccessEmployees = new Q100128_M_HighAccessEmployees();
        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("1210");
        List<List<String>> val = new ArrayList<>();
        val.add(data);
        data = new ArrayList<>();
        data.add("b");
        data.add("0457");
        val.add(data);
        data = new ArrayList<>();
        data.add("a");
        data.add("1106");
        val.add(data);
        data = new ArrayList<>();
        data.add("a");
        data.add("1144");
        val.add(data);
        data = new ArrayList<>();
        data.add("a");
        data.add("1255");
        val.add(data);
        System.out.println(q100128MHighAccessEmployees.findHighAccessEmployees(val));
    }

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, Node> map = new HashMap<>();
        access_times.forEach(entry -> {
            map.computeIfPresent(entry.get(0), (key, node) -> {
                node.addAccessTime(entry.get(1));
                return node;
            });
            map.computeIfAbsent(entry.get(0), (key) -> {
                Node node = new Node(entry.get(0));
                node.addAccessTime(entry.get(1));
                return node;
            });

            /*if (map.containsKey(entry.get(0))) {
                map.get(entry.get(0)).addAccessTime(entry.get(1));
            } else {
                Node node = new Node(entry.get(0));
                node.addAccessTime(entry.get(1));
                map.put(entry.get(0), node);
            }*/
        });
        List<String> names = new ArrayList<>();
        for (Node node : map.values()) {
            int cnt = 1;
            Collections.sort(node.getSeconds());
            for (int i = 0; i < node.getSeconds().size(); i++) {
                cnt = 1;
                int base = node.getSeconds().get(i);
                for (int j = i + 1; j < node.getSeconds().size() && node.getSeconds().get(j) - base < 3600; j++, cnt++)
                    ;
                if (cnt >= 3) break;
            }
            if (cnt >= 3) names.add(node.getName());
        }
        return names;
    }

    static class Node {
        private final String name;
        private final List<Integer> seconds = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Integer> getSeconds() {
            return seconds;
        }

        public void addAccessTime(String time) {
            seconds.add(3600 * (Integer.parseInt(time.substring(0, 2))) + 60 * (Integer.parseInt(time.substring(2))));
        }
    }
}
