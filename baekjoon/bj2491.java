import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxasc = 1;
        int maxdesc = 1;
        int asc = 1;
        int desc = 1;
        int numArr[] = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            // System.out.println("asc    " + maxasc);
            // System.out.println("desc   " + maxdesc);
            // System.out.println();
            if (numArr[i - 1] > numArr[i]) {
                desc += 1;
                asc = 1;
                maxdesc = Math.max(desc, maxdesc);
                continue;
            }
            if (numArr[i - 1] < numArr[i]) {
                desc = 1;
                asc += 1;
                maxasc = Math.max(asc, maxasc);
                continue;
            }
            if (numArr[i - 1] == numArr[i]) {
                desc += 1;
                asc += 1;
                maxasc = Math.max(asc, maxasc);
                maxdesc = Math.max(desc, maxdesc);
                continue;
            }
            desc = asc = 1;
        }
        System.out.println(Math.max(maxasc, maxdesc));
    }

}
