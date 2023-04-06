import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < testcase; tc++) {
            int n = Integer.parseInt(br.readLine());
            int count = 1;

            HashMap<String, Integer> wear = new HashMap<>();
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String wearKind = st.nextToken();

                if (wear.containsKey(wearKind)) {
                    wear.put(wearKind, wear.get(wearKind) + 1);
                } else {
                    wear.put(wearKind, 1);
                }
            }

            for (int val : wear.values()) {
                count *= (val + 1);
            }
            sb.append(count - 1).append("\n");

        }
        System.out.println(sb);
    }
}
