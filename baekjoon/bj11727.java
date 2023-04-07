import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[1001];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        dp[4] = 9;
        dp[5] = 21;
        
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
        }
        System.out.println(dp[n]);
    }
}
