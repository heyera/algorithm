import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] one = new int[41];
        one[0] = 0;
        one[1] = 1;
        int[] zero = new int[41];
        zero[0] = 1;
        zero[1] = 0;

        for (int j = 2; j < 41; j++) {
            one[j] = one[j - 1] + one[j - 2];
            zero[j] = zero[j - 1] + zero[j - 2];
        }
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zero[N]).append(" ").append(one[N]).append("\n");

        }

        System.out.println(sb);

    }
}
