import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13565 {
    static int xMove[] = { -1, 0, 0, 1 };
    static int yMove[] = { 0, -1, 1, 0 };
    static int map[][];
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];

        for (int i = 0; i < row; i++) {

            String str = br.readLine();

            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        boolean result = false;

        for (int i = 0; i < col; i++) {
            if (map[0][i] == 0) {
                if (bfs(0, i) == 1) {
                    result = true;
                    break;
                }
            }

        }

        if (result)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    public static int bfs(int a, int b) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { a, b });

        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int x = temp[1];
            int y = temp[0];

            // System.out.printf("now x %d y %d\n", x, y);

            for (int i = 0; i < 4; i++) {
                int xm = x + xMove[i];
                int ym = y + yMove[i];
                if (xm >= 0 && ym >= 0 && xm < col && ym < row && map[ym][xm] == 0) {
                    if (ym == row - 1) {
                        return 1;
                    }
                    map[ym][xm] = 1;
                    que.add(new int[] { ym, xm });
                }
            }
        }
        return 0;
    }
}
