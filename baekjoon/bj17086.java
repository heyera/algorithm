import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17086 {
    static int cnear[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static int rnear[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int n; // row
    static int m; // col

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int shark[][] = new int[n][m];
        int locShark[][] = new int[n * m][2];
        int sharkCount = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                shark[i][j] = Integer.parseInt(st.nextToken());
                if (shark[i][j] == 1) {
                    locShark[sharkCount][0] = i;
                    locShark[sharkCount][1] = j;
                    sharkCount += 1;
                }
            }

        }
        System.out.println(serchbfs(shark, locShark, sharkCount));

    }

    public static int serchbfs(int[][] shark, int[][] locshark, int sharkCount) {

        Queue<int[]> que;
        boolean visited[][];

        for (int i = 0; i < sharkCount; i++) {
            que = new LinkedList<>();
            visited = new boolean[n][m];

            que.add(new int[] { locshark[i][0], locshark[i][1] });
            visited[locshark[i][0]][locshark[i][1]] = true;

            // System.out.printf("sharkCount %d\n", i);
            // System.out.println();
            while (!que.isEmpty()) {
                int temp[] = que.poll();
                int pollRow = temp[0];
                int pollCol = temp[1];
                int nowDis = shark[pollRow][pollCol];

                for (int j = 0; j < 8; j++) {

                    int nearPollRow = pollRow + rnear[j];
                    int nearPollCol = pollCol + cnear[j];
                    if (near(nearPollRow, nearPollCol) && visited[nearPollRow][nearPollCol] != true) {
                        int nearDis = shark[nearPollRow][nearPollCol];
                        if (nearDis == 0) {
                            shark[nearPollRow][nearPollCol] = nowDis + 1;
                            visited[nearPollRow][nearPollCol] = true;

                        } else {
                            if (nowDis < nearDis) {
                                shark[nearPollRow][nearPollCol] = nowDis + 1;
                                visited[nearPollRow][nearPollCol] = true;
                            }
                            if (nowDis == nearDis)
                                continue;
                        }

                        que.add(new int[] { nearPollRow, nearPollCol });

                    }

                }

            }
            // System.out.println();
            // for (int b = 0; b < n; b++) {
            // for (int y = 0; y < m; y++) {
            // System.out.print(shark[b][y]);
            // System.out.print(" ");
            // }
            // System.out.println();
            // }

        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < shark[i][j])
                    max = shark[i][j];

            }

        }

        return max - 1;
    }

    public static boolean near(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;

    }
}