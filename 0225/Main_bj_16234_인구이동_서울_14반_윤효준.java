import java.io.*;
import java.util.*;

public class Main_bj_16234_인구이동_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, l, r, arr[][], dxs[] = { 0, 1, 0, -1 }, dys[] = { 1, 0, -1, 0 };
    static boolean boundaryOpened, visited[][];
    static ArrayDeque<int[]> union = new ArrayDeque<>();

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    static boolean canGo(int x, int y, int nx, int ny) {
        if (inRange(nx, ny)) {
            int diff = Math.abs(arr[nx][ny] - arr[x][y]);
            return (!visited[nx][ny] && l <= diff && diff <= r);
        }
        return false;
    }

    static int getTotalPopulation(int a, int b) {
        int totalPopulation = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[] { a, b });
        union.addLast(new int[] { a, b });
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            int x = current[0];
            int y = current[1];
            totalPopulation = totalPopulation + arr[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dxs[i];
                int ny = y + dys[i];

                if (canGo(x, y, nx, ny)) {
                    boundaryOpened = true;
                    visited[nx][ny] = true;
                    q.addLast(new int[] { nx, ny });
                    union.addLast(new int[] { nx, ny });
                }
            }
        }
        return totalPopulation;
    }

    static void closeBoundary(int totalPopulation) {
        int totalUnion = union.size();
        int populationAfterClose = totalPopulation / totalUnion;

        while (!union.isEmpty()) {
            int country[] = union.pollFirst();
            int x = country[0];
            int y = country[1];

            arr[x][y] = populationAfterClose;
        }

    }

    static int process() {
        int cnt = 0;
        while (true) {
            visited = new boolean[n][n];
            boundaryOpened = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int totalPopulation = getTotalPopulation(i, j);
                        closeBoundary(totalPopulation);
                    }
                }
            }
            if (!boundaryOpened)
                return cnt;
            cnt++;
        }
    }

    static public void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(process());
    }
}