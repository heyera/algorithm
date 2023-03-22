import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        System.out.println(bfs(A, B));
    }

    public static long bfs(long A, long B) {
        Queue<long[]> que = new LinkedList<>();
        que.add(new long[] { A, 1 });
        while (!que.isEmpty()) {
            long arr[] = que.poll();
            long poll = arr[0];
            long dis = arr[1];
            long answer1 = poll * 2;
            long answer2 = poll * 10 + 1;
            if (answer1 == B || answer2 == B) {
                return dis + 1;
            }
            if ( B >= answer1) {
                que.add(new long[] { answer1, dis + 1 });
            }
            if (B >= answer2 ) {
                que.add(new long[] { answer2, dis + 1 });
            }
        }

        return -1;
    }
}
