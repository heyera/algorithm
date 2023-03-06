import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        arr[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        int sum;
        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum = arr[b] - arr[a - 1];

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
