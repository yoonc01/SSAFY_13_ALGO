import java.io.*;
import java.util.*;

// 조합으로 풀이
public class Solution_d3_5215_햄버거다이어트_서울_14반_윤효준 {
    static int n, r, limit, ans;
    static int[][] data;

    static void comb(int cnt, int start, int totalScore, int totalCalorie) {
        if (cnt == r) {
            ans = Math.max(ans, totalScore);
            return;
        }
        for (int i = start; i < n; i++) {
            if (totalCalorie + data[i][1] <= limit)
                comb(cnt + 1, i + 1, totalScore + data[i][0], totalCalorie + data[i][1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultBuilder = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            data = new int[n][2];
            ans = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                data[i][0] = Integer.parseInt(st.nextToken());
                data[i][1] = Integer.parseInt(st.nextToken());
            }
            // nC0, nC1 ... nCn
            for (r = 0; r <= n; r++)
                comb(0, 0, 0, 0);

            resultBuilder.append("#").append(testCase).append(" ").append(ans).append("\n");
        }

        System.out.print(resultBuilder);
    }
}