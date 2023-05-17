//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int tri[][] = new int[size + 1][size + 1];

        for (int i = 1; i < size + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < i + 1; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long dp[][] = new long[501][501];
        // 거꾸로 거슬러 올라가서 최댓값만 더해줌
        
        for (int i = 1; i <= size; i++) {
            dp[size][i] = tri[size][i];
        }
        

        for (int i = size - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + tri[i][j];
            }
        }
        System.out.println(dp[1][1]);

    }
}
