//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int map[][] = new int[size + 1][size + 1];

        for (int i = 1; i < size + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < size + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int dp[][][] = new int[size + 1][size + 1][3];
        // 가로 0, 대각선 1, 세로 2
        dp[1][2][0] = 1;
        for (int i = 1; i < size + 1; i++) {
            for (int j = 2; j < size + 1; j++) {
                // 가로처리, 세로처리
                if (map[i][j] != 1) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];
                    dp[i][j][2] += dp[i - 1][j][1] + dp[i - 1][j][2];

                }
                // 대각선 처리
                if (map[i][j] != 1 && map[i - 1][j] != 1 && map[i][j - 1] != 1) {
                    dp[i][j][1] += dp[i - 1][j-1][2] + dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1];
                }

            }
        }
        // System.out.println();
        // for (int a = 0; a < 3; a++) {
        //     System.out.println(a + " : 가로 0, 대각선 1, 세로 2");
        //     for (int i = 1; i < dp.length; i++) {
        //         for (int j = 1; j < dp.length; j++) {
        //             System.out.print(dp[i][j][a]);
        //             System.out.print(" ");
        //         }
        //         System.out.println();
        //     }
        // }
        System.out.println(dp[size][size][0] + dp[size][size][1] + dp[size][size][2]);
    }

}
