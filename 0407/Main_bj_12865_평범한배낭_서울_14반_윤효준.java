import java.io.*;
import java.util.*;

public class Main_bj_12865_평범한배낭_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, k, ans, weight, value, dp[];


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = 0;

        dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            for (int j = k; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }
        for (int i = 0; i < k + 1; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
