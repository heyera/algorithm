//BFS_Java

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int subin = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());

        System.out.println(serch(subin, bro));
    }

    private static int serch(int start, int end) {
        boolean vistited[] = new boolean[100001];

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { start, 0 });

        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int loc = temp[0];
            int time = temp[1];

            if (end == loc) {
                return time;
            }

            if (loc - 1 > -1 && !vistited[loc - 1]) {
                que.add(new int[] { loc - 1, time + 1 });
                vistited[loc - 1] = true;
            }
            if (loc + 1 < 100001 && !vistited[loc + 1]) {
                que.add(new int[] { loc + 1, time + 1 });
                vistited[loc + 1] = true;
            }
            if (loc * 2 < 100001 && !vistited[loc * 2]) {
                que.add(new int[] { loc * 2, time + 1 });
                vistited[loc * 2] = true;

            }
        }
        return -1;
    }
}
