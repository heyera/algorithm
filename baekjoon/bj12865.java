//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int bag = Integer.parseInt(st.nextToken());

        int value[] = new int[num + 1];
        int weight[] = new int[num + 1];

        for (int i = 1; i < num+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[num + 1][bag + 1];
        for (int i = 1; i < num+1; i++) {
            for (int w = 1; w < bag + 1; w++) {
                if (weight[i] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
                    continue;
                }
                dp[i][w] = dp[i - 1][w];
 
            }
        }
        System.out.println(dp[num][bag]);

    }
}
