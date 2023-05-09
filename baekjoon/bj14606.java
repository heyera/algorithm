//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj14606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[11];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 3;
        for (int i = 4; i <= n ; i++) {
            dp[i]=dp[i/2]+dp[i-i/2]+(i/2*(i-i/2));
        }
        System.out.println(dp[n]);
    }
}
