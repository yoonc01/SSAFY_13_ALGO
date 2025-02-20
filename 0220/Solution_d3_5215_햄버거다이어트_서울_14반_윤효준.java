import java.io.*;
import java.util.*;

public class Solution_d3_5215_햄버거다이어트_서울_14반_윤효준 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultBuilder = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n + 1][limit + 1];
            int[][] data = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(reader.readLine());
                int score = Integer.parseInt(st.nextToken());
                int calorie = Integer.parseInt(st.nextToken());
                data[i][0] = score;
                data[i][1] = calorie;
            }

            for (int j = 0; j <= limit; j++) {
                dp[0][j] = 0;
            }

            int ans = 0;

            for (int i = 1; i <= n; i++) {
                int score = data[i - 1][0];
                int calorie = data[i - 1][1];
                for (int j = 0; j <= limit; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= calorie) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - calorie] + score);
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }

            resultBuilder.append("#").append(testCase).append(" ").append(ans).append("\n");
        }

        System.out.print(resultBuilder);
    }
}
