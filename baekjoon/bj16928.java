//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int bridge = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        int board[] = new int[101];
        for (int i = 1; i < 101; i++) {
            board[i] = i;
        }
        for (int i = 0; i < bridge + snake; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        System.out.println(game(board));

    }

    private static int game(int[] board) {
        Queue<int[]> que = new LinkedList<>();
        boolean visited[] = new boolean[101];
        que.add(new int[] { 1, 0 });
        visited[1] = true;
        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int now = temp[0];
            int diceCount = temp[1];
            if (now >= 100) {
                return diceCount;
            }
            for (int i = 1; i < 7; i++) {
                if (now + i < 101 && !visited[i + now]) {
                    que.add(new int[] { board[now + i], diceCount + 1 });
                    visited[i + now] = true;
                }
            }
        }

        return -1;
    }
}
