//Recursion_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj15666 {
    private static StringBuilder sb;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");

        // SET으로 입력받아 중복 제거
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // SEt에서 배열로 변환
        Integer[] original = set.toArray(new Integer[set.size()]);
        Arrays.sort(original);

        int[] arr = new int[m];

        makeNum(0, 0, arr, original, m);
        System.out.println(sb);
        //System.out.println(count);

    }

    private static void makeNum(int start, int depth, int[] arr, Integer[] original, int limit) {
        if (depth == limit) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            count += 1;
            return;
        }
        for (int i = start; i < original.length; i++) {
            arr[depth] = original[i];
            makeNum(i, depth + 1, arr, original, limit);
        }
    }
}
