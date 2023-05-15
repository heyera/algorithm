//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int map[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(map);
    }

    private static void bfs(int[][] map) {
        int max = 0;
        int cnt = 0;
        int maxRow = map.length;
        int maxCol = map[0].length;

        boolean visited[][] = new boolean[maxRow][maxCol];

        int moveRow[] = { 1, 0, -1, 0 };
        int moveCol[] = { 0, 1, 0, -1 };

        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (visited[i][j] || map[i][j] != 1)
                    continue;
                cnt+=1;
                int count = 1;
                que.add(new int[] { i, j });
                visited[i][j] = true;

                while (!que.isEmpty()) {
                    int temp[] = que.poll();
                    int row = temp[0];
                    int col = temp[1];

                    for (int k = 0; k < 4; k++) {
                        int newRow = row + moveRow[k];
                        int newCol = col + moveCol[k];

                        if (check(newRow, newCol, maxRow, maxCol)
                                && map[newRow][newCol] == 1
                                && !visited[newRow][newCol]) {
                            que.add(new int[] { newRow, newCol });
                            visited[newRow][newCol] = true;
                            count += 1;
                        }
                    }
                }
                max = Math.max(max, count);
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    private static boolean check(int row, int col, int maxRow, int maxCol) {
        return (row >= 0 && maxRow > row && col >= 0 && maxCol > col);
    }
}
