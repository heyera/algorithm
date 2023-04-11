import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2630 {
    static int n, paper[][], blue = 0, white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);
        System.out.println(white);
        System.out.println(blue);

    }

    private static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (paper[row][col] == 1)
                blue += 1;
            if (paper[row][col] == 0)
                white += 1;
            return;
        }
        int halfsize = size / 2;
        for (int i = row; i < row + size; i += halfsize) {
            for (int j = col; j < col + size; j += halfsize) {
                partition(i, j, halfsize);
            }
        }
    }

    private static boolean check(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[row][col] != paper[i][j])
                    return false;
            }
        }
        return true;
    }
}
