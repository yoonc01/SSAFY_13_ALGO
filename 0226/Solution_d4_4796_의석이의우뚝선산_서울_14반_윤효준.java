import java.util.*;

// 해당 문제는 BufferedReader 사용 시 runtime error가 나오므로 scanner로 받음
public class Solution_d4_4796_의석이의우뚝선산_서울_14반_윤효준 {
    static int ans, start, t, n, heights[];
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static void findBound() {
        int peakIndex, lastIndex;
        peakIndex = start;

        while (peakIndex + 1 < n && heights[peakIndex] < heights[peakIndex + 1])
            peakIndex++;
        
        lastIndex = peakIndex;
        while (lastIndex + 1 < n && heights[lastIndex] > heights[lastIndex + 1])
            lastIndex++;
        
        ans = ans + (peakIndex - start) * (lastIndex - peakIndex);
        start = lastIndex;
    }

    public static void main(String[] args) {
        t = sc.nextInt();
        
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            heights = new int[n];
            
            for (int i = 0; i < n; i++)
                heights[i] = sc.nextInt();
            
            ans = 0;
            start = 0;
            
            while (start != n - 1)
                findBound();
            
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        
        System.out.println(sb);
        sc.close();
    }
}
