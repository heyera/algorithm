import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11047 {
    static int N;
    static int K;
    static ArrayList<Integer> coins;

    public static void main(String[] args) throws IOException {
        input();

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K < coins.get(i)) {
                continue;
            }

            count += K / coins.get(i);
            K = K % coins.get(i);
        }

        System.out.println(count);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }
    }
}
