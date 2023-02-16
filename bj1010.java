import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1010 {
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr= new int[31][31];
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(combi(M, N));

        }

    }
    private static int combi(int M, int N){
        if(M==0||N==0){
            return 1;
        }
        if(N==M){
            return 1;
        }
        if(N==1){
            return M;
        }
        if(arr[M][N]>0){
            return arr[M][N];
        }
        arr[M][N]=combi(M-1, N)+combi(M-1, N-1);
        return arr[M][N];
    }
}
