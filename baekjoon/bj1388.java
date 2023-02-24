import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int tile[][] = new int[N][M];
        // boolean tileCheck[][] = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();

            for (int j = 0; j < M; j++) {
                if (temp.substring(j, j + 1).equals("-")) {
                    tile[i][j] = 0;
                }
                if (temp.substring(j, j + 1).equals("|")) {
                    tile[i][j] = 1;
                }
                // tileCheck[i][j] = false;
            }
        }

        int count = N * M;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // tileCheck[i][j]=true;

                if (j < M - 1) {    // 가로비교
                    if (tile[i][j] == tile[i][j + 1] && tile[i][j] == 0) {
                        // tileCheck[i][j+1]=false;
                        count -= 1;
                    }
                }
                if (i < N - 1) {    // 세로비교
                    if (tile[i][j] == tile[i + 1][j] && tile[i][j] == 1) {
                        // tileCheck[i+1][j]=false;
                        count -= 1;
                    }
                }
            }

        }
        System.out.println(count);

    }
}
