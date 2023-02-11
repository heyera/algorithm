import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean numArr[] = new boolean[N + 1];

        numArr[0] = numArr[1] = true;
        int sqrtN = (int) Math.sqrt(N);
        
        for (int i = 2; i <= sqrtN; i++) {
            for (int j = 2; j <= N / i; j++) {
                if (numArr[i * j] == true) {
                    continue;
                }
                numArr[i * j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (numArr[i] == false) {
                System.out.println(i);
            }
        }
    }
}
