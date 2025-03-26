import java.io.*;
import java.util.*;

public class Solution_d4_1486_장훈이의높은선반_서울_14반_윤효준 {
    static int t, n, b, ans, heights[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void comb(int cnt, int totalHeight) {
        if (cnt == n) {
            if (totalHeight >= b)
                ans = Math.min(ans, totalHeight);
            return;
        }
        comb(cnt + 1, totalHeight);
        comb(cnt + 1, totalHeight + heights[cnt]);
    }

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans = 2147483647;

            heights = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                heights[i] = Integer.parseInt(st.nextToken());
            comb(0, 0);
            sb.append("#").append(tc).append(" ").append(ans - b).append("\n");
        }
        System.out.println(sb);
    }

}