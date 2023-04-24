//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int map[][] = new int[size][size];
        int result[][] = new int[size][size];

        StringTokenizer st;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < size; i++) {
            result[i] = bfs(i, map);
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.printf("%d ",result[i][j]);
            }
            System.out.println();
        }

    }

    private static int[] bfs(int start, int map[][]) {
        int visited[] = new int[map.length];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while (!que.isEmpty()) {
            int poll = que.poll();
            for (int i = 0; i < map.length; i++) {
                if (map[poll][i] == 1 && visited[i] != 1) {
                    que.add(i);
                    visited[i] = 1;
                }
            }
        }
        return visited;
    }

}
