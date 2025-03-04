import java.io.*;

class Solution_d5_6782_현주가좋아하는제곱근놀이_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;
    static long cnt, num, nextNum, arr[];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            cnt = 0;
            num = Long.parseLong(br.readLine());
            while (num != 2) {
                nextNum = (int) Math.sqrt(num);
                if (nextNum != Math.sqrt(num))
                    nextNum++;

                cnt = cnt + nextNum * nextNum - num + 1;
                num = nextNum;
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
