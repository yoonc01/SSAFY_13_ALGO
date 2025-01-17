package a0116.camp;

import java.util.*;
import java.io.*;

public class Solution_d3_1289_원재의메모리복구하기_서울_14반_윤효준 {

	public static void main(String[] args) throws Exception
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = null;
		
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++)
        {
            String str =br.readLine();
            int ans =str.charAt(0) - '0';
            for (int j = 1; j < str.length(); j++)
            {
    			if (str.charAt(j - 1) != str.charAt(j))
                    ans++;
            }
			sb.append("#").append(i + 1).append(" ").append(ans).append('\n');
        }
        System.out.print(sb.toString());
        br.close();
	}
}
