import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int pascal[][] = new int[32][32];
        pascal[1][1] = 1;
        pascal[2][1] = 1;
        pascal[2][2] = 1;
        for (int i = 3; i < n+ 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (j == 1 || j == i+1) {
                    pascal[i][j] = 1;
                    continue;
                }
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
        System.out.println(pascal[n][k]);
    }
}
