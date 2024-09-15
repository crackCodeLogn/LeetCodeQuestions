package leetcode.contest.weekly.w415_202409;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-09-14
 */
public class Q3291_M_MinimumNumberOfValidStringsToFormTargetI_WA {
  public static void main(String[] args) {
    Q3291_M_MinimumNumberOfValidStringsToFormTargetI_WA
        q3291MMinimumNumberOfValidStringsToFormTargetI =
            new Q3291_M_MinimumNumberOfValidStringsToFormTargetI_WA();
    System.out.println(
        q3291MMinimumNumberOfValidStringsToFormTargetI.minValidStrings(
            new String[] {"abc", "aaaaa", "bcdef"}, "aabcdabc")); // 3
    System.out.println(
        q3291MMinimumNumberOfValidStringsToFormTargetI.minValidStrings(
            new String[] {"abababab", "ab"}, "ababaababa")); // 2
    System.out.println(
        q3291MMinimumNumberOfValidStringsToFormTargetI.minValidStrings(
            new String[] {"abcdef"}, "xyz")); // -1
    System.out.println(
        q3291MMinimumNumberOfValidStringsToFormTargetI.minValidStrings(
            new String[] {"b", "ccacc", "a"}, "cccaaaacba")); // 8
  }

  public int minValidStrings(String[] words, String target) {
    Set<String> set = new HashSet<>();
    int prefLen = 0;
    for (String word : words) {
      for (int i = 1; i <= word.length(); i++) {
        set.add(word.substring(0, i));
      }
      prefLen = Math.max(prefLen, word.length());
    }
    // System.out.println(set);
    int cnt = 0;
    for (int i = target.length() - 1; i >= 0; i--) {
      int j = 0;
      int maxLen = -1, index = 0;
      for (j = i; j >= 0; j--) {
        if (i - j > prefLen) break;
        if (set.contains(target.substring(j, i + 1))) {
          maxLen = Math.max(maxLen, i - j);
          index = j;
        }
      }
      if (maxLen == -1) return -1;
      i = index;
      cnt++;
    }
    return cnt;
  }

  public int minValidStrings2(String[] words, String target) {
    Node root = populateTrie(words);
    return traverse(root, target);
  }

  private Node populateTrie(String[] dictionary) {
    Node head = new Node('\0');
    for (String word : dictionary) {
      Node current = head;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (!current.containsLink(ch)) current.addLink(ch);
        current = current.getLinkedNode(ch);
      }
      current.markEndOfWord();
    }
    return head;
  }

  private int traverse(Node head, String data) {
    Node current = head;
    int i = 0;
    int cnt = 0;
    while (current != null) {
      if (i >= data.length()) return cnt + 1;

      char ch = data.charAt(i);
      Node next = current.getLinkedNode(ch);
      if (next == null && !head.containsLink(ch)) { // link not found
        break;
      } else if (next == null) {
        next = head.getLinkedNode(ch);
        cnt++;
      }
      i++;
      current = next;
    }
    return -1;
  }

  private static final class Node {
    private final char ch;
    private final Map<Character, Node> linked;
    private boolean isEndOfWord;

    public Node(char ch) {
      this.ch = ch;
      this.linked = new HashMap<>();
      isEndOfWord = false;
    }

    @Override
    public String toString() {
      String sb =
          "Node{" + "ch=" + ch + ", linked=" + linked + ", isEndOfWord=" + isEndOfWord + '}';
      return sb;
    }

    public char getCh() {
      return ch;
    }

    public void addLink(char ch) {
      linked.put(ch, new Node(ch));
    }

    public boolean containsLink(char ch) {
      return linked.containsKey(ch);
    }

    public Node getLinkedNode(char ch) {
      return linked.get(ch);
    }

    public void markEndOfWord() {
      isEndOfWord = true;
    }
  }
}
