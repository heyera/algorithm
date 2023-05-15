//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int maxHight = 0;

        int map[][] = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHight)
                    maxHight = map[i][j];
            }
        }

        System.out.println(bfs(map, maxHight));
    }

    private static int bfs(int[][] map, int maxHight) {
        int max = 0;
        int size = map.length;

        int moveRow[] = { 1, 0, -1, 0 };
        int moveCol[] = { 0, 1, 0, -1 };

        Queue<int[]> que = new LinkedList<>();
        for (int hight = 0; hight < maxHight; hight++) {
            boolean visited[][] = new boolean[size][size];
            int count = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (visited[i][j] || map[i][j] <= hight)
                        continue;

                    que.add(new int[] { i, j });
                    count+=1;
                    visited[i][j] = true;

                    while (!que.isEmpty()) {
                        int temp[] = que.poll();
                        int row = temp[0];
                        int col = temp[1];

                        for (int k = 0; k < 4; k++) {
                            int newRow = row + moveRow[k];
                            int newCol = col + moveCol[k];

                            if (check(newRow, newCol, size)
                                    && map[newRow][newCol] > hight
                                    && !visited[newRow][newCol]) {
                                que.add(new int[] { newRow, newCol });
                                visited[newRow][newCol] = true;
                            }
                        }
                    }
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static boolean check(int row, int col, int size) {
        return (row >= 0 && size > row && col >= 0 && size > col);
    }
}
