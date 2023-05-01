//DP_JAVA

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[size];
        int dp[] = new int[size];
        int max = 1;

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;

        for (int i = 1; i < size; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] >= dp[i])
                    dp[i] = dp[j] + 1;
            }
            max=Math.max(max, dp[i]);

        }
        System.out.println(max);
    }
}
