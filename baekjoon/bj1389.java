//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int people = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> relation = new ArrayList<>(people + 1);
        for (int i = 0; i < people + 1; i++) {
            relation.add(new ArrayList<Integer>(people + 1));
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation.get(a).add(b);
            relation.get(b).add(a);
        }
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= people; i++) {
            int temp = serch(relation, i);
            if (min > temp) {
                result = i;
                min = temp;
            }

        }
        System.out.println(result);
    }

    private static int serch(ArrayList<ArrayList<Integer>> relation, int start) {
        Boolean vistited[] = new Boolean[relation.size()];
        Arrays.fill(vistited, false);
        int count = 0;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { start, 0 });
        vistited[start] = true;
        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int now = temp[0];
            int step = temp[1];

            for (int i : relation.get(now)) {
                if (!vistited[i]) {
                    que.add(new int[] { i, step + 1 });
                    vistited[i] = true;
                    count += step + 1;
                }
            }
        }
        return count;

    }

}
