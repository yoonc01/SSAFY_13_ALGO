import java.io.*;
import java.util.*;

// 부분 집합 코드로 풀이
public class Solution_d3_5215_햄버거다이어트_서울_14반_윤효준 {
    static int n, limit, ans;
    static int[][] data;

    static void subs(int idx, int totalScore, int totalCalorie) {
        if (totalCalorie > limit) return;

        ans = Math.max(ans, totalScore);

        if (idx == n) return;

        subs(idx + 1, totalScore + data[idx][0], totalCalorie + data[idx][1]);
        subs(idx + 1, totalScore, totalCalorie);
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

            subs(0, 0, 0);

            resultBuilder.append("#").append(testCase).append(" ").append(ans).append("\n");
        }

        System.out.print(resultBuilder);
    }
}