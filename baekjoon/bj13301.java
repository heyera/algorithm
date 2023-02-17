import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger arr[] = new BigInteger[n + 2];
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;

        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }

        BigInteger sum = BigInteger.ZERO;
        BigInteger four = new BigInteger("4");

        sum = arr[n].multiply(four).add(arr[n - 1]).add(arr[n - 1]);

        System.out.println(sum);
    }
}
