import java.util.*;
import java.io.*;

public class Solution_d1_2072_홀수만더하기_서울_14반_윤효준 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d1_2072.txt"));
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = null;

		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			int number;
			// 한 줄 가져오는 친구
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 10; i++) {
				number = Integer.parseInt(st.nextToken());
				if (number % 2 == 1)
					ans = ans + number;
			}
			// 더하기 연산으로 하면 string은 class이므로 많이 무거움
			sb.append("#").append(test_case).append(" ").append(ans).append('\n');
		}
		System.out.print(sb.toString());
		br.close();
	}
}
