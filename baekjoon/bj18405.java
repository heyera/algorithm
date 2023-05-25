//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj18405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int virus = Integer.parseInt(st.nextToken());
        int map[][] = new int[size][size];
        ArrayList<int[]> loc[] = new ArrayList[virus + 1];
        for (int i = 1; i < virus + 1; i++) {
            loc[i] = new ArrayList<>();
        }
        // int loc[][] = new int[virus + 1][2];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    loc[map[i][j]].add(new int[] { i, j });
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int time = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken()) - 1;
        int col = Integer.parseInt(st.nextToken()) - 1;

        virusGrow(map, loc, size, time);

        // System.out.println();
        // for (int i = 0; i < size; i++) {
        //     for (int j = 0; j < size; j++) {
        //         System.out.print(map[i][j]);
        //         System.out.print(" ");
        //     }
        //     System.out.println();
        // }

        System.out.println(map[row][col]);
    }

    static private void virusGrow(int[][] map, ArrayList<int[]>[] loc, int size, int time) {
        int moveRow[] = { 1, 0, -1, 0 };
        int moveCol[] = { 0, 1, 0, -1 };

        Queue<int[]> que = new LinkedList<>();
        for (int i = 1; i < loc.length; i++) {
            for (int j = 0; j < loc[i].size(); j++) {
                que.add(new int[] { loc[i].get(j)[0], loc[i].get(j)[1], i, 0 });
            }
        }

        while (!que.isEmpty()) {
            int poll[] = que.poll();
            int row = poll[0];
            int col = poll[1];
            int status = poll[2];
            int step = poll[3];

            if (step == time)
                continue;

            for (int i = 0; i < 4; i++) {
                int nRow = row + moveRow[i];
                int nCol = col + moveCol[i];
                if (checking(nRow, nCol, size) && map[nRow][nCol] == 0) {
                    que.add(new int[] { nRow, nCol, status, step + 1 });
                    map[nRow][nCol] = status;
                }
            }
        }
    }

    static private boolean checking(int row, int col, int size) {
        return (row >= 0 && size > row && col >= 0 && size > col);
    }
}
