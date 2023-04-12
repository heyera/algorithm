import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.HashMap;
import java.util.StringTokenizer;

public class bj18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int original[] = new int[n];
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = original[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], rank);
                rank += 1;
            }
        }

        temp = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            temp[i] = map.get(original[i]);
            sb.append(temp[i]).append(" ");
        }

        System.out.println(sb);
    }
}
