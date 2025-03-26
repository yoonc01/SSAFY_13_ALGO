import java.io.*;
import java.util.*;

public class Solution_d3_6808_규영이와인영이의카드게임_서울_14반_윤효준 {
    static int t, playerWin, comWin, com[], player[], cardList[];
    static boolean visited[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void perm(int cnt, int comScore, int playerScore) {
        if (cnt == 9) {
            if (comScore > playerScore)
                comWin++;
            else if (playerScore > comScore)
                playerWin++;
            return;
        }
        for (int i = 0; i < 18; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            player[cnt] = cardList[i];
            if (player[cnt] > com[cnt])
                perm(cnt + 1, comScore, playerScore + player[cnt] + com[cnt]);
            else
                perm(cnt + 1, comScore + player[cnt] + com[cnt], playerScore);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        cardList = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
        com = new int[9];
        player = new int[9];

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            visited = new boolean[18];
            st = new StringTokenizer(br.readLine());
            playerWin = 0;
            comWin = 0;
            for (int i = 0; i < 9; i++) {
                int chosenCard = Integer.parseInt(st.nextToken());
                com[i] = chosenCard;
                visited[chosenCard - 1] = true;
            }
            perm(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(comWin).append(" ").append(playerWin).append("\n");
        }
        System.out.println(sb);
    }
}
