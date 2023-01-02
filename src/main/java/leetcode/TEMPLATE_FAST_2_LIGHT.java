package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vivek
 * @since 14/08/20
 */
public class TEMPLATE_FAST_2_LIGHT {

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

    private static long getGcd(long a, long b) {
        if (a == 0) return b;
        return getGcd(b % a, a);
    }

    private static long getLcm(long a, long b) {
        return (a * b) / getGcd(a, b);
    }

    private static boolean isOdd(long a) {
        return (a & 1) == 1;
    }

    private static boolean isEven(long a) {
        return !isOdd(a);
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

    private static BigInteger readBig() throws IOException {
        return new BigInteger(readLine());
    }

    private static double log2(int num) {
        return Math.log(num) / Math.log(2);
    }

    private static String readLine() throws IOException {
        return in.readLine().trim();
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

    private static void printArray(long[] data) {
        for (long t : data) out.print(t + " ");
        out.println();
    }
}