package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-02-06
 */
public class Q0049_M_GroupAnagrams {

    private static final Map<String, List<String>> data = new HashMap<>();

    public static void main(String[] args) {
        Q0049_M_GroupAnagrams q0049MGroupAnagrams = new Q0049_M_GroupAnagrams();
        System.out.println(q0049MGroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(q0049MGroupAnagrams.groupAnagrams(new String[]{""}));
        System.out.println(q0049MGroupAnagrams.groupAnagrams(new String[]{"a"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        data.clear();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if (data.containsKey(key)) data.get(key).add(strs[i]);
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                data.put(key, list);
            }
        }
        return new ArrayList<>(data.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        List<Node> nodes = new ArrayList<>(strs.length);
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            nodes.add(new Node(strs[i], new String(ch)));
        }
        nodes.sort(Comparator.comparing(Node::getArrange));
        List<List<String>> result = new ArrayList<>();
        String last = nodes.get(0).arrange;
        List<String> buff = new ArrayList<>();
        buff.add(nodes.get(0).orig);
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i).arrange.equals(last)) buff.add(nodes.get(i).orig);
            else {
                result.add(buff);
                buff = new ArrayList<>();
                buff.add(nodes.get(i).orig);
            }
            last = nodes.get(i).arrange;
        }
        if (!buff.isEmpty()) result.add(buff);
        return result;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        data.clear();
        for (int i = 0; i < strs.length; i++) {
            String key = getCount(strs[i]);
            List<String> list = data.get(key);
            if (list == null) list = new ArrayList<>();
            list.add(strs[i]);
            data.put(key, list);
        }
        return new ArrayList<>(data.values());
    }

    private String getCount(String str) {
        int[] cnt = new int[27];
        for (int i = 0; i < str.length(); i++) cnt[str.charAt(i) - 'a']++;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) res.append(String.format("%d-%d ", i, cnt[i]));
        return res.toString();
    }

    private static class Node {
        final String orig;
        final String arrange;

        public Node(String orig, String arrange) {
            this.orig = orig;
            this.arrange = arrange;
        }

        public String getArrange() {
            return arrange;
        }
    }
}
