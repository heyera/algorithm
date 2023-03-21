import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj17656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[50001];
        for (int i = 1; i < dp.length; i++) {
            int temp = i * i;
            if (temp > 50001) {
                break;
            }
            dp[temp] = 1;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 2;

        for (int i = 10; i < n + 1; i++) {
            int root = (int) Math.sqrt(i);
            ArrayList<Integer> arr = new ArrayList<Integer>(224);
            for (int j = 1; j < root + 1; j++) {
                arr.add(dp[i - (j * j)]);
            }
            // System.out.println(arr);
            dp[i] = Collections.min(arr) + 1;
        }

        int answer = dp[n];
        System.out.println(answer);

    }
}
