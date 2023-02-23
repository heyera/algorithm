import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long arr[] = new long[1000001];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < Math.abs(n) + 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000000;
        }

        if (n > 0 || (n < 0 && n % 2 != 0)) {
            System.out.println(1);
        }
        if (n == 0) {
            System.out.println(0);
        }
        if (n < 0 && n % 2 == 0) {
            System.out.println(-1);
        }
        System.out.println(arr[Math.abs(n)]);

    }
}
