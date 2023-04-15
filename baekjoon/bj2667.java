//BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bj2667 {
    private static int moveRow[] = { 1, 0, -1, 0 };
    private static int moveCol[] = { 0, 1, 0, -1 };
    private static int map[][];
    private static boolean visited[][];
    private static int count = 0;
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        visited = new boolean[map.length][map.length];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    count += 1;
                }
            }
        }
        System.out.println(count);
        result.sort(null);
        for (int i : result) {
            System.out.println(i);
        }

    }

    private static void bfs(int row, int col) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { row, col, 1 });
        visited[row][col] = true;

        int num = 1;
        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int nowRow = temp[0];
            int nowCol = temp[1];
            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + moveRow[i];
                int newCol = nowCol + moveCol[i];
                if (check(newRow, newCol, map.length) && map[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    que.add(new int[] { newRow, newCol });
                    visited[newRow][newCol] = true;
                    num += 1;
                }

            }
        }
        result.add(num);
    }

    private static boolean check(int row, int col, int size) {
        return row < size && col < size && 0 <= row && 0 <= col;
    }
}
