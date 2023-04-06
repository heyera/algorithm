import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String dp[] = new String[1001];
        dp[1] = "CY";
        dp[2] = "SK";
        dp[3] = "CY";
        String order;
        for (int i = 4; i < n + 1; i++) {
            order = new String();
            if (i % 2 == 0)
                order = "CY";
            if (i % 2 == 1)
                order = "SK";

            if (!dp[i - 1].equals(order) || !dp[i - 3].equals(order)) {
                dp[i] = order;
                continue;
            }

            dp[i] = (order.equals("CY")) ? "SK" : "CY";
            

        }
        System.out.println(dp[n]);
    }
}
