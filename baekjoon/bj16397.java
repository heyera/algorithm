//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int number = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        System.out.println(escape(number, max, target));

    }

    static private String escape(int number, int max, int target) {
        Queue<int[]> que = new LinkedList<>();
        int visited[] = new int[100000];
        Arrays.fill(visited, Integer.MAX_VALUE);

        que.add(new int[] { number, 0 });
        visited[number] = 0;

        while (!que.isEmpty()) {
            int poll[] = que.poll();
            int now = poll[0];
            int count = poll[1];
            if (now == target) {
                visited[target] = Math.min(visited[target], count);
            }
            if (count == max) {
                continue;
            }
            if (99999 > now && visited[now + 1] > count + 1) {
                que.add(new int[] { now + 1, count + 1 });
                visited[now + 1] = count + 1;
            }
            int pushBButton = bButton(now);
            if (99999 > now * 2 && visited[pushBButton] > count + 1) {
                que.add(new int[] { pushBButton, count + 1 });
                visited[pushBButton] = count + 1;
            }
        }
        if (visited[target] == Integer.MAX_VALUE)
            return "ANG";
        return visited[target] + "";
    }

    static private int bButton(int number) {
        int temp = (int) Math.log10(number*2);
        return (int) (number * 2 - Math.pow(10, temp));
    }
}
