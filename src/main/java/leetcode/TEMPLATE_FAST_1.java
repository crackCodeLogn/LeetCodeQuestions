package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Vivek
 * @since 31-08-2019
 */
public class TEMPLATE_FAST_1 {

    final static double LOG_2 = Math.log(2);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = readInt();
        while (t-- > 0) {
            List<Long> inp = readLongs();
        }
        out.flush();
        out.close();
        in.close();
    }

    private static Integer getLogBase2(long n) {
        return (int) (Math.log(n) / LOG_2);
    }

    private static boolean isOdd(long a) {
        return (a & 1) == 1;
    }

    private static boolean isEven(long a) {
        return !isOdd(a);
    }

    private static long nC2(long n) {
        return n * (n - 1) / 2;
    }

    private static long fastExponentiation(long base, long power, long mod) {
        long val = 1;
        base %= mod;
        if (base == 0) return 0;
        while (power > 0) {
            if (isOdd(power)) val = (val * base) % mod;
            power = power >> 1;
            base = (base * base) % mod;
        }
        return val;
    }

    private static long getLnds_Expensive(List<Long> a) { //longest non decreasing subsequence
        List<Long> sorted = new ArrayList<>(a);
        Collections.sort(sorted);
        return getLcs_ExpensiveOp(a, sorted);
    }

    private static long[] getLis(List<Long> nums) {
        long[] lis = new long[nums.size()];
        int size = 0;
        for (long x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (lis[m] <= x) i = m + 1;
                else j = m;
            }
            lis[i] = x;
            if (i == size) size++;
        }
        return Arrays.copyOfRange(lis, 0, size);
    }

    private static long getLcs_ExpensiveOp(List<Long> a, List<Long> sorted) { //longest common subsequence
        Long[][] matrix = new Long[sorted.size() + 1][a.size() + 1];

        for (int i = 0; i <= sorted.size(); i++) {
            for (int j = 0; j <= a.size(); j++) {
                long val;
                if (i == 0 || j == 0) val = 0L;
                else if (sorted.get(i - 1) == a.get(j - 1)) val = 1 + matrix[i - 1][j - 1];
                else val = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                matrix[i][j] = val;
            }
        }
        //printMatrix(matrix, sorted.size() + 1, a.size() + 1);
        return matrix[sorted.size()][a.size()];
    }

    private static long getGcd(long a, long b) {
        if (a == 0) return b;
        return getGcd(b % a, a);
    }

    private static long getLcm(long a, long b) {
        return (a * b) / getGcd(a, b);
    }

    private static List<Integer> getFactors(int n) {
        List<Integer> factors = new ArrayList<>(n / 2);
        for (int i = 1; i <= Math.sqrt(n); i++) if (n % i == 0) factors.add(i);
        return factors;
    }

    private static long getFactors(long n) {
        if (n == 1) return 1;
        long vals = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                if (n / i == i) vals++;
                else vals += 2;
            }
        return vals;
    }

    private static void augmentCount(Integer[] counter, int key) {
        counter[key]++;
    }

    private static void decreaseCount(Integer[] counter, int key) {
        counter[key]--;
    }

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    private static <K> void decreaseCount(Map<K, Integer> mapper, K key) {
        decreaseCount(mapper, key, 1);
    }

    private static <K> void decreaseCount(Map<K, Integer> mapper, K key, int decCnt) {
        Integer val = mapper.get(key);
        if (val == decCnt) mapper.remove(key);
        else mapper.put(key, val - decCnt);
    }

    private static int getMaxFromArray(int[] data) {
        int max = Integer.MIN_VALUE;
        for (int i = -1; ++i < data.length; ) if (data[i] > max) max = data[i];
        return max;
    }

    //Caller to absolutely guarantee that list is not empty, else null will be thrown back
    private static <V extends Number> V getMaxFromList(List<V> data) {
        int i = 0;
        if (data.isEmpty()) return null;
        V max = data.get(0);
        if (max instanceof Integer)
            while (++i < data.size()) if (data.get(i).intValue() > max.intValue()) max = data.get(i);
            else if (max instanceof Long)
                while (++i < data.size()) if (data.get(i).longValue() > max.longValue()) max = data.get(i);
                else if (max instanceof Double)
                    while (++i < data.size()) if (data.get(i).doubleValue() > max.doubleValue()) max = data.get(i);
        return max;
    }

    private static <V extends Number> V getMaxFromList(Collection<V> data) {
        return getMaxFromList(new ArrayList<V>(data));
    }

    private static int safeRotate(int i, int n) { // 0-indexed
        return (i + 1) % n;
    }

    private static String getBinary(int v) {
        return Integer.toBinaryString(v);
    }

    private static String getBinary(long v) {
        return Long.toBinaryString(v);
    }

    private static String preInflateBinaryString(String inp, int zeroCounts) {
        StringBuilder data = new StringBuilder(inp);
        while (zeroCounts-- > 0) data = data.insert(0, "0"); //prefixing with "0"
        return data.toString();
    }

    private static int getNumberOfSetBits(int v) {
        return Integer.bitCount(v);
    }

    private static long getNumberOfSetBits(long v) {
        return Long.bitCount(v);
    }

    private static long getNumberOfDivisors(long n) {
        return getDivisors(n).size();
    }

    private static Set<Long> getDivisors(long n) {
        long upper = (long) Math.sqrt(n);
        Set<Long> set = new HashSet<>();
        for (long i = 1; i <= upper; i++)
            if (n % i == 0) {
                set.add(n / i);
                set.add(i);
            }
        return set;
    }

    private static Set<Integer> getPrimeDivisors(List<Integer> primes, int n) {
        Set<Integer> primeDivisors = new HashSet<>();
        for (int i = -1, product = n; product > 1 && ++i < primes.size(); ) {
            int prime = primes.get(i);
            while (product % prime == 0) {
                primeDivisors.add(prime);
                product /= prime;
            }
        }
        return primeDivisors;
    }

    private static boolean isPrime(long n) {
        if (n == 1 || (n > 2 && isEven(n))) return false;
        long upper = (long) Math.sqrt(n);
        for (long i = 3; i <= upper; i += 2) if (n % i == 0) return false;
        return true;
    }

    private static List<Integer> classicSieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        final List<Integer> primes = new ArrayList<>(); //faster than insertion in LinkedList

        for (int p = 2; p * p <= n; p++)
            if (prime[p]) for (int i = p * p; i <= n; i += p) prime[i] = false;

        // Print all prime numbers
        for (int i = 2; i <= n; i++) if (prime[i]) primes.add(i);
        return primes;
    }

    private <T> void swap(T[] data, int i, int j) {
        T buff = data[i];
        data[i] = data[j];
        data[j] = buff;
    }

    private <T> void swap(List<T> data, int i, int j) {
        T buff = data.get(i);
        data.set(i, data.get(j));
        data.set(j, buff);
    }

    private static <T> List<List<T>> extractPowerSets(List<T> data) {
        int upper = 1 << data.size();
        List<List<T>> powerSets = new ArrayList<>(upper);
        for (int i = -1; ++i < upper; ) {
            List<T> powerSet = new LinkedList<>();
            for (int j = 0; j < data.size(); j++) if ((i & (1 << j)) > 0) powerSet.add(data.get(j));
            powerSets.add(powerSet);
        }
        return powerSets;
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(readLine());
    }

    /*
    //F() works but commenting for the sake of TEMPLATE getting appended on each copy
    private static <V, S extends Comparable<? super S>> Map<V, S> sortMapOnValues(Map<V, S> dataMap, ORDER order) {
        final Comparator<Map.Entry<V, S>> comparator = Map.Entry.comparingByValue();
        final List<Map.Entry<V, S>> list = new ArrayList<>(dataMap.entrySet());
        if (ORDER.ASC.equals(order)) list.sort(comparator);
        if (ORDER.DESC.equals(order)) list.sort(comparator.reversed());

        final Map<V, S> data = new LinkedHashMap<>();
        list.forEach((entry) -> data.put(entry.getKey(), entry.getValue()));
        return data;
    }
     */

    private static long readLong() throws IOException {
        return Long.parseLong(readLine());
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(readLine());
    }

    private static BigInteger readBig() throws IOException {
        return new BigInteger(readLine());
    }

    private static String readLine() throws IOException {
        return in.readLine();
    }

    private static String[] readLineArr() throws IOException {
        return readLine().split(" ");
    }

    private static List<Integer> readInts() throws IOException {
        final List<Integer> list = new ArrayList<>();
        String[] input = readLineArr();
        for (int i = -1; ++i < input.length; ) list.add(Integer.parseInt(input[i]));
        return list;
    }

    private static List<Long> readLongs() throws IOException {
        final List<Long> list = new ArrayList<>();
        String[] input = readLineArr();
        for (int i = -1; ++i < input.length; ) list.add(Long.parseLong(input[i]));
        return list;
    }

    private static Integer[] readIntsAsArray() throws IOException {
        String[] strings = readLineArr();
        Integer[] ints = new Integer[strings.length];
        for (int i = 0; i < ints.length; i++) ints[i] = Integer.parseInt(strings[i]);
        return ints;
    }

    private static Long[] readLongsAsArray() throws IOException {
        String[] strings = readLineArr();
        Long[] longs = new Long[strings.length];
        for (int i = 0; i < longs.length; i++) longs[i] = Long.parseLong(strings[i]);
        return longs;
    }

    private static <T> void printArray(T[] data) {
        for (T t : data) out.print(t + " ");
        out.println();
    }

    private static <T> void printCollection(Collection<T> data) {
        data.forEach(t -> out.print(t + " "));
        out.println();
    }

    private static <T> void printMatrix(T[][] data, int rows, int columns) {
        for (int i = -1; ++i < rows; ) {
            for (int j = -1; ++j < columns; ) out.print(data[i][j] + " ");
            out.println();
        }
    }

    private static <T> void printList(List<T> data) {
        for (int i = -1; ++i < data.size(); ) out.printf(data.get(i) + " ");
        out.println();
    }

    enum ORDER {
        ASC, DESC
    }

    private static class Pair<T, K> {
        private final T first;
        private final K second;

        public Pair(T first, K second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public K getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return String.format("%s %s", first, second);
        }
    }
}
