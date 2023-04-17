//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7576 {
    private static int moveRow[] = { 1, 0, -1, 0 };
    private static int movecol[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int box[][] = new int[row][col];
        ArrayList<int[]> tommato = new ArrayList<>(col * row);

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    tommato.add(new int[] { i, j });
                }

            }
        }
        int result = tommatoBox(box, tommato);

        if (end(box))
            System.out.println(result);
        else
            System.out.println("-1");
    }

    private static int tommatoBox(int[][] box, ArrayList<int[]> tommato) {
        Queue<int[]> que = new LinkedList<>();
        boolean vistited[][] = new boolean[box.length][box[0].length];

        for (int i = 0; i < tommato.size(); i++) {
            que.add(new int[] { tommato.get(i)[0], tommato.get(i)[1], 0 });
            vistited[tommato.get(i)[0]][tommato.get(i)[1]] = true;
        }
        int day = 0;
        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int row = temp[0];
            int col = temp[1];
            day = temp[2];
            for (int i = 0; i < 4; i++) {
                int newRow = row + moveRow[i];
                int newCol = col + movecol[i];
                if (check(newRow, newCol, box) && !vistited[newRow][newCol] && box[newRow][newCol] != -1) {
                    que.add(new int[] { newRow, newCol, day + 1 });
                    vistited[newRow][newCol] = true;
                    box[newRow][newCol] = 1;
                }
            }
        }
        return day;
    }

    private static boolean check(int row, int col, int[][] box) {
        if (row < box.length && 0 <= row && col < box[0].length && 0 <= col) {
            return true;
        }
        return false;
    }

    private static boolean end(int[][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
