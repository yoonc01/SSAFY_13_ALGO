import java.io.*;
import java.util.*;

class Solution_d9_1249_보급로_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, T, dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}, minTime[][], G[][];

    static boolean inRange(int a, int b) {
        return (0 <= a && a < n && 0 <= b && b < n);
    }
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            G = new int[n][n];
            minTime = new int[n][n];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    G[i][j] = str.charAt(j) - '0';
                    minTime[i][j] = Integer.MAX_VALUE;
                }
            }
            minTime[0][0] = 0;
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0, minTime[0][0]});
            while(!q.isEmpty()) {
                int temp[] = q.poll();
                int x = temp[0], y = temp[1], min = temp[2];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (inRange(nx, ny) && minTime[nx][ny] > min + G[nx][ny]) {
                        minTime[nx][ny] = min + G[nx][ny];
                        q.offer(new int[] {nx, ny, minTime[nx][ny]});
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(minTime[n - 1][n - 1]).append("\n");
        }
        System.out.print(sb);
    }
}