import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            String point = br.readLine();
            StringTokenizer st = new StringTokenizer(point, " ");
            xy[i][0]=Integer.parseInt(st.nextToken());
            xy[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xy,(x,y)->{
            if(x[0]==y[0])
                return x[1]-y[1];
            else
                return x[0]-y[0];
        });
        for (int i = 0; i < n; i++) {
			System.out.println(xy[i][0] + " " + xy[i][1]);
		}

    }
}
