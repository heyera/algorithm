//Sort_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int timeTable[][] = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(timeTable, ((o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        }));

        int count = 0;
        int endTime = 0;
        for (int i = 0; i < timeTable.length; i++) {
            if (endTime <= timeTable[i][0]) {
                count += 1;
                endTime = timeTable[i][1];
            }
        }
        System.out.println(count);
    }
}
