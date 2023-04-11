import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1780 {
    static int n, paper[][], zero = 0, one = 0, minus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

    }

    private static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            int num = paper[row][col];
            if (num == -1)
                minus += 1;
            if (num == 0)
                zero += 1;
            if (num == 1)
                one += 1;
            return;
        }
        int partSize = size / 3;
        for (int i = row; i < row + size; i += partSize) {
            for (int j = col; j < col + size; j += partSize) {
                partition(i, j, partSize);
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
