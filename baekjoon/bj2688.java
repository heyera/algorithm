//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int max = 0;
        int arr[] = new int[tc];

        for (int a = 0; a < tc; a++) {
            arr[a] = Integer.parseInt(br.readLine())+1;
            max = Math.max(max, arr[a]);
        }

        long dp[][] = new long[66][10];

        Arrays.fill(dp[1], 1);

        for (int i = 2; i < max + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int i = 0; i < tc; i++) {
            System.out.println(dp[arr[i]][9]);
        }
    }
}
/*
 * 
 3	2	1	
220	55	10	1
165	45	9	1
120	36	8	1
84	28	7	1
56	21	6	1
35	15	5	1
20	10	4	1
10	6	3	1
4	3	2	1
1	1	1	1

 */