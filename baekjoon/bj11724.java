import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(node + 1);
        for (int i = 1; i < node + 2; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean visited[] = new boolean[node + 1];
        Queue<Integer> que = new LinkedList<>();
        int count = 0;

        for (int now = 1; now < node + 1; now++) {
            if (visited[now])
                continue;
            que.add(now);
            visited[now] = true;
            while (!que.isEmpty()) {
                int poll = que.poll();
                for (int i = 0; i < graph.get(poll).size(); i++) {
                    int temp = graph.get(poll).get(i);
                    if (!visited[temp]) {
                        que.add(temp);
                        visited[temp] = true;
                    }
                }
            }
            count += 1;
        }
        System.out.println(count);
    }
}
