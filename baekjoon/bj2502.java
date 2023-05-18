//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int day = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int fst[] = new int[day + 1];
        int sec[] = new int[day + 1];

        fst[1] = 1;
        sec[2] = 1;
        // dp[1][1] = 1;
        // dp[2][1] = 1;
        // dp[2][2] = 1;

        for (int i = 3; i < day + 1; i++) {
            fst[i] = fst[i - 1] + fst[i - 2];
            sec[i] = sec[i - 1] + sec[i - 2];
        }

        for (int i = 1; i < num; i++) {
            for (int j = i; j < num; j++) {
                int one = i * fst[day];
                int two = j * sec[day];
                if (one + two > num)
                    break;
                if (one + two == num) {
                    //System.out.println(fst[day]+" "+sec[day]);
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }

        /*
         * a,b,ab,a2b,2a3b,3a5b...
         */

    }
}