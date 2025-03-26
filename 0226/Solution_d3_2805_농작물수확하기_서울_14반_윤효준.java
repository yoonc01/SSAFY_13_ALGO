import java.io.*;

public class Solution_d3_2805_농작물수확하기_서울_14반_윤효준 {
    static int ans, t, n, farm[][];
    static String str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static boolean inDistance(int x, int y) {
        return (Math.abs(x - n / 2) + Math.abs(y - n / 2) <= n / 2);
    }

    static void getAnswer() {
        ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (inDistance(i, j))
                    ans = ans + farm[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            farm = new int[n][n];

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                for (int j = 0; j < n; j++)
                    farm[i][j] = str.charAt(j) - '0';
            }
            getAnswer();
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}