import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2606 {
    static int computer;
    static int network;
    static int count=0;
    static int networkList[][];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());
        network = Integer.parseInt(br.readLine());

        networkList = new int[computer + 1][computer + 1];
        visit = new boolean[computer + 1];

        for (int i = 0; i < network; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            networkList[a][b] =networkList[b][a] = 1;
        }
        System.out.println(dfs(1));
    }

    private static int dfs(int i) {
        visit[i] = true;

        for (int j = 1; j < computer + 1; j++) {
            if (networkList[i][j] == 1 && visit[j] == false) {
                count+=1;
                dfs(j);
            }
        }
        return count;
    }
}