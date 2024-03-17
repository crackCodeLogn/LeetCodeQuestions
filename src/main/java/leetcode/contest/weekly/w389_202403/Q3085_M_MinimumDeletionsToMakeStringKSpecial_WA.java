package leetcode.contest.weekly.w389_202403;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-03-17
 */
public class Q3085_M_MinimumDeletionsToMakeStringKSpecial_WA {
    private int k;
    private final Map<String, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        Q3085_M_MinimumDeletionsToMakeStringKSpecial_WA q3085MMinimumDeletionsToMakeStringKSpecialWA = new Q3085_M_MinimumDeletionsToMakeStringKSpecial_WA();
//        System.out.println(q3.minimumDeletions("aabcaba", 0)); // 3
//        System.out.println(q3.minimumDeletions("dabdcbdcdcd", 2)); // 2
//        System.out.println(q3.minimumDeletions("aaabaaa", 2)); // 1
        System.out.println(q3085MMinimumDeletionsToMakeStringKSpecialWA.minimumDeletions("ddwddddwdddw", 1)); // 3
        System.out.println(q3085MMinimumDeletionsToMakeStringKSpecialWA.minimumDeletions("ykekkdhehmhhympxhgjyjsmmkxerplpeegaqwqmswpmkldlllrywjqyeqlmwyphgprsdorlllpmmwdwxsxgkwaogxgglokjykrqyhaasjjxalxwdkjexdqksayxqplwmmleevdkdqdvgelmdhkqgryrqawxeammjhpwqgvdhygyvyqahvkjrrjvgpgqxyywwdvpgelvsprqodrvewqyajwjsrmqgqmardoqjmpymmvxxqoqvhywderllksxapamejdslhwpohmeryemphplqlkddyhqgpqykdhrehxwsjvaqymykjodvodjgqahrejxlykmmaxywdgaoqvgegdggykqjwyagdohjwpdypdwlrjksqkjwrkekvxjllwkgxxmhrwmxswmyrmwldqosavkpksjxwjlldhyhhrrlrwarqkyogamxmpqyhsldhajagslmeehakrxjxpjjmjpydgkehesoygvosrhvyhrqmdhlomgmrqjrmxyvmapmspmdygkhsprqsaxsvsrkovdjprjjyworgqoakrwarjsryydpmvhvyalawsmlsdgolsxgaqhryemvkpkhqvvagmxoapmsmwkrakldlhyojqhjjghjxgksroqpoxqsorrelhqeseegpqpewxydvkvaoaldmsdpmvogaykhpxkjkwmslqjsdqowkqawxadevkswdhywrxkpvqxmgeolayqojqqwxoomyasjrqrjmoearskssppmxpgwrmsjlsrjyqrjkgwjwglxogmkqjpjkwyaqxymelsyxypqxrjvpmssoakksemjhvaxm", 2)); // ? - 161
        System.out.println(q3085MMinimumDeletionsToMakeStringKSpecialWA.minimumDeletions("zjjlrhszrzihsmszcfmzualslrfvllmcrhhzviqzhqliikqlqvllhbbfqjqqlimjazbuuuvjibrzlrqjusmmhfsbuckaqjfujcfvakcjsujhavqarhfqfilkfrhufzjijhuciqijivmizrfrkuflasbmcfuafbihzqljlurzhlhjmkclkbajqhvlusrcczkbkrclihbalbjfcuqfzvqvfhfsvbjusukvsjczumvzkivvhlhzlimlqkmvskckvlrvsrsqsiufamuclrhzaljkmbbulachmvmkvqclfbckualsczjaklbrcruricrkkvqqbabrchriimjuszqszqrqimfaiqjbsmqahkafckjzfhkcuukcaiksifcruzavqrvmuasjahlhsjvzzarzffmrujbvsmjkbjflllmhzhzfjlasjfllcubablhizurvciuarjckkkuflhirhimlrmqqjufahcbvlrbjjzzrfvbkjlmzcfmmjklhschlucqjmlilbbkjqfrjukfubkklqrksmfcrfucculkulfllqmuzjbilrzfaliiqqfzccqrvkihsbacrrbikbkkbqfkchkcbjzfvhjkvlijhmjasklkzqlulkrbshqjcacmquusiirakbqlbluqmczfuucavrajhvmahaskhvulqamavjqhjcfqflafillcbfqfhbsqffrkafjzvrzhhzqmsqfhvlkuzlrljumvbkhqaufclmukhshvbrjfqvuvqmqibrsrjsrrsuamlqklmhqqvbcivfcclfkjhazmjikauvljqlfcsjqfquqklcrrfrjmauzkhkivalviqshvlcqmquhqcsrzbcmvikfbrrhicfjksbiuczsublbumhqquvrivfcffcljqcrakasubkvbqjfqzbhzszuaivzibuzcjhjaquqsvccjlhsmzjuibakczvjf", 1)); // ? - 188
        System.out.println(q3085MMinimumDeletionsToMakeStringKSpecialWA.minimumDeletions("ayjajyyyyyayjajjyayajajyyjyjyyajajjyayaajyyyjajaayayjajjayajyaaajjyayaayjjyyyjjjayajjayjjaaajyyjyayyyjyyjyayjjayayyjjjjjjyjyyyaajaaaayajyayjyayjjyajayayjayyjyjjyayayyyjjjyyjayyyjyajjjyjyjayjyjyjayjyaajayyjjjyayyjyyjajyyjayjjaayyyajaayjyayaayjjayaayajjyjaayjyjayayajayyyjaajjyaayyjjjjaayjyyyyyajjyjjj", 1)); // ? - 42
        System.out.println(q3085MMinimumDeletionsToMakeStringKSpecialWA.minimumDeletions("hvivihvivvovhiviiihhvhhhoiooohohihiviohvhoohovoivhhihivvvivhvoivhivvvhvihiovoiihohovihhohivivhihioooiviihihooviovoiovihhovhoivviovhihvvvvoviovhoovvoviohvviiohihiovioovvvoiviiooihvvoivhiooovvihovhohhviihhvovovvivvhvvhhovivhvoiihhvvihovoihhhiioiovhhihivovoohivohvhivihhhoviiiihviiiovhivhhhhivioovvovoiioiiiviivhiviohiihioihovivvvhiohoohvihohohhhhiohhihoiihvhivohhvhihhviooioohooohihoivihvovoihhoovohviihvihioiviooovohhvhvhioihohohhhoohhiihvivoiviiioovvovihhihohohvovoivoioohioovhoivvohhviioviioohhviohviihovhvhihvvhvohvohhiohiivohvvioovhoivioihhihvihvohohovohihohihvvhiohivihvioovovvvihhhhooohhihhhooiviihooioooovoioiivvivhihhhhhiohhhoihvvhoiviiiiohoovvhhoiiiiohhoivihhihiohhiiooioohhvhhhvovoiiihiioiiiiooioihivoiioihoohihvvohvoohvihohoiiihihvvvoihivooohiihvohivvhhihivvvoihoovvviihhhiivhihhovvvvhvoohihhvoiiihvvvihvhvvoihovvovvhvivohvivihohoihvivvihvhhvoiivivhivhvihovihoiviiovhvvvhvviihhihhovivihvvhvhiiovvohvhooooovviv", 1)); // ? - 80
    }

    public int minimumDeletions(String word, int k) {
        this.k = k;
        dp.clear();
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); i++) cnt[word.charAt(i) - 'a']++;
        List<Integer> data = new ArrayList<>();
        for (int i = 25; i >= 0; i--) if (cnt[i] > 0) data.add(cnt[i]);
        Collections.sort(data);
        //    return compute(data, 0, data.size() - 1);
        return compute(data);
    }

    /*private int compute(List<Integer> data, int low, int high) {
        if (low > high || Math.abs(data.get(low) - data.get(high)) <= k) return 0;
//        String s = data.toString();
//        if (dp.containsKey(s)) return dp.get(s);
        boolean flag = false;
        if (data.get(low) == 1) {
            low++;
            flag = true;
        } else data.set(low, data.get(low) - 1);

        int v1 = compute(data, low, high);
        if (flag) low--;
        else data.set(low, data.get(low) + 1);
        if (data.get(high) == 1) {
            high--;
//            data.remove(high);
        } else {
            data.set(high, data.get(high) - 1);
            int place = high - 1;
            for (; data.get(place) > data.get(high); place--) ;
            place++;
            Collections.swap(data, place, high);
        }
        int v2 = compute(data, low, high);
        int val = 1 + Math.min(v1, v2);
//        dp.put(s, val);
        return val;
    }*/

    /*private int compute(List<Integer> data) {
        if (data.size() == 1 || Math.abs(data.get(0) - data.get(data.size() - 1)) <= k) return 0;
        String s = data.toString();
        if (dp.containsKey(s)) return dp.get(s);

        List<Integer> d1 = data, d2 = data;
        int v = -1;

        if (d1.get(0) > 1) d1.set(0, d1.get(0) - 1);
        else {
            v = d1.remove(0);
        }

        int v1 = compute(d1);
        if (v == -1) data.set(0, data.get(0) + 1);
        else data.add(0, v);

        if (d2.get(d2.size() - 1) > 1) {
            d2.set(d2.size() - 1, d2.get(d2.size() - 1) - 1);
            int place = d2.size() - 2;
            for (; d2.get(place) > d2.get(d2.size() - 1); place--) ;
            place++;
            Collections.swap(d2, place, d2.size() - 1);
        } else d2.remove(d2.size() - 1);

        int v2 = compute(data);
        int val = 1 + Math.min(v1, v2);
        dp.put(s, val);
        return val;
    }*/

    private int compute(List<Integer> data) {
        int n = data.size();
        if (data.size() == 1 || Math.abs(data.get(0) - data.get(n - 1)) <= k) return 0;

        if (data.get(0) == 1) data.remove(0);
        else {
            if (data.get(n - 1) == 1) data.remove(n - 1);
            else {
                int d1 = data.get(n - 1) - data.get(0) + 1;
                int d2 = data.get(n - 1) - 1 - data.get(0);
                if (d1 <= d2) data.set(0, data.get(0) - 1);
                else {
                    data.set(n - 1, data.get(n - 1) - 1);
                    Collections.sort(data);
                }
            }
        }
        return 1 + compute(data);
    }
}
