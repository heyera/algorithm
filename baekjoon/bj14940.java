//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];
        int[] start = new int[2];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        System.out.println(bfs(map, start));

    }

    private static String bfs(int[][] map, int[] start) {
        int[] moveRow = { 1, 0, -1, 0 };
        int[] moveCol = { 0, 1, 0, -1 };
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] result = new int[map.length][map[0].length];
        StringBuilder sb = new StringBuilder();

        Queue<Point> que = new LinkedList<>();
        Point startPoint = new Point(start[0], start[1], 0);
        que.add(startPoint);
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            Point now = que.poll();
            result[now.getRow()][now.getCol()] = now.getLen();

            for (int i = 0; i < 4; i++) {
                int newRow = moveRow[i] + now.getRow();
                int newCol = moveCol[i] + now.getCol();
                if (checking(newRow, newCol, map.length, map[0].length) && map[newRow][newCol] == 1
                        && !visited[newRow][newCol]) {
                    que.add(new Point(newRow, newCol, now.getLen() + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    sb.append(-1).append(" ");
                    continue;
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static boolean checking(int row, int col, int maxR, int maxC) {
        return (row >= 0 && maxR > row && col >= 0 && maxC > col);
    }

    static class Point {
        int row;
        int col;
        int len;

        public Point(int row, int col, int len) {
            this.row = row;
            this.col = col;
            this.len = len;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getLen() {
            return len;
        }

    }
}