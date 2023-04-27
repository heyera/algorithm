//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7869 {
    static int moveRow[] = { 1, 0, -1, 0 };
    static int moveCol[] = { 0, 1, 0, -1 };
    static int moveHight[] = { 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int hight = Integer.parseInt(st.nextToken());

        int[][][] box = new int[hight][row][col];
        ArrayList<int[]> tomatoList = new ArrayList<>();

        for (int h = 0; h < hight; h++) {
            for (int r = 0; r < row; r++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < col; c++) {
                    box[h][r][c] = Integer.parseInt(st.nextToken());
                    if (box[h][r][c] == 1) {
                        tomatoList.add(new int[] { h, r, c, });
                    }
                }
            }
        }

        int result = tommatoBox(tomatoList, box);
        if (boxCheck(box)) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }

    private static int tommatoBox(ArrayList<int[]> tomatoList, int[][][] box) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][][] visited = new boolean[box.length][box[0].length][box[0][0].length];

        for (int i = 0; i < tomatoList.size(); i++) {
            int[] temp = tomatoList.get(i);
            que.add(new int[] { temp[0], temp[1], temp[2], 0 });
            visited[temp[0]][temp[1]][temp[2]] = true;
        }

        int day = 0;

        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int hight = temp[0];
            int row = temp[1];
            int col = temp[2];
            day = temp[3];

            for (int h = 0; h < 2; h++) {
                int newHight = hight + moveHight[h];

                if (check(newHight, row, col, box) && box[newHight][row][col] == 0
                        && !visited[newHight][row][col]) {

                    que.add(new int[] { newHight, row, col, day + 1 });
                    visited[newHight][row][col] = true;
                    box[newHight][row][col] = 1;
                }
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + moveRow[i];
                int newCol = col + moveCol[i];

                if (check(hight, newRow, newCol, box) && box[hight][newRow][newCol] == 0
                        && !visited[hight][newRow][newCol]) {

                    que.add(new int[] { hight, newRow, newCol, day + 1 });
                    visited[hight][newRow][newCol] = true;
                    box[hight][newRow][newCol] = 1;

                }
            }
        }

        return day;
    }

    private static boolean check(int h, int row, int col, int[][][] box) {
        return (h >= 0 && box.length > h &&
                row >= 0 && box[0].length > row &&
                col >= 0 && box[0][0].length > col);
    }

    private static boolean boxCheck(int[][][] box) {
        for (int h = 0; h < box.length; h++) {
            for (int r = 0; r < box[0].length; r++) {
                for (int c = 0; c < box[0][0].length; c++) {
                    if (box[h][r][c] == 0)
                        return false;
                }
            }
        }
        return true;
    }
}
