//BFS_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class bj16940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());

        ArrayList<Integer> map[] = new ArrayList[node + 1];
        for (int i = 1; i < node + 1; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < node - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        int input[] = new int[node];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(specilBFS(map, node, input));

    }

    static private int specilBFS(ArrayList<Integer>[] map, int size, int[] input) {
        if (input[0] != 1) {
            return 0;
        }
        // 문제에서 1로 시작한다고 했으므로 input에서 첫 수가 1이아니면 무조건 틀림

        boolean result = true;
        boolean visited[] = new boolean[size + 1];
        int count = 0;

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = true;
        count += 1;

        while (!que.isEmpty()) {
            if (count == input.length || !result)
                break;

            int now = que.poll();
            // System.out.println("now " + now);
            //nowCount는 첫 count의 위치를 알아야 탐색범위를 설정 할 수 있기 때문
            int nowCount = count;
            // set에 방문할 노드를 삽입
            Set<Integer> nowSet = new HashSet<>();

            for (int i : map[now]) {

                if (!visited[i]) {
                    nowSet.add(i);
                    count += 1;
                }
            }
            // System.out.println("nowSet " + nowSet);

            // count와 nowCount가 같으면 탐색할 노드가 없다고 판단
            if (count == nowCount)
                continue;
            
            Set<Integer> inputSet = new HashSet<>();
            for (int i = nowCount; i < count; i++) {
                inputSet.add(input[i]);
            }
            // System.out.println("inputSet " + inputSet);

            Set<Integer> union = new HashSet<>(nowSet);
            union.addAll(inputSet);
            //합쳤는데 갯수차이가 난다면 두 set은 같이않음
            if (union.size() != nowSet.size()) {
                return 0;
            }

            for (int i = nowCount; i < count; i++) {
                que.add(input[i]);
                visited[input[i]] = true;
            }

        }

        if (result)
            return 1;
        return 0;
    }
}
/*
 * 만든 예제
 * 
 * 5
 * 1 2
 * 1 3
 * 2 4
 * 3 5
 * 1 3 2 5 4
 * 
 * 8
 * 1 2
 * 1 3
 * 2 4
 * 3 5
 * 3 6
 * 6 7
 * 4 8
 * 1 3 2 5 6 4 7 8
 */