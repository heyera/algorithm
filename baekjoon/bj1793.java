//DP_Java

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class bj1793 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        BigInteger[] dp = new BigInteger[251];

        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE.add(BigInteger.TWO);
        // dp[3]=6;

        for (int i = 3; i < 251; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.TWO));
        }


        while (sc.hasNextInt()) {
            System.out.println(dp[sc.nextInt()]);
        }

    }
}
