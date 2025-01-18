import java.io.*;
import java.util.*;

public class Solution_d4_7733_치즈도둑_서울_14반_윤효준 {
    static int testCaseCount, boardSize;
    static int[][] cheeseBoard = new int[101][101];
    static boolean[][] isVisited = new boolean[101][101];
    static int[] deltaX = {1, 0, -1, 0};
    static int[] deltaY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_d4_7733.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultBuilder = new StringBuilder();

        testCaseCount = Integer.parseInt(reader.readLine());

        for (int currentTestCase = 1; currentTestCase <= testCaseCount; currentTestCase++) {
            boardSize = Integer.parseInt(reader.readLine());
            for (int row = 0; row < boardSize; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int column = 0; column < boardSize; column++) {
                    cheeseBoard[row][column] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int maxPieces = 0;

            for (int day = 0; day <= 100; day++) {
                Queue<int[]> bfsQueue = new LinkedList<>();
                int connectedPieces = 0;

                for (int row = 0; row < boardSize; row++) {
                    for (int column = 0; column < boardSize; column++) {
                        if (cheeseBoard[row][column] > day && !isVisited[row][column]) {
                            bfsQueue.offer(new int[]{row, column});
                            isVisited[row][column] = true;
                            connectedPieces++;

                            while (!bfsQueue.isEmpty()) {
                                int[] currentPosition = bfsQueue.poll();
                                for (int direction = 0; direction < 4; direction++) {
                                    int newRow = currentPosition[0] + deltaX[direction];
                                    int newColumn = currentPosition[1] + deltaY[direction];

                                    if (newRow < 0 || newRow >= boardSize || newColumn < 0 || newColumn >= boardSize) continue;
                                    if (isVisited[newRow][newColumn] || cheeseBoard[newRow][newColumn] <= day) continue;

                                    bfsQueue.offer(new int[]{newRow, newColumn});
                                    isVisited[newRow][newColumn] = true;
                                }
                            }
                        }
                    }
                }

                maxPieces = Math.max(maxPieces, connectedPieces);

                for (int row = 0; row < boardSize; row++) {
                    Arrays.fill(isVisited[row], false);
                }
            }

            resultBuilder.append("#").append(currentTestCase).append(" ").append(maxPieces).append("\n");
        }

        System.out.print(resultBuilder);
    }
}
