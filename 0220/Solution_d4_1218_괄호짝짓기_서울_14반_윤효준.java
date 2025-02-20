import java.io.*;
import java.util.*;

class Solution_d4_1218_괄호짝짓기_서울_14반_윤효준 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= 10; test_case++) {
            br.readLine();
            sb.append("#").append(test_case).append(" ");
            String input = br.readLine();
            sb.append(isValidBracketSequence(input) ? 1 : 0).append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static boolean isValidBracketSequence(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch : input.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(' || ch == '<') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')' || ch == '>') {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (!isMatchingPair(open, ch)) return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    private static boolean isMatchingPair(char open, char close) {
        int asciiOpen = (int) open;
        int asciiClose = (int) close;
        return (asciiOpen + 2 == asciiClose || asciiOpen + 1 == asciiClose);
    }
}
