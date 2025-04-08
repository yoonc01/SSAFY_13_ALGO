import java.io.*;
import java.util.*;

public class Solution_d3_3307_최장증가부분수열_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, ans, seq[], dp[];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            seq = new int[n];
            dp = new int[n];
            ans = 0;
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
                for (int j = 0; j <= i; j++) {
                    if (seq[i] > seq[j] && dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;
                }
                ans = Math.max(ans, dp[i]);
            }
            sb.append("#").append(tc).append(" ").append(ans + 1).append("\n");
        }
        System.out.print(sb);
    }
}