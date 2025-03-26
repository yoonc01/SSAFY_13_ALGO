import java.io.*;
import java.util.*;

public class Solution_d4_1238_Contact_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, length, start, a, b, maxVal, ans, depths[];
    static boolean initAnswer, visited[], connected[][];

    public static void main(String[] args) throws IOException {

        for (int tc = 1; tc <= 10; tc++) {
            ArrayDeque<int[]> q = new ArrayDeque<>();
            connected = new boolean[101][101];
            visited = new boolean[101];
            depths = new int[101];
            initAnswer = true;
            maxVal = 0;
            ans = 0;

            st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length / 2; i++) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                connected[a][b] = true;
            }
            q.addLast(new int[] { start, 0 });
            visited[start] = true;
            while (!q.isEmpty()) {
                int temp[] = q.pollFirst();
                int node = temp[0];
                int cnt = temp[1];
                depths[cnt] = Math.max(depths[cnt], node);

                for (int i = 0; i < 101; i++) {
                    if (connected[node][i] && !visited[i]) {
                        q.addLast(new int[] { i, cnt + 1 });
                        visited[i] = true;
                    }
                }
            }
            for (int i = 0; i < 101; i++) {
                if (depths[i] == 0)
                    break;
                ans = depths[i];
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
