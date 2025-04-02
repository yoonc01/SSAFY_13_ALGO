import java.io.*;
import java.util.*;

public class Solution_d9_2115_벌꿀채취_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, m, c, player1, player2, ans, arr1[], arr2[], G[][];
    static boolean selected[][];
    
    public static int getMoney(int arr[], int idx, int total, int totalValue) {
        if (total > c)
            return 0;
        if (idx == arr.length)
            return totalValue;

        int without = getMoney(arr, idx + 1, total, totalValue);
        int with = getMoney(arr, idx + 1, total + arr[idx], totalValue + arr[idx] * arr[idx]);
        return Math.max(with, without);
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            player1 = 0;
            player2 = 0;
            ans = 0;

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            G = new int[n][n];
            arr1 = new int[m];
            arr2 = new int[m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    G[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - m + 1; j++) {
                    for (int idx = 0; idx < m; idx++) {
                        arr1[idx] = G[i][j + idx];
                    }
                    player1 = getMoney(arr1, 0, 0, 0);
                    for (int y = j + m; y < n - m + 1; y++) {
                        for (int idx = 0; idx < m; idx++) {
                            arr2[idx] = G[i][y + idx];
                        }
                        player2 = getMoney(arr2, 0, 0, 0);
                        ans = Math.max(ans, player1 + player2);
                    }

                    for (int x = i + 1; x < n; x++) {
                        for (int y = 0; y < n - m + 1; y++) {
                            for (int idx = 0; idx < m; idx++) {
                                arr2[idx] = G[x][y + idx];
                            }
                            player2 = getMoney(arr2, 0, 0, 0);
                            ans = Math.max(ans, player1 + player2);
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}