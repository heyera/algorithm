import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken()); // R번째 줄
        int C = Integer.parseInt(st.nextToken()); // C번째 수 꼭짓점
        int W = Integer.parseInt(st.nextToken()); // 한변의 길이 W

        int pascal[][] = new int[32][32];
        pascal[1][1] = 1;
        pascal[2][1] = 1;
        pascal[2][2] = 1;
        for (int i = 3; i < R+W+ 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (j == 1 || j == i+1) {
                    pascal[i][j] = 1;
                    continue;
                }
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        int sum = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < i+1; j++) {
                sum+=pascal[R+i][C+j];
            }
        }
        System.out.println(sum);
    }
}
