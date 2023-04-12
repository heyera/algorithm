import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1074 {
    static int n, R, C, now = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        fillMap(0, 0, (int) Math.pow(2, n));
    }

    private static void fillMap(int row, int col, int size) {
        if (size == 1) {
            System.out.println(now);
            return;
        }
        int newSize = size / 2;
        if (R < row + newSize && C < col + newSize)
            fillMap(row, col, newSize);

        if (R < row + newSize && col + newSize <= C) {
            now += (size * size) / 4;
            fillMap(row, col + newSize, newSize);
        }

        if (row + newSize <= R && C < col + newSize) {
            now += ((size * size) / 4) * 2;
            fillMap(row + newSize, col, newSize);
        }

        if (row + newSize <= R && col + newSize <= C) {
            now += ((size * size) / 4) * 3;
            fillMap(row + newSize, col + newSize, newSize);
        }
    }

}
