//dfs_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15651 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int numLen = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        int[] num = new int[numLen];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < numLen; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int[] arr = new int[len];
        dfs(num, 0, 0, arr);
        System.out.println(sb);

    }

    private static void dfs(int[] num, int depth, int now, int[] arr) {
        if (depth == arr.length) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = now; i < num.length; i++) {
            arr[depth] = num[i];
            dfs(num, depth + 1, i+1, arr);

        }
    }
}
