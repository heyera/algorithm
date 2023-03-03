import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double arr[] = new double[n];
        double dp[] = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i]= Double.parseDouble(br.readLine());
        }
        dp[0]=arr[0];
        
        double maxNum=0;
        for (int i = 1; i < n; i++) {
            dp[i]=Math.max(arr[i], arr[i]*dp[i-1]);
            maxNum=Math.max(dp[i], maxNum);
        }
        System.out.printf("%.3f\n",maxNum);

    }
}
