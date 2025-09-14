package leetcode.practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 9/13/25
 */
public class Q0966_M_VowelSpellchecker {

  public static void main(String[] args) {
    Q0966_M_VowelSpellchecker q0966MVowelSpellchecker = new Q0966_M_VowelSpellchecker();
    System.out.println(
        Arrays.toString(
            q0966MVowelSpellchecker.spellchecker(
                new String[] {"eaiu", "aeio", "auoi"}, new String[] {"aoue"})));

    System.out.println(
        Arrays.toString(
            q0966MVowelSpellchecker.spellchecker(
                new String[] {"KiTe", "kite", "hare", "Hare", "kitD"},
                new String[] {
                  "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto",
                  "kITE"
                })));

    System.out.println(
        Arrays.toString(
            q0966MVowelSpellchecker.spellchecker(
                new String[] {"yellow"}, new String[] {"YellOw"})));
  }

  private String getStrippedVersion(String str) {
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < str.length(); i++) if (isVowel(str.charAt(i))) sb.setCharAt(i, '-');
    return sb.toString();
  }

  /*private boolean queryTrie(Node rootTrie, String lower) {
    Node current = rootTrie;
    for (int i = 0; i < lower.length(); i++) {
      char ch = lower.charAt(i);
      if (current.isChild(ch)) {
        current = current.getNode(ch);
      } else {

      }
    }
  }*/

  public String[] spellchecker(
      String[] wordlist,
      String[]
          queries) { // 41ms, beats 32.23% - didn't use the trie approach due to querying complexity
    Set<String> words = new HashSet<>();
    Set<Integer> lengths = new HashSet<>();
    Map<String, LinkedHashSet<String>> map = new HashMap<>();
    Map<String, LinkedHashSet<String>> secMap = new HashMap<>();
    Node rootTrie = new Node('\0');

    for (String word : wordlist) {
      words.add(word);
      String lower = word.toLowerCase();
      if (!map.containsKey(lower)) map.put(lower, new LinkedHashSet<>());
      map.get(lower).add(word);
      lengths.add(word.length());

      String stripLower = getStrippedVersion(lower);
      if (!secMap.containsKey(stripLower)) secMap.put(stripLower, new LinkedHashSet<>());
      secMap.get(stripLower).add(word);

      // consumeTrie(rootTrie, lower);
    }
    String[] data = new String[queries.length];
    int index = 0;
    for (String query : queries) {
      if (words.contains(query)) {
        data[index++] = query;
        continue;
      }
      if (!lengths.contains(query.length())) {
        data[index++] = "";
        continue;
      }
      String lower = query.toLowerCase();
      if (map.containsKey(lower)) {
        data[index++] = map.get(lower).iterator().next();
        continue;
      }
      // query trie
      // data[index++] = queryTrie(rootTrie, lower) ? map.get(lower).iterator().next() : "";
      String stripLower = getStrippedVersion(lower);
      data[index++] =
          secMap.containsKey(stripLower) ? secMap.get(stripLower).iterator().next() : "";
    }

    return data;
  }

  private void consumeTrie(Node rootTrie, String lower) {
    Node current = rootTrie;
    for (int i = 0; i < lower.length(); i++) {
      char ch = lower.charAt(i);
      if (!current.isChild(ch)) {
        current = current.addNode(ch);
      } else current = current.getNode(ch);
    }
  }

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E'
        || ch == 'I' || ch == 'O' || ch == 'U';
  }

  private static final class Node {
    private final char ch;
    private final Map<Character, Node> nodes = new HashMap<>();

    public Node(char ch) {
      this.ch = ch;
    }

    public Node addNode(char ch) {
      Node node = nodes.get(ch);
      if (node == null) {
        node = new Node(ch);
        nodes.put(ch, node);
      }
      return node;
    }

    public boolean isChild(char ch) {
      return nodes.containsKey(ch);
    }

    public Node getNode(char ch) {
      return nodes.get(ch);
    }

    public char getCh() {
      return ch;
    }
  }
}
