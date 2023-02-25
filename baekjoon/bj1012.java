import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1012 {
    static int M, N, K;
    static int farm[][];
    static boolean farmCheck[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int a = 0; a < T; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 세로
            N = Integer.parseInt(st.nextToken()); // 가로
            K = Integer.parseInt(st.nextToken());

            farm = new int[M][N];
            farmCheck = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                farm[x][y] = 1;
                farmCheck[x][y] = true;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    serch(i, j);
                }
            }

            int count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (farmCheck[i][j] == true) {
                        count += 1;
                    }
                }
            }
            sb.append(count).append("\n");

        }
        System.out.println(sb);

    }

    private static void serch(int i, int j) {
        if (farm[i][j] == 1) {
            //오른쪽이랑 비교
            if (j < N - 1) {
                if (farm[i][j + 1] == 1) {
                    farmCheck[i][j + 1] = false;
                }
            }
            // 아래쪽이랑 비교
            if (i < M - 1) {
                if (farm[i + 1][j] == 1) {
                    farmCheck[i + 1][j] = false;
                }
            }
        }
    }
}
