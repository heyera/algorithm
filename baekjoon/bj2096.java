//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int dpMax[] = new int[3];
        int dpMin[] = new int[3];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num0 = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (i == 0) {
                dpMax[0] = dpMin[0] = num0;
                dpMax[1] = dpMin[1] = num1;
                dpMax[2] = dpMin[2] = num2;
                continue;
            }

            int beforeNum0 = dpMax[0];
            int beforeNum2 = dpMax[2];
            dpMax[0] = Math.max(dpMax[0], dpMax[1]) + num0;
            dpMax[2] = Math.max(dpMax[2], dpMax[1]) + num2;
            dpMax[1] = Math.max(beforeNum0, Math.max(dpMax[1], beforeNum2)) + num1;

            beforeNum0 = dpMin[0];
            beforeNum2 = dpMin[2];
            dpMin[0] = Math.min(dpMin[0], dpMin[1]) + num0;
            dpMin[2] = Math.min(dpMin[2], dpMin[1]) + num2;
            dpMin[1] = Math.min(beforeNum0, Math.min(dpMin[1], beforeNum2)) + num1;

        }
        System.out.print(Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2])));
        System.out.print(" ");
        System.out.print(Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2])));

        /*
         * size가 100000 일때 메모리 초과
         * 
         * int arr[][] = new int[size + 1][size + 1];
         * int dpMax[][] = new int[size + 1][size + 1];
         * int dpMin[][] = new int[size + 1][size + 1];
         * 
         * for (int i = 1; i < size + 1; i++) {
         * st = new StringTokenizer(br.readLine(), " ");
         * for (int j = 1; j < size + 1; j++) {
         * int num = Integer.parseInt(st.nextToken());
         * arr[i][j] = num;
         * if (i == size) {
         * dpMax[size][j] = num;
         * dpMin[size][j] = num;
         * }
         * }
         * }
         * for (int i = size - 1; i > 0; i--) {
         * for (int j = 1; j < size + 1; j++) {
         * int max = 0;
         * int min = 10;
         * for (int a = -1; a < 2; a++) {
         * if (checking(j + a, size)) {
         * min = Math.min(min, dpMin[i + 1][j + a]);
         * max = Math.max(max, dpMax[i + 1][j + a]);
         * }
         * }
         * //System.out.println("i j " + i + " " + j + " " + max + " " + min);
         * dpMax[i][j] = arr[i][j] + max;
         * dpMin[i][j] = arr[i][j] + min;
         * 
         * }
         * }
         * 
         * // for (int i = 1; i < dpMax.length; i++) {
         * // for (int j = 1; j < dpMax.length; j++) {
         * // System.out.print(dpMax[i][j] + " ");
         * // }
         * // System.out.println();
         * // }
         * int max = 0;
         * int min = 10;
         * for (int i = 1; i < size + 1; i++) {
         * max = Math.max(max, dpMax[1][i]);
         * min = Math.min(min, dpMin[1][i]);
         * }
         * System.out.print(max);
         * System.out.print(" ");
         * System.out.print(min);
         */
    }

    // static private boolean checking(int col, int size) {
    // return col > 0 && size >= col;
    // }
}
