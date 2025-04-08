import java.io.*;
import java.util.*;

public class Solution_d4_3263_오름차순줄세우기_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, ans, seq[], dp[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            seq = new int[n];
            dp = new int[n + 1];
            visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            ans = 0;

            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
                int num = seq[i];
                if (visited[num - 1]) {
                    dp[num] = dp[num - 1] + 1;
                } else {
                    dp[num] = 1;
                }
                visited[num] = true;
                ans = Math.max(ans, dp[num]);
            }
            sb.append("#").append(tc).append(" ").append(n - ans).append("\n");
        }
        System.out.print(sb);
    }
}
