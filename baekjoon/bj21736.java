import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj21736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        String[][] map = new String[row][col];
        int[] start = new int[2];
        for (int i = 0; i < row; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = temp[j];
                if (temp[j].equals("I")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        System.out.println(bfs(map, start));

    }

    static private String bfs(String[][] map, int[] start) {
        int count = 0;
        int[] movingRow = { 1, 0, -1, 0 };
        int[] movingCol = { 0, 1, 0, -1 };

        int maxRow = map.length;
        int maxCol = map[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            Point now = que.poll();

            for (int i = 0; i < 4; i++) {
                int moveRow = now.getRow() + movingRow[i];
                int moveCol = now.getCol() + movingCol[i];
                if (cheking(moveRow, moveCol, maxRow, maxCol) && !map[moveRow][moveCol].equals("X")
                        && !visited[moveRow][moveCol]) {
                    que.add(new Point(moveRow, moveCol));
                    visited[moveRow][moveCol] = true;
                    if (map[moveRow][moveCol].equals("P"))
                        count += 1;
                }
            }
        }

        if (count == 0) {
            return "TT";
        }
        return count + "";
    }

    static private boolean cheking(int row, int col, int maxRow, int maxCol) {
        return (row >= 0 && maxRow > row && col >= 0 && maxCol > col);
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
