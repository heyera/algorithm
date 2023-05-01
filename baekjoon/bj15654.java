//Recursion_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15654 {
    public static StringBuilder sb;
    public static int count = 0;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        int arr[] = new int[m]; // 깊이 담을 배열
        int orignal[] = new int[n]; // 원본 담을 배열

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            orignal[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(orignal);

        dfs(0, arr, orignal, m);
        System.out.println(sb);
        //System.out.println(count);

    }

    private static void dfs(int depth, int[] arr, int[] orignal, int max) {
        if (depth == max) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            count += 1;
            return;
        }
        for (int i = 0; i < orignal.length; i++) {
            boolean pass = false;

            for (int j = 0; j < depth; j++) {
                if (arr[j] == orignal[i]) {
                    pass = true;
                    break;
                }
            }
            if (pass)
                continue;
            arr[depth] = orignal[i];
            dfs(depth + 1, arr, orignal, max);
        }
    }
}


