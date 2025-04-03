   import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_d9_1767_프로세서연결하기_서울_14반_윤효준 {
    private static int n, core, answer;
    private static int[][] map;
    private static ArrayList<int[]> list;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
                        list.add(new int[]{i, j});
                    }
                }
            }

            core = 0;
            answer = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void dfs(int depth, int c, int length) {
        if (depth == list.size()) {
            if (core < c) {
                core = c;
                answer = length;
            } else if (core == c) {
                answer = Math.min(answer, length);
            }
            return;
        }

        int[] cur = list.get(depth);

        for (int dir = 0; dir < 4; dir++) {
            int len = canConnect(cur, dir);
            if (len > 0) {
                fill(cur, dir, 2);
                dfs(depth + 1, c + 1, length + len);
                fill(cur, dir, 0);
            }
        }

        // 연결하지 않고 넘기기
        dfs(depth + 1, c, length);
    }

    private static int canConnect(int[] idx, int dir) {
        int x = idx[0] + dx[dir];
        int y = idx[1] + dy[dir];
        int len = 0;

        while (x >= 0 && y >= 0 && x < n && y < n) {
            if (map[x][y] != 0) return 0;
            x += dx[dir];
            y += dy[dir];
            len++;
        }
        return len;
    }

    private static void fill(int[] idx, int dir, int value) {
        int x = idx[0] + dx[dir];
        int y = idx[1] + dy[dir];

        while (x >= 0 && y >= 0 && x < n && y < n) {
            map[x][y] = value;
            x += dx[dir];
            y += dy[dir];
        }
    }
}
