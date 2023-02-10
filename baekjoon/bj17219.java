import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        HashMap<String, String> passWord = new HashMap<String, String>(M);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            passWord.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(passWord.get(br.readLine())).append("\n");
        }

        System.out.println(sb);

    }
}
