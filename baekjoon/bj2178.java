//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178 {
    private static int moveRow[] = { 1, 0, -1, 0 };
    private static int moveCol[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int map[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        System.out.println(serch(map));

    }

    private static int serch(int[][] map) {
        int result = 0;
        boolean visited[][] = new boolean[map.length][map[0].length];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { 0, 0, 1 });
        visited[0][0] = true;

        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int row = temp[0];
            int col = temp[1];
            int count = temp[2];
            if (row == map.length-1 && col == map[0].length-1) {
                result = count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = row + moveRow[i];
                int newCOl = col + moveCol[i];
                if (check(newRow, newCOl, map) && map[newRow][newCOl] == 1 && !visited[newRow][newCOl]) {
                    que.add(new int[] { newRow, newCOl, count + 1 });
                    visited[newRow][newCOl] = true;
                }
            }
        }

        return result;
    }

    private static boolean check(int row, int col, int[][] map) {
        return (0 <= row && 0 <= col && row < map.length && col < map[0].length);
    }
}
