import java.io.*;
import java.util.*;

public class Solution_d4_1210_Ladder1_서울_14반_윤효준 {
    static int t, x, y, ans, map[][];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static public boolean inRange(int a, int b) {
        return (0 <= a && a < 100 && 0 <= b && b < 100);
    }

    static public boolean canGoLeft() {
        int nx = x;
        int ny = y - 1;
        return (inRange(nx, ny) && map[nx][ny] == 1);
    }

    static public boolean canGoRight() {
        int nx = x;
        int ny = y + 1;
        return (inRange(nx, ny) && map[nx][ny] == 1);
    }

    static public void findStart() {
        while (x != 0) {
            if (canGoLeft()) {
                while (canGoLeft())
                    y--;
            } else {
                while (canGoRight())
                    y++;
            }
            x--;
        }
        ans = y;
    }

    public static void main(String[] args) throws IOException {
        map = new int[100][100];
        for (t = 1; t <= 10; t++) {
            br.readLine();
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }
            findStart();
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}