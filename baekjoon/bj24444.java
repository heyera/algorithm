import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj24444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> map = new ArrayList<>(node + 1);
        int visited[] = new int[node + 1];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < node + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        que.add(start);
        int count = 1;
        visited[start] = count;
        for (int i = 0; i < node + 1; i++) {
            Collections.sort(map.get(i));
        }
        while (!que.isEmpty()) {
            int tempNode = que.poll();

            for (int a : map.get(tempNode)) {
                if (visited[a] == 0) {
                    que.add(a);
                    visited[a] = ++count;
                }

            }

        }
        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }
}
