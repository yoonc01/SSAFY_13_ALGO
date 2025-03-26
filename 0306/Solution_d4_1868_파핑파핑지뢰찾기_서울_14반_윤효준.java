import java.io.*;
import java.util.*;

class Solution_d4_1868_파핑파핑지뢰찾기_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, T, ans, map[][];
    static int dxs[] = { 0, 1, 1, 1, 0, -1, -1, -1 }, dys[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static char charMap[][];
    static boolean visited[][];

    static boolean inRange(int a, int b) {
        return (0 <= a && a < n && 0 <= b && b < n);
    }

    static boolean canGo(int a, int b) {
        return (inRange(a, b) && !visited[a][b] && map[a][b] != -1);
    }

    static void bfs(int a, int b) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[] { a, b });
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] temp = q.pollFirst();
            int x = temp[0];
            int y = temp[1];

            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dxs[dir];
                int ny = y + dys[dir];

                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        q.addLast(new int[] { nx, ny });
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            n = Integer.parseInt(br.readLine());

            charMap = new char[n][n];
            map = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    charMap[i][j] = str.charAt(j);
                }
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (charMap[x][y] == '*') {
                        map[x][y] = -1;
                        continue;
                    }
                    for (int dir = 0; dir < 8; dir++) {
                        int nx = x + dxs[dir];
                        int ny = y + dys[dir];
                        if (inRange(nx, ny) && charMap[nx][ny] == '*') {
                            map[x][y]++;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] == 0) {
                        ans++;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] != -1) {
                        ans++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
