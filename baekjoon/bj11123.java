import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11123 {

    static int nearRow[] = { 0, 1, 0, -1 };
    static int nearCol[] = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = 0;
        while (t < T) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()); // h
            int col = Integer.parseInt(st.nextToken()); // w
            if (row == 0 && col == 0) {
                break;
            }

            String map[][] = new String[row][col];
            String str;
            for (int i = 0; i < row; i++) {
                str = br.readLine();
                for (int j = 0; j < col; j++) {
                    map[i][j] = str.substring(j, j + 1);
                }
            }
            sb.append(islandCount(map)).append("\n");
            t += 1;
        }
        System.out.println(sb);

    }

    private static boolean near(int nr, int nc, int h, int w) {
        if (nr >= 0 && nc >= 0 && nr < h && nc < w)
            return true;
        return false;
    }

    private static int islandCount(String[][] map) {
        int col = map[0].length;
        int row = map.length;
        int count = 0;

        boolean visited[][] = new boolean[row][col];
        Queue<int[]> que = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c].equals("#") && !visited[r][c]) {
                    count += 1;
                    que.add(new int[] { r, c });
                    visited[r][c] = true;

                    while (!que.isEmpty()) {
                        int temp[] = que.poll();
                        int pollRow = temp[0];
                        int pollCol = temp[1];
                        // poll한 값에서 row랑 col값을 헷갈리지 말기!!
                        //System.out.printf("%d %d \n", pollRow, pollCol);
                        for (int i = 0; i < 4; i++) {
                            int nearPollRow = pollRow + nearRow[i];
                            int nearPollCol = pollCol + nearCol[i];

                            //System.out.printf("%d, %d \n", nearPollRow, nearPollCol);
                            if (near(nearPollRow, nearPollCol, row, col)
                                    && map[nearPollRow][nearPollCol].equals("#")
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
