//Recursion_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15652 {
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[m];

        sb = new StringBuilder();
        dfs(1, 0, arr, n);
        System.out.println(sb);

    }

    private static void dfs(int num, int depth, int[] arr, int end) {
        if (depth == arr.length) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = num; i <= end; i++) {
            arr[depth] = i;
            dfs(i, depth + 1, arr, end);
        }
    }
}
