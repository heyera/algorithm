import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16173 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int map[][] = new int[N][N];
        boolean visited[][] = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        Queue<int[]> que = new LinkedList<>();
        boolean success = false;
        que.add(new int[] { 0, 0 });
        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int row = temp[0];
            int cols = temp[1];
            visited[row][cols] = true;

            if (map[row][cols] == -1) {
                success = true;
                break;
            }
            int down = row + map[row][cols];
            int ringht = cols + map[row][cols];
            if(down<map.length&&!visited[down][cols]){
                que.add(new int[] {down, cols});
                visited[down][cols]=true;
            }
            if(ringht<map.length&&!visited[row][ringht]){
                que.add(new int[] {row, ringht});
                visited[row][ringht]=true;
            }

        }
        if(success==true){
            System.out.println("HaruHaru");
        }
        else{
            System.out.println("Hing");
        }

    }

    

}
