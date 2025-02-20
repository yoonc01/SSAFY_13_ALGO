import java.util.*;
import java.io.*;

public class Solution_d2_1954_달팽이숫자_서울_14반_윤효준 {
    static int n, dir, x, y, cnt;
    static int[][] arr;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    public static boolean canGo(int x, int y) {
        return (inRange(x, y) && arr[x][y] == 0);
    }

    // 달팽이 배열을 생성하는 함수
    public static void generateSnailMatrix() {
        arr = new int[n][n]; 
        
        x = 0; 
        y = 0; 
        dir = 0;
        cnt = 1;
        arr[x][y] = cnt++;

        while (cnt <= n * n) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            while (!canGo(nx, ny)) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            arr[nx][ny] = cnt++;
            x = nx;
            y = ny;
        }
    }

    public static void appendMatrix(StringBuilder sb) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            
            generateSnailMatrix();
            sb.append("#").append(test_case).append("\n");
            appendMatrix(sb);
        }
        System.out.print(sb);
    }
}
