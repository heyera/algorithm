import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(node + 1);
        boolean visited[] = new boolean[node + 1];

        for (int i = 1; i <= node + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        StringTokenizer st;
        for (int i = 0; i < node - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int parents[] = new int[node + 1];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = true;
        int temp;
        while (!que.isEmpty()) {
            int poll = que.poll();
            for (int i = 0; i < graph.get(poll).size(); i++) {
                temp = graph.get(poll).get(i);
                if (visited[temp] != true) {
                    que.add(temp);
                    visited[temp] = true;
                    parents[temp] = poll;
                }
            }
        }
        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }

    }
}
