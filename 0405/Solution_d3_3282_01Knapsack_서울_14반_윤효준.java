import java.io.*;
import java.util.*;

public class Solution_d3_3282_01Knapsack_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, k, ans, volumes[], costs[], dp[];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            ans = 0;

            volumes = new int[n + 1];
            costs = new int[n + 1];
            dp = new int[k + 1];

            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                volumes[i] = Integer.parseInt(st.nextToken());
                costs[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = k; j >= volumes[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - volumes[i]] + costs[i]);
                }
            }
            for (int j = 0; j < k + 1; j++) {
                ans = Math.max(ans, dp[j]);
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}