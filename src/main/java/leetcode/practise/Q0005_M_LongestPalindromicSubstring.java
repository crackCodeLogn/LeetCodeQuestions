package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-02-26
 */
public class Q0005_M_LongestPalindromicSubstring {

    private int maxLength = 0;
    private String palin = "";

    public static void main(String[] args) {
        Q0005_M_LongestPalindromicSubstring q0005MLongestPalindromicSubstring = new Q0005_M_LongestPalindromicSubstring();

        /*System.out.println(q0005MLongestPalindromicSubstring.longestPalindrome("cbbd"));
        System.out.println(q0005MLongestPalindromicSubstring.longestPalindrome("cbbdb"));
        System.out.println(q0005MLongestPalindromicSubstring.longestPalindrome("babad"));*/
        //System.out.println(q0005MLongestPalindromicSubstring.longestPalindrome("busislnescsicxpvvysuqgcudefrfjbwwjcchtgqyajdfwvkypfwshnihjdztgmyuuljxgvhdiwphrweyfkbnjgerkmifbirubhseuhrugwrabnjafnbdfjnufdstjbkuwtnpflffaqmjbhssjlnqftgjiglvvequhapasarlkcvbmkwnkuvwktbgfoaxteprobdwswcdyddyvrehvmxrrjiiidatidlpihkbmmruysmhhsncmfdanafdrfpdtfgkglcqpwrrtvacuicohspkounojuziittugpqjyhhkwfnflozbispehrtrnizowrlzcuollagxwtznjwzcumvedjwokueuqktvvouwnsmpxqvvpuwprezrbobrpnwaccwljchdguubjulyilzvmandjjleitweybqkjttschrjjlebnmponvlktzzcdtuybugggcqffkcffpamauvxfbonjrobgpvlyzveiwemmtdvbjciaytvesnocnjrwodtcokgcuoiicxapmrzpkfphjniuvzjrhbnqndfshoduejyktebgdabidxlkstepuwvtrtgbxaeheylicvhrxddijshcvdadxzsccmainyfpfdhqdanfccqkzlmhsfilvoybqojlvbcixjzqpbngdvesuokbxhkomsiqfyukvspqthlzxdnlwthrgaxhtpjzhrugqbfokrdcyurivmzgtynoqfjbafboselxnfupnpqlryvlcxeksirvufepfwczosrrjpudbwqxwldgjyfjhzlzcojxyqjyxxiqvfhjdwtgoqbyeocffnyxhyyiqspnvrpxmrtcnviukrjvpavervvztoxajriuvxqveqsrttjqepvvahywuzwtmgyrzduxfqspeipimyoxmkadrvrdyefekjxcmsmzmtbugyckcbjsrymszftjyllfmoeoylzeahnrxlxpnlvlvzltwnmldi"));
        //System.out.println(q0005MLongestPalindromicSubstring.longestPalindrome("ccc"));
        System.out.println(q0005MLongestPalindromicSubstring.longestPalindrome("ccd"));
        System.out.println(q0005MLongestPalindromicSubstring.longestPalindrome("cc"));
    }

    public String longestPalindrome(String s) {
        palin = "";
        maxLength = 0;
        operate(s);
        if (palin.isEmpty()) palin = s.charAt(0) + "";
        return palin;
    }

    private void operate(String data) {
        if (data.length() == 1) return;
        int i = 0;
        for (; i < data.length(); i++) {
            int currLength = 0;
            for (int j = 0; i - j >= 0 && j + i + 1 < data.length(); j++) {
                if (data.charAt(i - j) == data.charAt(i + j + 1)) {
                    currLength += 2;
                    if (currLength > maxLength) {
                        maxLength = currLength;
                        palin = data.substring(i - j, i + j + 2);
                    }
                } else
                    break;
            }
            currLength = 1;
            for (int j = 1; i - j >= 0 && j + i < data.length(); j++) {
                if (data.charAt(i - j) == data.charAt(i + j)) {
                    currLength += 2;
                    if (currLength > maxLength) {
                        maxLength = currLength;
                        palin = data.substring(i - j, i + j + 1);
                    }
                } else
                    break;
            }
        }
    }

    private void operate3(String data) {
        outer:
        for (int j = data.length(); j >= 2; j--) {
            for (int i = 0; i < data.length() - j + 1; i++) {
                String s1 = data.substring(i, i + j);
                StringBuilder s2 = new StringBuilder(s1).reverse();
                if (s1.equals(s2.toString())) {
                    palin = s1;
                    break outer;
                }
            }
        }
    }

    private void operate2(String data) {
        if (data.length() <= 1) return;
        if (data.length() <= maxLength) return;

        int mid = data.length() / 2, i = mid;
        int currLength = 1, j = i - 1, k = i + 1;
        if (isEven(data.length())) {
            i--;
            j--;
            boolean updated = false;
            if (data.charAt(i) == data.charAt(i + 1)) {
                if (maxLength < 2) {
                    maxLength = 2;
                    palin = data.substring(i, i + 2);
                    updated = true;
                }
            }
            if (!updated) {
                operate(data.substring(0, i));
                operate(data.substring(i + 1));
            }
            currLength++;
        }

        for (; j >= 0 && k < data.length(); j--, k++) {
            if (data.charAt(j) == data.charAt(k)) {
                currLength += 2;
                if (maxLength < currLength) {
                    maxLength = currLength;
                    palin = data.substring(j, k + 1);
                }
            } else {
                operate(data.substring(0, j + 1));
                operate(data.substring(k));
                break;
            }
        }
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
