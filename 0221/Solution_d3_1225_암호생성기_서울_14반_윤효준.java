import java.io.*;
import java.util.*;

public class Solution_d3_1225_암호생성기_서울_14반_윤효준 {
    static public void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int tc = 0; tc < 10; tc++) {
            sb.append("#").append(tc + 1).append(" ");
            int cnt = 1;
            br.readLine();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++)
                q.offerLast(Integer.parseInt(st.nextToken()));
            while (true) {
                int temp = q.pollFirst();
                temp = Math.max(temp - cnt, 0);
                q.offerLast(temp);
                if (temp == 0)
                    break;
                cnt = cnt % 5 + 1;
            }
            for (int i = 0; i < 8; i++)
                sb.append(q.pollFirst()).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

// 그냥 배열 순회하는 방식

// public class Solution
// {
// static public void main(String args[]) throws IOException
// {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringBuilder sb = new StringBuilder();
// StringTokenizer st;
// int [] q = new int[8];

// for (int tc = 0; tc < 10; tc++)
// {
// int idx = 0;
// sb.append("#").append(tc + 1).append(" ");
// int cnt = 1;
// br.readLine();
// st = new StringTokenizer(br.readLine());
// for (int i = 0; i < 8; i++)
// q[i] = (Integer.parseInt(st.nextToken()));
// while (true)
// {
// q[idx] = Math.max(q[idx] - cnt, 0);
// if (q[idx] == 0)
// break;
// idx = (idx + 1) % 8;
// cnt = cnt % 5 + 1;
// }
// while(true)
// {
// idx = (idx + 1) % 8;
// sb.append(q[idx]).append(" ");
// if (q[idx] == 0)
// break;
// }
// sb.append("\n");
// }
// System.out.println(sb);
// }
// }