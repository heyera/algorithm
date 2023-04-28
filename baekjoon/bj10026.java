//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj10026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int mapRGB[][] = new int[size][size];
        int mapRRB[][] = new int[size][size];
        // R은 0, G는 1, B는 2로 기록
        for (int r = 0; r < size; r++) {
            String str = br.readLine();
            for (int c = 0; c < size; c++) {
                switch (str.substring(c, c + 1)) {
                    case "R":
                        mapRGB[r][c] = 0;
                        mapRRB[r][c] = 0;
                        break;
                    case "G":
                        mapRGB[r][c] = 1;
                        mapRRB[r][c] = 0;
                        break;
                    case "B":
                        mapRGB[r][c] = 2;
                        mapRRB[r][c] = 2;
                        break;
                }
            }
        }
        System.out.print(RGB(mapRGB, size));
        System.out.print(" ");
        System.out.print(RGB(mapRRB, size));

    }

    private static int RGB(int[][] map, int size) {
        int moveRow[] = { 1, 0, -1, 0 };
        int moveCol[] = { 0, 1, 0, -1 };
        boolean visited[][] = new boolean[map.length][map.length];
        int area = 0;
        Queue<int[]> que = new LinkedList<>();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (!visited[r][c]) {
                    que.add(new int[] { r, c });
                    visited[r][c] = true;

                    while (!que.isEmpty()) {
                        int temp[] = que.poll();
                        int row = temp[0];
                        int col = temp[1];
                        for (int i = 0; i < 4; i++) {
                            int newRow = row + moveRow[i];
                            int newCol = col + moveCol[i];
                            if (check(newRow, newCol, size) && !visited[newRow][newCol]
                                    && map[r][c] == map[newRow][newCol]) {
                                que.add(new int[] { newRow, newCol });
                                visited[newRow][newCol] = true;
                            }
                        }

                    }
                    area += 1;
                }
            }

        }
        return area;
    }

    private static boolean check(int row, int col, int size) {
        return (row >= 0 && size > row && col >= 0 && size > col);
    }
}
