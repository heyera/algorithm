//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[100001];
        dp[1] = 1;
        //dp[2] = 2;
        //dp[3] = 3;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i == Math.pow(j, 2)) {
                    dp[i] = 1;
                    break;
                }
                if (dp[i] > dp[i - (j*j)] + 1) {
                    dp[i] = dp[i - (j*j)] + 1;
                }
            }
        }

        // for (int i = 1; i <= n; i++) {
        //     System.out.println(i+" "+dp[i]);
        // }
        // System.out.println();

        System.out.println(dp[n]);
    }
}
