import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution_d5_5521_상원이의생일파티_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, m, a, b, ans;
    static boolean visited[], G[][];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ans = 0;

            G = new boolean[n + 1][n + 1];
            visited = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                G[a][b] = true;
                G[b][a] = true;
            }

            ArrayDeque<int[]> q = new ArrayDeque<>();

            q.offer(new int[] {1, 0});
            visited[1] = true;
            while (!q.isEmpty()) {
                int temp[] = q.poll();
                int curr = temp[0];
                int cnt = temp[1];

                for (int i = 1; i < n + 1; i++) {
                    if (G[curr][i] && !visited[i] && cnt < 2) {
                        q.offer(new int[] {i, cnt + 1});
                        visited[i] = true;
                        ans++;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
