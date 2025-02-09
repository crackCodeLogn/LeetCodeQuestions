package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Vivek
 * @since 31-08-2019
 */
public class TEMPLATE_FAST_1 {

  static final double LOG_2 = Math.log(2);
  private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  private static final PrintWriter out = new PrintWriter(System.out);
  private static final int[] X_4W = {0, 1, 0, -1}; // S, E, N, W
  private static final int[] Y_4W = {1, 0, -1, 0}; // S, E, N, W

  private static final int[] X_8W = {0, 1, 1, 1, 0, -1, -1, -1};
  private static final int[] Y_8W = {1, 1, 0, -1, -1, -1, 0, 1};

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

  private static boolean isPerfectSquare(int n) {
    return Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n));
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

  private static long getLnds_Expensive(List<Long> a) { // longest non decreasing subsequence
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

  private static long getLcs_ExpensiveOp(
      List<Long> a, List<Long> sorted) { // longest common subsequence
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
    // printMatrix(matrix, sorted.size() + 1, a.size() + 1);
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
    factors.add(1);
    for (int i = 2; i * i <= n; i++)
      if (n % i == 0) {
        factors.add(i);
        if (i != n / i) factors.add(n / i);
      }
    factors.add(n);
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
    mapper.put(key, mapper.getOrDefault(key, 0) + 1);
  }

  private static <K> void decreaseCount(Map<K, Integer> mapper, K key) {
    decreaseCount(mapper, key, 1);
  }

  private static <K> void decreaseCount(Map<K, Integer> mapper, K key, int decCnt) {
    Integer val = mapper.get(key);
    if (val == decCnt) mapper.remove(key);
    else mapper.put(key, val - decCnt);
  }

  private static int fastPower(int a, int n) {
    int data = 1;
    while (n > 0) {
      int last_bit = (n & 1);
      if (last_bit > 0) data *= a;
      a *= a;
      n >>= 1;
    }
    return data;
  }

  private static int getMaxFromArray(int[] data) {
    int max = Integer.MIN_VALUE;
    for (int i = -1; ++i < data.length; ) if (data[i] > max) max = data[i];
    return max;
  }

  // Caller to absolutely guarantee that list is not empty, else null will be thrown back
  private static <V extends Number> V getMaxFromList(List<V> data) {
    int i = 0;
    if (data.isEmpty()) return null;
    V max = data.get(0);
    if (max instanceof Integer)
      while (++i < data.size())
        if (data.get(i).intValue() > max.intValue()) max = data.get(i);
        else if (max instanceof Long)
          while (++i < data.size())
            if (data.get(i).longValue() > max.longValue()) max = data.get(i);
            else if (max instanceof Double)
              while (++i < data.size())
                if (data.get(i).doubleValue() > max.doubleValue()) max = data.get(i);
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
    while (zeroCounts-- > 0) data = data.insert(0, "0"); // prefixing with "0"
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
    final List<Integer> primes = new ArrayList<>(); // faster than insertion in LinkedList

    for (int p = 2; p * p <= n; p++)
      if (prime[p]) for (int i = p * p; i <= n; i += p) prime[i] = false;

    // Print all prime numbers
    for (int i = 2; i <= n; i++) if (prime[i]) primes.add(i);
    return primes;
  }

  private static int[] sieveEratosthenes(int n) { // faster
    int[] minPrimeFactors = new int[n + 1];
    for (int i = 2; i <= n; ++i) minPrimeFactors[i] = i;
    for (int i = 2; i * i < n; ++i)
      if (minPrimeFactors[i] == i)
        for (int j = i * i; j < n; j += i) minPrimeFactors[j] = Math.min(minPrimeFactors[j], i);
    return minPrimeFactors;
  }

  private static List<Integer> getPrimeFactors(int num, int[] minPrimeFactors) { // faster
    List<Integer> primeFactors = new ArrayList<>();
    while (num > 1) {
      int divisor = minPrimeFactors[num];
      primeFactors.add(divisor);
      while (num % divisor == 0) num /= divisor;
    }
    return primeFactors;
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

  private static long readLong() throws IOException {
    return Long.parseLong(readLine());
  }

  private static double readDouble() throws IOException {
    return Double.parseDouble(readLine());
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

  private static void printArray(int[] data) {
    for (int t : data) System.out.print(t + " ");
    System.out.println();
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

  // expects input to be in format "[[1,0,0],[0,0,0],[0,0,1]]"
  private static List<List<Integer>> converter(String data) {
    List<List<Integer>> result = new ArrayList<>();
    data = data.substring(1, data.length() - 1);
    Pattern pattern = Pattern.compile("\\[(.*?)]");
    Matcher matcher = pattern.matcher(data);

    while (matcher.find()) {
      String str = matcher.group(0);
      str = str.substring(1, str.length() - 1);

      List<Integer> list =
          Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
      result.add(list);
    }
    return result;
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

  enum ORDER {
    ASC,
    DESC
  }

  public static String[] extractStringArray(String input) {
    if (input.isBlank()) return null;

    input = input.strip();
    int start = 0, end = input.length();
    if (input.charAt(0) == '[') start++;
    if (input.charAt(input.length() - 1) == ']') end--;
    input = input.substring(start, end);

    return Arrays.stream(input.split(","))
        .map(str -> str.strip().replaceAll("\"", ""))
        .toArray(String[]::new);
  }

  public static int[][] extractIntMatrix(String input) {
    if (input.isBlank()) return null;

    input = input.strip();
    int start = 0, end = input.length();
    if (input.charAt(0) == '[') start++;
    if (input.charAt(input.length() - 1) == ']') end--;
    input = input.substring(start, end);

    String[] parts = input.split("],\\[");
    int[][] matrix = new int[parts.length][2];
    for (int i = 0; i < parts.length; i++) {
      String[] subParts = parts[i].strip().split(",");
      subParts[0] = subParts[0].replaceAll("\\[", "");
      subParts[1] = subParts[1].replaceAll("]", "");
      matrix[i][0] = Integer.parseInt(subParts[0].strip());
      matrix[i][1] = Integer.parseInt(subParts[1].strip());
    }
    return matrix;
  }

  private static final class Pair<T, K> {
    private final T key;
    private final K value;

    public Pair(T key, K value) {
      this.key = key;
      this.value = value;
    }

    public T getKey() {
      return key;
    }

    public K getValue() {
      return value;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      Pair<T, K> other = (Pair<T, K>) obj;
      return key == other.key && value == other.value;
    }

    @Override
    public String toString() {
      return String.format("%s %s", key, value);
    }
  }

  // AdjacencyList based Graph, with Dijkstras algo incorporated
  static class Graph {
    private final Map<String, Integer> minCostMap = new HashMap<>();
    private final int V;
    private final List<List<Pair>> adj;

    Graph(int V) {
      this.V = V;
      adj = new ArrayList<>();
      for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
      }
    }

    void addDirectedEdge(int u, int v, int w) {
      adj.get(u).add(new Pair(v, w));
    }

    void addUndirectedEdge(int u, int v, int w) {
      addDirectedEdge(u, v, w);
      addDirectedEdge(v, u, w);
    }

    public Integer getMinCostForPair(String srcDestStringWithSpace) {
      return minCostMap.get(srcDestStringWithSpace);
    }

    /** requires the weights to be +ve, as it uses Dijkstras */
    void calculateShortestPathFromAllToAll() {
      for (int i = 0; i < V; i++) shortestPath(i);
    }

    /**
     * requires the weights to be +ve, as it uses Dijkstras
     *
     * @param src: from where to find the shortest path to all the other 'connected' vertices
     */
    void shortestPath(int src) {
      PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.first));
      int[] dist = new int[V];
      Arrays.fill(dist, Integer.MAX_VALUE);

      pq.add(new Pair(0, src));
      dist[src] = 0;

      while (!pq.isEmpty()) {
        int u = pq.poll().second;

        for (Pair v : adj.get(u)) {
          if (dist[v.first] > dist[u] + v.second) {
            dist[v.first] = dist[u] + v.second;
            pq.add(new Pair(dist[v.first], v.first));
          }
        }
      }

      // System.out.println("Vertex Distance from Source");
      for (int i = 0; i < V; i++) {
        if (dist[i] != Integer.MAX_VALUE) {
          String key = src + " " + i;
          // System.out.println(i + "\t\t" + dist[i]);
          minCostMap.put(key, dist[i]);
        }
      }
    }

    static class Pair {
      int first, second;

      Pair(int first, int second) {
        this.first = first;
        this.second = second;
      }
    }
  }
}
