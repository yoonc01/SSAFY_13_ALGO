import java.io.*;
import java.util.*;

public class Solution_d4_7465_창용마을무리의개수_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, m, arr[], a, b;

    static int getRoot(int a) {
        if (arr[a] != a) {
            arr[a] = getRoot(arr[a]);
        }
        return arr[a];
    }

    static void union(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);

        if (aRoot != bRoot) {
            arr[bRoot] = aRoot;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            Set<Integer> uniqueNumbers = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                arr[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            for (int i = 1; i <= n; i++) {
                uniqueNumbers.add(getRoot(i));
            }

            sb.append("#").append(tc).append(" ").append(uniqueNumbers.size()).append("\n");
        }
        System.out.print(sb);
    }
}
