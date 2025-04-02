import java.io.*;
import java.util.*;

class Solution_d9_2117_홈방범서비스_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, k, n, m, cnt, maxVal, cost[], G[][];

    public static int getCost(int k) {
        return (k * k + (k - 1) * (k - 1));
    }

    public static boolean inRange(int x1, int y1, int x2, int y2, int k) {
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2) < k);
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        cost = new int[22];

        for (int i = 0; i < 22; i++) {
            cost[i] = getCost(i);
        }
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            maxVal = 0;

            ArrayDeque<int[]> homes = new ArrayDeque<>();
            G = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    G[i][j] = Integer.parseInt(st.nextToken());
                    if (G[i][j] == 1) {
                        homes.offer(new int[] {i, j});
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 1; k <= n + 1; k++) {
                        cnt = 0;
                        for (int[] home: homes) {
                            if (inRange(home[0], home[1], i, j, k))
                                cnt++;
                        }
                        if (m * cnt - cost[k] >= 0) 
                            maxVal = Math.max(maxVal, cnt);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(maxVal).append("\n");
        }
        System.out.print(sb);
    }
}