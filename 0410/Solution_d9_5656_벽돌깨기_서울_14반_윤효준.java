import java.io.*;
import java.util.*;

public class Solution_d9_5656_벽돌깨기_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, ans, w, h, total, dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}, chosen[], G[][];

    public static boolean inRange(int a, int b) {
        return (0 <= a && a < h && 0 <= b && b < w);
    }

    public static int simulate(int row, int col, int newG[][]) {
        boolean visited[][] = new boolean[h][w];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int removed = 0;

        q.offer(new int[] {row, col, newG[row][col]});
        visited[row][col] = true;
        newG[row][col] = 0;
        removed++;

        while(!q.isEmpty()) {
            int temp[] = q.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2];

            for (int dir = 0; dir < 4; dir++) {
                for (int i = 1; i < cnt; i++) {
                    int nx = x + dx[dir] * i;
                    int ny = y + dy[dir] * i;
                    if (inRange(nx, ny) && !visited[nx][ny] && newG[nx][ny] != 0) {
                        q.offer(new int[] {nx, ny, newG[nx][ny]});
                        visited[nx][ny] = true;
                        newG[nx][ny] = 0;
                        removed++;
                    }
                }
            }
        }

        int temp[][] = new int[h][w];
        for (int j = 0; j < w; j++) {
            int idx = h - 1;
            for (int i = h - 1; i >= 0; i--) {
                if (newG[i][j] != 0) {
                    temp[idx--][j] = newG[i][j];
                }
            }
        }
        copyG(temp, newG);
        return removed;
    }

    public static void copyG(int from[][], int to[][]) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    public static void perm(int cnt) {
        if (cnt == n) {
            int newG[][] = new int[h][w];
            int totalRemoved = 0;
            copyG(G, newG);
            for (int i = 0; i < n; i++) {
                int col = chosen[i];
                for (int j = 0; j < h; j++) {
                    if (newG[j][col] != 0) {
                        totalRemoved = totalRemoved + simulate(j, col, newG);
                        break;
                    }
                }
            }

            ans = Math.min(ans, total - totalRemoved);
            return;
        }
        for (int i = 0; i < w; i++) {
            chosen[cnt] = i;
            perm(cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            ans = w * h;
            total = 0;

            G = new int[h][w];
            chosen = new int[n];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    G[i][j] = Integer.parseInt(st.nextToken());
                    if (G[i][j] != 0)
                        total++;
                }
            }
            perm(0);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
