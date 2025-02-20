import java.io.*;
import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int arr[][] = new int[n][n];
            int ans = 0;
             
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int i = 0; i < n - m + 1; i++) {
                for (int j = 0; j < n - m + 1; j++) {
                    ans = Math.max(ans, calc(arr, i, j, m));
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
 
    private static int calc(int arr[][], int x, int y, int m) {
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                total = total + arr[x + i][y + j];
            }
        }
        return total;
    }
}