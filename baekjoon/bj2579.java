import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hight = Integer.parseInt(br.readLine());
        int stair[] = new int[300];

        for (int i = 0; i < hight; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        int dp[] = new int[300];
        dp[0] = stair[0];
        dp[1] = dp[0] + stair[1];
        dp[2] = Math.max(stair[0], stair[1]) + stair[2];
        for (int i = 3; i < hight; i++) {
            dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
        }
        System.out.println(dp[hight - 1]);
    }
}
