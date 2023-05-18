//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int need = Integer.parseInt(st.nextToken());

        long dp[][] = new long[need + 1][num + 1];
        for (int i = 0; i < need + 1; i++) {
            dp[i][0] = 1;
        }

        Arrays.fill(dp[1], 1);

        for (int i = 2; i < need + 1; i++) {
            for (int j = 1; j < num + 1; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }
        System.out.println(dp[need][num]);
    }
}
