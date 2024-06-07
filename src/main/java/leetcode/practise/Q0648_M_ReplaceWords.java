package leetcode.practise;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-06-07
 */
public class Q0648_M_ReplaceWords {

    public static void main(String[] args) {
        Q0648_M_ReplaceWords q0648MReplaceWords = new Q0648_M_ReplaceWords();
        System.out.println(q0648MReplaceWords.replaceWords(Lists.newArrayList("cat", "bat", "rat"), "the cattle was rattled by the battery")); // the cat was rat by the bat
        System.out.println(q0648MReplaceWords.replaceWords(Lists.newArrayList("cat", "cate", "rat"), "the cattle was rattled by the battery")); // the cat was rat by the bat
        System.out.println(q0648MReplaceWords.replaceWords(Lists.newArrayList("a", "b", "c"), "aadsfasf absbs bbab cadsfafs")); // a a b c
        System.out.println(q0648MReplaceWords.replaceWords(Lists.newArrayList("e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm", "sb", "oo", "spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t", "xo", "apifm", "tlznm", "kkv", "nxyud", "j", "qp", "omn", "zoxp", "mutu", "i", "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem", "xsmwc", "vl", "farov", "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa", "xwz", "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz", "lzh", "lref", "qbx", "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels", "dfdq", "qzkx", "qxw"),
                "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp"));
    }

    private Node populateTrie(List<String> dictionary) {
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

    private String traverse(Node head, String data) {
        Node current = head;
        int i = 0;
        while (current != null) {
            if (i >= data.length()) return data;
            char ch = data.charAt(i);
            Node next = current.getLinkedNode(ch);
            if (next == null) return data;
            i++;
            if (next.isEndOfWord) break;
            current = next;
        }
        return data.substring(0, i);
    }

    public String replaceWords(List<String> dictionary, String sentence) { // 18ms
        Node head = populateTrie(dictionary);
        StringBuilder result = new StringBuilder();
        for (String part : sentence.split(" ")) result.append(traverse(head, part)).append(" ");
        return result.toString().strip();
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
            String sb = "Node{" + "ch=" + ch +
                    ", linked=" + linked +
                    ", isEndOfWord=" + isEndOfWord +
                    '}';
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
