import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[] = new int[n];
        boolean visited[] = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < map.length; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { 0, 0 });
        visited[0] = true;

        int dist = -1;

        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int point = temp[0];
            int dis = temp[1];
            //System.out.printf("pont - %d,  dis - %d, now - %d\n", point, dis, map[point]);

            if (point == n-1) {
                dist = dis;
                break;
            }

            for (int i = 1; i <= map[point]; i++) {
                if (point + i < n) {
                    if (visited[point + i] != true) {
                        que.add(new int[] { point + i, dis + 1 });
                        visited[point + i] = true;
                    }
                }

            }
        }
        System.out.println(dist);

    }
}
