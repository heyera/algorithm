//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }
        hacking(node, graph);

    }

    private static void hacking(int node, ArrayList<ArrayList<Integer>> graph) {
        int result[] = new int[node + 1];
        int max = 0;

        for (int i = 1; i < node + 1; i++) {
            boolean visited[] = new boolean[node + 1];
            

            Queue<Integer> que = new LinkedList<>();
            que.add(i);
            visited[i] = true;

            while (!que.isEmpty()) {
                int num = que.poll();

                for (int temp:graph.get(num) ) {
                    if (visited[temp] != true) {
                        que.add(temp);
                        visited[temp] = true;
                        result[i] += 1;
                    }
                }
            }

            max = Math.max(max, result[i]);
        }

        //StringBuilder sb = new StringBuilder();

        for (int i = 1; i < node + 1; i++) {
            if (result[i] == max){
                System.out.print(i);
                System.out.print(" ");
            }
                //sb.append(i).append(" ");
                //System.out.print(result[i]+" ");
        }

        //System.out.println();
        //System.out.println(sb);
    }
}
