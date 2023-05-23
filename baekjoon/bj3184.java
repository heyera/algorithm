//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3184 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int map[][] = new int[row][col];
        // 빈칸0, 양1 늑대 2, 울타리3
        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                if (temp.substring(j, j + 1).equals(".")) {
                    map[i][j] = 0;
                    continue;
                }
                if (temp.substring(j, j + 1).equals("o")) {
                    map[i][j] = 1;
                    continue;
                }
                if (temp.substring(j, j + 1).equals("v")) {
                    map[i][j] = 2;
                    continue;
                }
                if (temp.substring(j, j + 1).equals("#")) {
                    map[i][j] = 3;
                    continue;
                }
            }
        }
        sheepAndWolf(map);
    }

    static private void sheepAndWolf(int[][] map) {
        int moveRow[] = { 1, 0, -1, 0 };
        int moveCol[] = { 0, 1, 0, -1 };

        int maxRow = map.length;
        int maxCol = map[0].length;

        int totalSheep = 0;
        int totalWolf = 0;

        boolean visited[][] = new boolean[maxRow][maxCol];

        Queue<int[]> que = new LinkedList<>();
        // int area=0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                int sheep = 0;
                int wolf = 0;
                if (!visited[i][j] && map[i][j] < 3) {
                    que.add(new int[] { i, j });
                    visited[i][j] = true;
                    // area+=1;

                    while (!que.isEmpty()) {

                        int temp[] = que.poll();
                        int row = temp[0];
                        int col = temp[1];
                        if (map[row][col] == 1)
                            sheep += 1;
                        if (map[row][col] == 2)
                            wolf += 1;

                        for (int k = 0; k < 4; k++) {
                            int newRow = row + moveRow[k];
                            int newCol = col + moveCol[k];
                            if (checking(newRow, newCol, maxRow, maxCol) && !visited[newRow][newCol]
                                    && map[newRow][newCol] < 3) {
                                que.add(new int[] { newRow, newCol });
                                visited[newRow][newCol] = true;
                            }
                        }
                    }
                    // System.out.println(area+" - area");

                    if (sheep > wolf) {
                        totalSheep += sheep;
                        continue;
                    }
                    if (sheep <= wolf) {
                        totalWolf += wolf;
                        continue;
                    }
                }
            }
        }
        System.out.print(totalSheep);
        System.out.print(" ");
        System.out.print(totalWolf);
    }

    static private boolean checking(int row, int col, int mRow, int mCol) {
        return (row >= 0 && mRow > row && col >= 0 && mCol > col);
    }
}
