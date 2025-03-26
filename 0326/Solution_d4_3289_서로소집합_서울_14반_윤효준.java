import java.io.*;
import java.util.*;

public class Solution_d4_3289_서로소집합_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, m, cmd, a, b, arr[];

    static int getRoot(int a) {
        if (arr[a] != a)
            arr[a] = getRoot(arr[a]);
        return arr[a];
    }

    static void union(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);

        if (aRoot != bRoot)
            arr[bRoot] = aRoot;
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sb.append("#").append(tc).append(" ");

            arr = new int[n + 1];
            for (int i = 0; i < n + 1; i++)
                arr[i] = i;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                cmd = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if (cmd == 0)
                    union(a, b);
                else {
                    if (getRoot(a) == getRoot(b))
                        sb.append(1);
                    else
                        sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
