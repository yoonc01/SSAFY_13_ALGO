import java.io.*;
import java.util.*;

// next permutation을 이용한 조합 문제 풀이
public class Solution_d3_5215_햄버거다이어트_서울_14반_윤효준 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder resultBuilder = new StringBuilder();
    static int n, limit, ans, totalCalorie, totalScore, choose[], data[][];

    static void initChooseArray(int r)
    {
        choose = new int[n];
        int idx = n - 1;
        while(r > 0)
        {
            choose[idx] = 1;
            r--;
            idx--;
        }
    }

    static boolean nextPermutation()
    {
        int i = n - 1, j = n - 1, k = n - 1;
        while(i != 0 && choose[i - 1] >= choose[i])
            i--;
        if (i == 0)
            return false;
        while(choose[i - 1] >= choose[j])
            j--;
        swap(i - 1, j);
        while(i < k)
        {
            swap(i, k);
            i++;
            k--;
        }
        return true;
    }

    static void swap(int i, int j)
    {
        int temp = choose[i];
        choose[i] = choose[j];
        choose[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            data = new int[n][2];
            ans = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                data[i][0] = Integer.parseInt(st.nextToken());
                data[i][1] = Integer.parseInt(st.nextToken());
            }
            for (int r = 0; r <= n; r++)
            {
                initChooseArray(r);
                while(true)
                {
                    totalScore = 0;
                    totalCalorie = 0;
                    for (int i = 0; i < n; i++)
                    {
                        if (choose[i] == 1)
                        {
                            totalScore = totalScore + data[i][0];
                            totalCalorie = totalCalorie + data[i][1];
                        }
                    }
                    if (totalCalorie <= limit)
                        ans = Math.max(ans, totalScore);
                    if (!nextPermutation())
                        break;
                }
            }
            resultBuilder.append("#").append(testCase).append(" ").append(ans).append("\n");
        }

        System.out.print(resultBuilder);
    }
}