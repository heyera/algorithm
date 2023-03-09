import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1012 {
    static int M, N, K;
    static int farm[][];
    static boolean farmCheck[][];
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int a = 0; a < T; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken());

            farm = new int[M][N];
            farmCheck = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                farm[x][y] = 1;
            }
            int count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (farm[i][j] == 1 && !farmCheck[i][j]) {
                        serch(i, j);
                        count += 1;
                    }
                }
            }

            sb.append(count).append("\n");

        }
        System.out.println(sb);

    }

    private static void serch(int startX, int startY) {
        farmCheck[startX][startY] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { startX, startY });
        while (!que.isEmpty()) {
            int[] point = que.poll();

            for (int i = 0; i < 4; i++) {
                int row = point[0] + dx[i];
                int cols = point[1] + dy[i];

                if (row < 0 || row >= M || cols < 0 || cols >= N) {
                    continue;
                }
                if (farm[row][cols] == 1 && !farmCheck[row][cols]) {
                    que.add(new int[] { row, cols });
                    farmCheck[row][cols] = true;
                }
            }

        }
    }
}
