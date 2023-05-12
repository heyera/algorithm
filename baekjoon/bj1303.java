//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int map[][] = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            String temp = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                if (temp.substring(j, j + 1).equals("W")) {
                    map[i][j] = 1;
                    continue;
                }
                map[i][j] = 0;
            }
        }
        team(map);
    }

    private static void team(int[][] map) {
        int moveRow[] = { 1, 0, -1, 0 };
        int moveCol[] = { 0, 1, 0, -1 };
        int wPower = 0;
        int bPower = 0;
        int maxR = map.length;
        int maxC = map[0].length;

        boolean visited[][] = new boolean[map.length][map[0].length];
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < maxR; i++) {
            for (int j = 0; j < maxC; j++) {
                if (visited[i][j] != true) {
                    int people = 1;
                    que.add(new int[] { i, j });
                    visited[i][j] = true;
                    while (!que.isEmpty()) {
                        int temp[] = que.poll();
                        int row = temp[0];
                        int col = temp[1];
                        for (int k = 0; k < 4; k++) {
                            int newRow = row + moveRow[k];
                            int newCol = col + moveCol[k];

                            if (check(newRow, newCol, maxR, maxC)
                                    && map[i][j] == map[newRow][newCol]
                                    && visited[newRow][newCol] != true) {

                                people += 1;
                                que.add(new int[] { newRow, newCol });
                                visited[newRow][newCol] = true;
                            }

                        }
                    }
                    if (map[i][j] == 1) {
                        wPower += Math.pow(people, 2);
                        continue;
                    }
                    bPower += Math.pow(people, 2);

                }
            }

        }
        System.out.print(wPower);
        System.out.print(" ");
        System.out.print(bPower);

    }

    private static boolean check(int row, int col, int maxR, int maxC) {
        return (row >= 0 && maxR > row && col >= 0 && maxC > col);
    }
}
