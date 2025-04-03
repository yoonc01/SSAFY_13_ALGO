import java.io.*;
import java.util.*;

public class Solution_d4_7733_치즈도둑_서울_14반_윤효준2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int maxPieces, n, T, map[][];
    static boolean visited[][];
    static int[] dxs = { 1, 0, -1, 0 };
    static int[] dys = { 0, 1, 0, -1 };

    static boolean inRange(int a, int b) {
        return (0 <= a && a < n && 0 <= b && b < n);
    }

    static boolean canGo(int x, int y, int days) {
        return (inRange(x, y) && !visited[x][y] && map[x][y] > days);
    }

    static void bfs(int a, int b, int days) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[a][b] = true;
        q.addLast(new int[] { a, b });
        while (!q.isEmpty()) {
            int temp[] = q.pollFirst();
            int x = temp[0];
            int y = temp[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dxs[dir];
                int ny = y + dys[dir];

                if (canGo(nx, ny, days)) {
                    visited[nx][ny] = true;
                    q.addLast(new int[] { nx, ny });
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            maxPieces = 1;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int days = 1; days <= 100; days++) {
                int cnt = 0;
                visited = new boolean[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (canGo(i, j, days)) {
                            cnt++;
                            bfs(i, j, days);
                        }
                    }
                }
                maxPieces = Math.max(maxPieces, cnt);
            }
            sb.append("#").append(tc).append(" ").append(maxPieces).append("\n");
        }
        System.out.print(sb);
    }
}
