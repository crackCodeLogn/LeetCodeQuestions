package leetcode.practise;

public class Q2486_M_AppendCharactersToStringToMakeSubsequence {

    public static void main(String[] args) {
        Q2486_M_AppendCharactersToStringToMakeSubsequence q2486MAppendCharactersToStringToMakeSubsequence = new Q2486_M_AppendCharactersToStringToMakeSubsequence();
        System.out.println(q2486MAppendCharactersToStringToMakeSubsequence.appendCharacters("coaching", "coding")); // 4
        System.out.println(q2486MAppendCharactersToStringToMakeSubsequence.appendCharacters("abcde", "a")); // 0
        System.out.println(q2486MAppendCharactersToStringToMakeSubsequence.appendCharacters("z", "abcde")); // 5
    }

    public int appendCharacters(String s, String t) {
        int ptr1 = 0, ptr2 = 0;

        while (ptr2 < t.length()) {
            char ch2 = t.charAt(ptr2);
            while (ptr1 < s.length() && ch2 != s.charAt(ptr1)) ptr1++;
            if (ptr1 == s.length()) break;
            if (ch2 == s.charAt(ptr1)) ptr1++;
            ptr2++;
        }
        return t.length() - ptr2;
    }
}
