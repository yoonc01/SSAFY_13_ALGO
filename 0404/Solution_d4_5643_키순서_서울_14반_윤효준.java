import java.io.*;
import java.util.*;

public class Solution_d4_5643_키순서_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, m, start, end, ans, lower[], upper[];
    static boolean G[][];

    public static void checkLower(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[n + 1];
        int cnt = 0;
        q.offer(start);
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i < n + 1; i++) {
                if (G[i][node] && !visited[i]) {
                	q.offer(i);
                    visited[i] = true;
                	cnt++;
                }
            }
        }
        lower[start] = cnt;
    }

    public static void checkUpper(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[n + 1];

        int cnt = 0;
        q.offer(start);
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i < n + 1; i++) {
                if (G[node][i] && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                	cnt++;
                }
            }
        }
        upper[start] = cnt;
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            ans = 0;

            G = new boolean[n + 1][n + 1];
            lower = new int[n + 1];
            upper = new int[n + 1];
            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                G[start][end] = true;
            }
            for (int i = 1; i < n + 1; i++) {
                checkLower(i);
                checkUpper(i);
                if (lower[i] + upper[i] == n - 1)
                    ans++;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}