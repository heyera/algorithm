//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int house = Integer.parseInt(br.readLine());
        int rgb[][] = new int[house + 1][3];

        int dp[][] = new int[house + 1][3];
        // R=0, G=1, B=2

        for (int i = 1; i <= house; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][0]=rgb[1][0];
        dp[1][1]=rgb[1][1];
        dp[1][2]=rgb[1][2];

        for (int i = 2; i <= house; i++) {
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+rgb[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+rgb[i][1];
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+rgb[i][2];
        }

        System.out.println(Math.min(dp[house][0], Math.min(dp[house][1], dp[house][2])));
    }
}
