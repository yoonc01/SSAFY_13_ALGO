import java.io.*;
import java.util.*;

public class Solution_d9_2105_디저트카페_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, T, ans, map[][];
    static Set<Integer> visited = new HashSet<>();
    static int dxs[] = { 1, 1, -1, -1 }, dys[] = { 1, -1, -1, 1 };

    static boolean inRange(int a, int b) {
        return (0 <= a && a < n && 0 <= b && b < n);
    }

    static boolean canGo(int x, int y) {
        return (inRange(x, y) && !visited.contains(map[x][y]));
    }

    static void getScore(int x, int y, int w, int h) {
        visited.clear();
        int moveNum[] = { w, h, w, h };
        int cnt = 0;

        for (int dir = 0; dir < 4; dir++) {
            for (int len = 0; len < moveNum[dir]; len++) {
                x = x + dxs[dir];
                y = y + dys[dir];

                if (!canGo(x, y))
                    return;
                cnt++;
                visited.add(map[x][y]);
            }
        }
        ans = Math.max(ans, cnt);
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = -1;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int w = 1; w < n; w++)
                        for (int h = 1; h < n; h++)
                            getScore(i, j, w, h);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
