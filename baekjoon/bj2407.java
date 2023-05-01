//Arbitrary precision_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class bj2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // m이 절반보다 클경우 연산
        if (m > n / 2) {
            m = n - m;
        }
        BigInteger top = BigInteger.ONE;
        BigInteger bottom = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            top = top.multiply(new BigInteger(String.valueOf(n - i)));
            bottom = bottom.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        System.out.println(top.divide(bottom));

    }
}
