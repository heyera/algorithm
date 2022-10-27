import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18111 {
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int b;

    public static void main(String[] args) throws IOException {

        int[][] area = input();

        int result = Integer.MAX_VALUE;
        int height = Integer.MIN_VALUE;

        while (min <= max) {
            int have = b;
            int second = 0;
            for (int i = 0; i < area.length; i++) {
                for (int j = 0; j < area[i].length; j++) {
                    int temp = area[i][j] - min;
                    
                    second += (temp > 0) ? temp * 2 : -temp;                
                    have += (temp > 0) ? temp : -temp;
                }
            }

            if (have >= 0 && result >= second) {
                result = second;
                height = min;
            }

            min++;
        }

        System.out.println(result + " " + height);
    }

    private static int[][] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int[][] area = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, area[i][j]);
                min = Math.min(min, area[i][j]);
            }
        }
        return area;
    }
}
