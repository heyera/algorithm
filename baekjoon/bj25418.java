
//https://www.acmicpc.net/problem/25418
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int dp[] = new int[K + 1];
        Arrays.fill(dp, 1000000);

        dp[A] = 0;
        dp[A + 1] = 1;
        
        for (int i = A + 2; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = (Math.min(dp[i - 1], dp[i / 2]))+1;
                continue;
            }
            dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[K]);
    }
}