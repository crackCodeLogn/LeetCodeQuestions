package leetcode.practise;

public class Q1255_H_MaximumScoreWordsFormedByLetters {

    public static void main(String[] args) {
        Q1255_H_MaximumScoreWordsFormedByLetters q1255HMaximumScoreWordsFormedByLetters = new Q1255_H_MaximumScoreWordsFormedByLetters();
        System.out.println(q1255HMaximumScoreWordsFormedByLetters.maxScoreWords(new String[]{"dog", "cat", "dad", "good"},
                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'}, new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char c : letters) count[c - 'a']++;
        return dfs(words, 0, count, score);
    }

    private int dfs(String[] words, int s, int[] count, int[] score) {
        int ans = 0;
        for (int i = s; i < words.length; i++) {
            int earned = useWord(words, i, count, score);
            if (earned > 0) ans = Math.max(ans, earned + dfs(words, i + 1, count, score));
            unuseWord(words, i, count);
        }
        return ans;
    }

    int useWord(String[] words, int i, int[] count, int[] score) {
        boolean isValid = true;
        int earned = 0;
        for (char c : words[i].toCharArray()) {
            if (--count[c - 'a'] < 0) isValid = false;
            earned += score[c - 'a'];
        }
        return isValid ? earned : -1;
    }

    void unuseWord(String[] words, int i, int[] count) {
        for (char c : words[i].toCharArray()) count[c - 'a']++;
    }
}
