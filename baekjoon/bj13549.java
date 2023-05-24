//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13549 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int strat = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(serch_bfs(strat, end));

    }

    static private int serch_bfs(int start, int end) throws InterruptedException {
        int visited[] = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] { start, 0 });
        visited[start] = 0;
        while (!que.isEmpty()) {
            int poll[] = que.poll();
            int now = poll[0];
            int step = poll[1];
            //System.out.println(now);
            if (now == end)
                visited[end] = Math.min(visited[end], step);
            // if (now > end * 2)
            //     continue;
            int temp = now * 2;
            while (temp < end * 2 && temp < 100001 && temp != 0) {
                
                if (visited[temp] > step) {
                    que.add(new int[] { temp, step });
                    visited[temp] = step;
                }
                temp *= 2;
            }

            if (now < 100000 && visited[now + 1] > step + 1) {
                que.add(new int[] { now + 1, step + 1 });
                visited[now + 1] = step + 1;
            }

            if (now != 0 && visited[now - 1] > step + 1) {
                que.add(new int[] { now - 1, step + 1 });
                visited[now - 1] = step + 1;
            }
        }

        return visited[end];
    }
}
