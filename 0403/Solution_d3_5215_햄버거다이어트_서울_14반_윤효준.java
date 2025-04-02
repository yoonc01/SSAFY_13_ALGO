import java.io.*;
import java.util.*;

public class Solution_d3_5215_햄버거다이어트_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, l, ans, scores[], calories[], dp[][];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            ans = 0;

            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            scores = new int[n + 1];
            calories = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[n + 1][l + 1];
            for (int i = 1; i < n + 1; i++) {
                int calorie = calories[i];
                for (int j = 0; j < l + 1; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= calorie)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - calorie] + scores[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}