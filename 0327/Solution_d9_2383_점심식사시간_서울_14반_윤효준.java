import java.io.*;
import java.util.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n, idx, ans, totalPeople, arr[][], stairs[][], chosen[], distToStairs[][], peopleInStairs[],
            waiting[] = new int[2];
    static boolean started[];
    static ArrayDeque<Integer>[] stairState = new ArrayDeque[2];
    static {
        stairState[0] = new ArrayDeque<>();
        stairState[1] = new ArrayDeque<>();
    }

    static int[] getDist(int idx, int person[]) {
        int returnValue[] = new int[2];
        for (int i = 0; i < 2; i++)
            returnValue[i] = Math.abs(person[0] - stairs[i][0]) + Math.abs(person[1] - stairs[i][1]);
        return returnValue;
    }

    static void makeStairState(int idx, int cnt) {
        for (int i = 0; i < cnt; i++) {
            stairState[idx].addLast(0);
            cnt--;
        }
    }

    static void comb(int cnt) {
        if (cnt == n) {
            makeStairState(0, stairs[0][2]);
            makeStairState(1, stairs[1][2]);
            int time = 0;
            int movedPeople = 0;
            while (movedPeople < totalPeople) {
                time++;
                for (int i = 0; i < 2; i++) {
                    int outPeople = stairState[i].pollFirst();
                    peopleInStairs[i] = peopleInStairs[i] - outPeople;
                    movedPeople = movedPeople + outPeople;
                }
                for (int i = 0; i < n; i++) {
                    int stairNum = chosen[i];
                    if (!started[i] && distToStairs[i][stairNum] < time) {
                        waiting[stairNum]++;
                        started[i] = true;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    int canGo = 3 - peopleInStairs[i];
                    int go = Math.min(waiting[i], canGo);
                    waiting[i] = waiting[i] - go;
                    stairState[i].addLast(go);
                }
            }
            ans = Math.min(ans, time);
            return;
        }
        for (int i = 0; i < 2; i++) {
            chosen[cnt] = i;
            comb(cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = 2147483647;
            n = Integer.parseInt(br.readLine());
            chosen = new int[n];
            ArrayDeque<int[]> q = new ArrayDeque<>();

            stairs = new int[2][3];
            peopleInStairs = new int[2];
            started = new boolean[n];
            idx = 0;

            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1)
                        q.addLast(new int[] { i, j });
                    else if (arr[i][j] > 1) {
                        stairs[idx++] = new int[] { i, j, arr[i][j] };
                    }
                }
            }

            idx = 0;
            totalPeople = q.size();
            distToStairs = new int[totalPeople][2];
            while (!q.isEmpty()) {
                int person[] = q.pollFirst();
                distToStairs[idx] = getDist(idx, person);
                idx++;
            }
            comb(0);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
    }
}