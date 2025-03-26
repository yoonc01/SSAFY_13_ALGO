import java.io.*;
import java.util.*;

class Solution_d3_1873_상호의배틀필드_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int x, y, T, h, w, n, direction;
    static char[] tank = { '>', 'v', '<', '^' };
    static char[][] map;
    static int[] dxs = { 0, 1, 0, -1 }, dys = { 1, 0, -1, 0 };
    static Map<Character, Integer> directionMap = new HashMap<>();

    static {
        directionMap.put('>', 0);
        directionMap.put('v', 1);
        directionMap.put('<', 2);
        directionMap.put('^', 3);
    }

    static boolean inRange(int a, int b) {
        return (0 <= a && a < h && 0 <= b && b < w);
    }

    static boolean canGo(int a, int b) {
        return (inRange(a, b) && map[a][b] == '.');
    }

    static void move(int direction) {
        int nx = x + dxs[direction];
        int ny = y + dys[direction];

        if (canGo(nx, ny)) {
            map[x][y] = '.';
            x = nx;
            y = ny;
        }
        map[x][y] = tank[direction];
    }

    static void shoot(int direction) {
        int nx = x + dxs[direction];
        int ny = y + dys[direction];
        while (inRange(nx, ny)) {
            if (map[nx][ny] == '*') {
                map[nx][ny] = '.';
                return;
            } else if (map[nx][ny] == '#')
                return;
            nx = nx + dxs[direction];
            ny = ny + dys[direction];
        }
    }

    static void playGame(char cmd) {
        if (cmd == 'S') {
            shoot(direction);
            return;
        } else if (cmd == 'U')
            direction = 3;
        else if (cmd == 'D')
            direction = 1;
        else if (cmd == 'L')
            direction = 2;
        else if (cmd == 'R')
            direction = 0;
        move(direction);
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            direction = -1;

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if (directionMap.containsKey(map[i][j])) {
                        direction = directionMap.get(map[i][j]);
                        x = i;
                        y = j;
                    }
                }
            }

            n = Integer.parseInt(br.readLine());
            String cmds = br.readLine();
            for (int i = 0; i < n; i++)
                playGame(cmds.charAt(i));

            sb.append("#").append(tc).append(" ");
            for (char[] row : map)
                sb.append(row).append("\n");
        }
        System.out.print(sb);
    }
}
