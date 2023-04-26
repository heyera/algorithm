//Bruteforcing_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1107 {
    public static void main(String[] args) throws IOException {
        int now = 100;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine());
        int brokenNum = Integer.parseInt(br.readLine());
        Boolean botton[] = new Boolean[10];

        for (int i = 0; i < 10; i++) {
            botton[i] = true;
        }
        if (brokenNum > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < brokenNum; i++) {
                botton[Integer.parseInt(st.nextToken())] = false;
            }
        }

        // 100에서 눌러서 가는경우
        // 남은 버튼중 제일 가까운수로 가는 경우

        int min = Math.abs(channel - now);

        for (int i = 0; i < 1000000; i++) {
            int count = check(i, botton);
            if (count > 0) {
                min = min > Math.abs(channel - i) + count ? Math.abs(channel - i) + count : min;
            }
        }
        System.out.println(min);
    }

    private static int check(int num, Boolean[] botton) {
        if (num == 0) {
            if (!botton[0])
                return -1;
            else
                return 1;
        }
        int count = 0;
        while (num > 0) {
            if (!botton[num % 10])
                return -1;
            count += 1;
            num /= 10;
        }

        return count;
    }

}