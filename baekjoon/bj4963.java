//https://www.acmicpc.net/problem/4963

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4963 {
    static int nearRow[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int nearCol[] = { 1, 1, 0, -1, -1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int col = Integer.parseInt(st.nextToken()); // w
            int row = Integer.parseInt(st.nextToken()); // h
            if (row == 0 && col == 0) {
                break;
            }

            int map[][] = new int[row][col];
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(islandCount(map)).append("\n");

        }
        System.out.println(sb);

    }

    private static boolean near(int nr, int nc, int h, int w) {
        if (nr >= 0 && nc >= 0 && nr < h && nc < w)
            return true;
        return false;
    }

    private static int islandCount(int[][] map) {
        int col = map[0].length;
        int row = map.length;
        int count = 0;

        boolean visited[][] = new boolean[row][col];
        Queue<int[]> que = new LinkedList<>();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == 1 && !visited[r][c]) {
                    count += 1;
                    que.add(new int[] { r, c });
                    visited[r][c] = true;

                    while (!que.isEmpty()) {
                        int temp[] = que.poll();
                        int pollRow = temp[0];
                        int pollCol = temp[1];
                        //poll한 값에서 row랑 col값을 헷갈리지 말기!!
                        //System.out.printf("%d %d \n", pollRow, pollCol);
                        for (int i = 0; i < 8; i++) {
                            int nearPollRow = pollRow + nearRow[i];
                            int nearPollCol = pollCol + nearCol[i];

                            //System.out.printf("%d, %d \n", nearPollRow, nearPollCol);
                            if (near(nearPollRow, nearPollCol, row, col)
                                    && map[nearPollRow][nearPollCol] == 1
                                    && !visited[nearPollRow][nearPollCol]) {

                                que.add(new int[] { nearPollRow, nearPollCol });
                                visited[nearPollRow][nearPollCol] = true;

                            }

                        }

                    }
                }
            }
        }

        return count;
    }
}
