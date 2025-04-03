import java.io.*;

public class Main_bj_11726_2xn타일링_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, dp[];

    static public void main(String args[]) throws IOException {
        n = Integer.parseInt(br.readLine());

        dp = new int[Math.max(n + 1, 3)];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}