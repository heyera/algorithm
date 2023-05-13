//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        int map[][] = new int[size + 1][size + 1];
        int dp[][] = new int[size + 1][size + 1];

        for (int i = 1; i < size + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < size + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //1,1에서부터 i,j까지 구간합을 dp에 삽입
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            int result = dp[endRow][endCol] - dp[endRow][startCol - 1] - dp[startRow - 1][endCol]
                    + dp[startRow - 1][startCol - 1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
