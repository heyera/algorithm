import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj1260 {
    static int grahp[][];
    static StringBuilder sbDfs = new StringBuilder();
    static StringBuilder sbBfs = new StringBuilder();
    // static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        grahp = new int[node + 1][node + 1];
        boolean visited[] = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            grahp[x][y] = 1;
            grahp[y][x] = 1;
        }

        dfs(start, visited);
        visited = new boolean[node + 1];
        bfs(start, visited);
        System.out.println(sbDfs);
        System.out.println(sbBfs);
    }

    static void dfs(int start, boolean[] visited) {
        visited[start] = true;
        sbDfs.append(start).append(" ");
        for (int i = 1; i < grahp.length; i++) {
            if (grahp[start][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }

    }

    static void bfs(int start, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int node = que.poll();
            sbBfs.append(node).append(" ");
            for (int i = 1; i < grahp.length; i++) {
                if (grahp[node][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
