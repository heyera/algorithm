import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        long dp[] = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int num = Integer.parseInt(br.readLine());
            for (int i = 6; i < num + 1; i++) {
                if (dp[i] != 0)
                    continue;
                dp[i] = dp[i - 1] + dp[i - 5];
            }
            sb.append(dp[num]).append("\n");
        }
        System.out.println(sb);
    }
}
