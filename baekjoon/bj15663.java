//Recursion_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15663 {
    private static StringBuilder sb;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        int original[] = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < original.length; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(original);
        int arr[] = new int[m];
        boolean[] visited = new boolean[n];
        makeNum(0, arr, original, visited, m);
        System.out.println(sb);
        // System.out.println(count);

    }

    private static void makeNum(int depth, int[] arr, int[] original, boolean[] visited, int max) {
        if (depth == max) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            count += 1;
            return;
        }
        int use = 0;
        for (int i = 0; i < original.length; i++) {
            if (visited[i] || use == original[i]) {
                continue;
            }
            arr[depth] = original[i];
            visited[i] = true;
            use = original[i];
            makeNum(depth + 1, arr, original, visited, max);
            visited[i] = false;
        }
    }

}
