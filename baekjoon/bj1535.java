//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int debuff[] = new int[n + 1];
        int happy[] = new int[n + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n+1; i++) {
            debuff[i] = Integer.parseInt(st1.nextToken());
            happy[i] = Integer.parseInt(st2.nextToken());
        }
        int dp[][] = new int[n + 1][100];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 100; j++) {
                if (debuff[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - debuff[i]] + happy[i]);
                    continue;
                }
                dp[i][j] = dp[i - 1][j];

            }
        }
        System.out.println(dp[n][99]);
    }
}
