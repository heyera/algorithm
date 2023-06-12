//dfs_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15649 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        int[] arr = new int[len];
        boolean[] visited = new boolean[num + 1];
        dfs(num, 0, arr, visited);
        System.out.println(sb);

    }

    private static void dfs(int num, int depth, int[] arr, boolean[] visited) {
        if (depth == arr.length) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i < num + 1; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                dfs(num, depth + 1, arr, visited);
                visited[i] = false;
            }
        }
    }
}
