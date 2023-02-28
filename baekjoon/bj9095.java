import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int arr[] = new int[12];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        StringBuilder sb = new StringBuilder();

        int max = Integer.MIN_VALUE;
        int line[] = new int[T];
        for (int i = 0; i < T; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if (max < line[i])
                max = line[i];

        }

        for (int j = 4; j < max+1 + 1; j++) {
            arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
        }

        for (int i = 0; i < line.length; i++) {
            sb.append(arr[line[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
