//Dijkstra_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        ArrayList<int[]> map[] = new ArrayList[city + 1];
        for (int i = 1; i < city + 1; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            map[start].add(new int[] { end, pay });
        }

        st = new StringTokenizer(br.readLine(), " ");
        int go = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());

        System.out.println(serch(map, go, finish));
    }

    private static int serch(ArrayList<int[]>[] map, int go, int finish) {
        int disPay[] = new int[map.length];
        Arrays.fill(disPay, Integer.MAX_VALUE);

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { go, 0 });
        disPay[go] = 0;

        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int now = temp[0];
            int pay = temp[1];

            if (disPay[now] < pay)
                continue;

            for (int i[] : map[now]) {
                int next = i[0];
                int nextPay = i[1] + pay;

                if (disPay[next] > nextPay) {
                    que.add(new int[] { next, nextPay });
                    disPay[next] = Math.min(disPay[next], nextPay);
                }
            }

        }
        return disPay[finish];
    }
}
