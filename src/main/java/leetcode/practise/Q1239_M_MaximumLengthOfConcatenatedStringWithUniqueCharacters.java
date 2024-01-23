package leetcode.practise;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Vivek
 * @since 24/10/22
 * <p>
 * Reattempted on 2024-01-22, result is AC at 11ms
 * Lessons learnt:
 * - Memoization cannot work in this case
 * - Wasn't able to think of a bottom up approach either
 * - Ultimately drawing a huge tree using the example from line 22 helped demonstrate the paths to be taken,
 * which warrants a huffman encoding style tree construction with it becoming important to explore the paths
 * which can be taken, as the subsequent steps are NOT independent of previous ones, thus memoization didn't help.
 */
public class Q1239_M_MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    private int n;
    private int[] data;
    private List<String> arr;
    private int maxLength;

    public static void main(String[] args) {
        Q1239_M_MaximumLengthOfConcatenatedStringWithUniqueCharacters obj = new Q1239_M_MaximumLengthOfConcatenatedStringWithUniqueCharacters();
        System.out.println(obj.maxLength(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"))); //16
        System.out.println(obj.maxLength(Arrays.asList("un", "iq", "ue"))); //4
        System.out.println(obj.maxLength(Arrays.asList("cha", "r", "act", "ers"))); //6
        System.out.println(obj.maxLength(Arrays.asList("aa", "bb"))); //0
        System.out.println(obj.maxLength(Arrays.asList("jnfbyktlrqumowxd", "mvhgcpxnjzrdei"))); //16
        System.out.println(obj.maxLength(Arrays.asList("azt", "ab"))); //3
        System.out.println(obj.maxLength(Arrays.asList("ab", "azt"))); //3
    }

    public int maxLength3(List<String> arr) { //2nd accepted solution but at 27ms
        arr = arr.stream().filter(this::isGoodKeep).collect(Collectors.toList());
        this.arr = arr;
        this.n = arr.size();
        this.data = new int[n + 1];
        maxLength = 0;

        compute4(0, new HashSet<>(), 0);
        return maxLength;
    }

    private void compute4(int index, Set<Character> visited, int currentLength) {  //2nd accepted solution but at 27ms
        if (currentLength > maxLength) maxLength = currentLength;
        if (index >= n) return;

        String str = arr.get(index);
        Set<Character> local = new HashSet<>(visited);
        if (isGoodMatch(str, visited)) {
            compute4(index + 1, visited, currentLength + str.length());
        }
        compute4(index + 1, local, currentLength);
    }

    private boolean isGoodMatch(String str, Set<Character> visited) {  //2nd accepted solution but at 27ms
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (visited.contains(ch)) return false;
            visited.add(ch);
        }
        return true;
    }

    public int maxLength(List<String> arr) { // fastest at 11ms
        arr = arr.stream().filter(this::isGoodKeep).collect(Collectors.toList());
//        Collections.reverse(arr);
        this.arr = arr;
        this.n = arr.size();
        this.data = new int[n + 1];
        boolean[] visited = new boolean[27];
        maxLength = 0;

        compute(0, visited, 0);
        return maxLength;
    }

    private void compute(int index, boolean[] visited, int currentLength) { // fastest at 11ms
        if (currentLength > maxLength) maxLength = currentLength;
        if (index >= n) return;

        String str = arr.get(index);
        boolean[] local = Arrays.copyOf(visited, visited.length);
        if (isGoodMatch(str, visited)) {
            compute(index + 1, updateVisited(str, visited), currentLength + str.length());
        }
        compute(index + 1, local, currentLength);
    }

    private boolean isGoodKeep(String str) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'a';
            if (visited.contains(ch)) return false;
            else visited.add(ch);
        }
        return true;
    }

    private boolean isGoodMatch(String str, boolean[] visited) {
        for (int i = 0; i < str.length(); i++) if (visited[str.charAt(i) - 'a']) return false;
        return true;
    }

    private boolean[] updateVisited(String str, boolean[] visited) {
        for (int i = 0; i < str.length(); i++) visited[str.charAt(i) - 'a'] = true;
        return visited;
    }

    private int compute3(int index, boolean[] visited) { // WA
        if (index >= n) return 0;
        if (data[index] > 0) return data[index];

        String str = arr.get(index);
        int v2 = Math.max(isGoodMatch(str, visited) ? str.length() + compute3(index + 1, updateVisited(str, visited)) : compute3(index + 1, visited), compute3(index + 1, visited));
        data[index] = v2;
        return v2;
    }

    private List<String> getReduced(List<String> data) { // WA - ANCIENT
        List<String> result = new ArrayList<>();
        for (String val : data) if (noOverlap(val, "")) result.add(val);
        return result;
    }

    public int maxLength2(List<String> arr) { // WA - ANCIENT
        arr = getReduced(arr);
        if (arr.size() == 1) return arr.get(0).length();

        int maxLength = 0;
        String[][] data = new String[arr.size() + 1][arr.size() + 1];
        for (int j = 0; j < arr.size(); j++) {
            data[0][j] = arr.get(j);
        }
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = arr.get(i);
        }
        for (int i = 1; i < arr.size(); i++) {
            data[i][i] = arr.get(i - 1);
            for (int j = i + 1; j < arr.size(); j++) {
                data[i][j] = data[i - 1][j].length() > data[i][j - 1].length() ? data[i - 1][j] : data[i][j - 1];
                if (noOverlap(data[i][j - 1], data[i - 1][j])) {
                    String intermed = data[i][j - 1] + data[i - 1][j];
                    if (intermed.length() > data[i][j].length()) data[i][j] = intermed;
                    System.out.print(data[i][j] + " ");
                }
            }
            System.out.println();
        }
        return data[arr.size()][arr.size()].length();
        /*for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (noOverlap(arr.get(i), arr.get(j)))
                    maxLength = Math.max(maxLength, arr.get(i).length() + arr.get(j).length());
            }
        }*/
        //return maxLength;
    }

    private boolean noOverlap(String s1, String s2) { // WA - ANCIENT
        int[] data = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            data[ch - 'a']++;
            if (data[ch - 'a'] > 1) return false;
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (data[ch - 'a'] > 0) return false;
        }
        return true;
    }
}
