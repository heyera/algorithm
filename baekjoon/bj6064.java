//Math_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int m, n, x, y;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int max = 1; // m과 n의 최소공배수
            // m과 n 의 최소배수 찾는 과정(max)
            for (int j = 2; j <= Math.min(m, n); j++) {
                if (m % j == 0 && n % j == 0) {
                    max = j;
                }
            }
            max = (n * m) / max;

            int year = x;
            while (true) {
                int xyear = year % m;
                int yyear = year % n;
                if (xyear == 0)
                    xyear = m;
                if (yyear == 0)
                    yyear = n;
                if (year > max) {
                    sb.append("-1").append("\n");
                    break;
                }
                if (xyear == x && yyear == y) {
                    sb.append(year).append("\n");
                    break;
                }
                year += m;
            }
        }
        System.out.println(sb);
    }
}
