import java.io.*;
import java.util.*;

public class Main_bj_2042_구간합구하기_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, k;
    static long a, b, c, arr[], tree[];

    public static void init() {
        tree = new long[4 * n];
        build(arr, 1, 0, n - 1);
    }

    public static void build(long[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public static long query(int left, int right) {
        return query(1, 0, n - 1, left, right);
    }

    public static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        long leftSum = query(2 * node, start, mid, left, right);
        long rightSum = query(2 * node + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }

    public static void update(int index, long newValue) {
        update(1, 0, n - 1, index, newValue);
    }

    public static void update(int node, int start, int end, int idx, long val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update((int) b - 1, c);
            } else {
                System.out.println(query((int) b - 1, (int) c - 1));
            }
        }
    }
}
