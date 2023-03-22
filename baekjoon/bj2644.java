import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2644 {
    static ArrayList<ArrayList<Integer>> family;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        family = new ArrayList<>(people + 1);
        for (int i = 1; i <= people + 1; i++) {
            family.add(new ArrayList<Integer>());
        }
        int edge = Integer.parseInt(br.readLine());
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            family.get(a).add(b);
            family.get(b).add(a);
        }
        System.out.println(bfs(A, B));
    }

    public static int bfs(int A, int B) {
        boolean visited[] = new boolean[family.size()];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { A, 0 });
        while (!que.isEmpty()) {
            int arr[] = que.poll();
            int poll = arr[0];
            int dis = arr[1];
            visited[poll] = true;
            if (poll == B) {
                return dis;
            }
            for (int i = 0; i < family.get(poll).size(); i++) {
                if (visited[family.get(poll).get(i)] != true)
                    que.add(new int[] { family.get(poll).get(i), dis + 1 });
            }
        }

        return -1;
    }
}
