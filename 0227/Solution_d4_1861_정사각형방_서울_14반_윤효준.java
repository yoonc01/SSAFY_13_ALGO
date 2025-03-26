import java.io.*;
import java.util.*;

public class Solution_d4_1861_정사각형방_서울_14반_윤효준 {
    static int T, n, ans, moveCnt, G[][];
    static boolean visited[][];
    static int dxs[] = { 0, 1, 0, -1 }, dys[] = { 1, 0, -1, 0 };
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static boolean inRange(int a, int b) {
        return (0 <= a && a < n && 0 <= b && b < n);
    }

    static int move(int a, int b) {
        int cnt, x, y;
        boolean canGo = true;

        cnt = 1;
        x = a;
        y = b;
        while (canGo) {
            canGo = false;
            visited[x][y] = true;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dxs[dir];
                int ny = y + dys[dir];

                if (inRange(nx, ny) && (G[nx][ny] - G[x][y] == 1)) {
                    x = nx;
                    y = ny;
                    cnt++;
                    canGo = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            moveCnt = 0;
            n = Integer.parseInt(br.readLine());
            ans = n * n;
            G = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j])
                        continue;
                    int result = move(i, j);
                    if (result > moveCnt || (result == moveCnt && G[i][j] < ans)) {
                        ans = G[i][j];
                        moveCnt = result;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append(" ").append(moveCnt).append("\n");
        }
        System.out.println(sb);
    }
}