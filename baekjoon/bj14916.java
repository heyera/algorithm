import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = new int[100001];
        // 초기값
        arr[0] = Integer.MAX_VALUE;
        arr[1] = Integer.MAX_VALUE;
        arr[2] = 1;
        arr[3] = Integer.MAX_VALUE;
        arr[4] = 2;
        arr[5] = 1;

        int n = Integer.parseInt(br.readLine());

        for (int i = 6; i < n + 1; i++) {
            arr[i] = Math.min(arr[i - 2], arr[i - 5]) + 1; // 2뺀거랑 5뺀거 비교
        }

        if (arr[n] == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(arr[n]);
        }
    }
}
